package com.bootcamp.fullstackbackend.service.impl;


import com.bootcamp.fullstackbackend.dto.LoginDto;
import com.bootcamp.fullstackbackend.dto.UserDto;
import com.bootcamp.fullstackbackend.entity.User;
import com.bootcamp.fullstackbackend.repositories.UserRepo;
import com.bootcamp.fullstackbackend.response.LoginResponse;
import com.bootcamp.fullstackbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDto userDto) {
        User user = new User(
                userDto.getUserId(),
                userDto.getUsername(),
                userDto.getEmail(),

                this.passwordEncoder.encode(userDto.getPassword())
        );

        userRepo.save(user);
        return user.getUsername();
    }

    @Override
    public LoginResponse loginUser(LoginDto loginDto) {
        String msg = " ";
        User user1 = userRepo.findByEmail(loginDto.getEmail());
        if (user1 != null) {
            String password = loginDto.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean validPassword = passwordEncoder.matches(password, encodedPassword);
            if (validPassword){
                Optional<User> user = userRepo.findByEmailAndPassword(loginDto.getEmail(), encodedPassword);
                if (user.isPresent()){
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("Password incorrect", false);
            }
        } else {
            return new LoginResponse("Email does not exist", false);
        }
    }
}
