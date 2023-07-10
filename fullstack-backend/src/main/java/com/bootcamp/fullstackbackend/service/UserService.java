package com.bootcamp.fullstackbackend.service;

import com.bootcamp.fullstackbackend.dto.LoginDto;
import com.bootcamp.fullstackbackend.dto.UserDto;
import com.bootcamp.fullstackbackend.response.LoginResponse;

public interface UserService {
    String addUser(UserDto userDto);

    LoginResponse loginUser(LoginDto loginDto);
}
