package com.bootcamp.fullstackbackend.controller;

import com.bootcamp.fullstackbackend.dto.LoginDto;
import com.bootcamp.fullstackbackend.dto.UserDto;
import com.bootcamp.fullstackbackend.response.LoginResponse;
import com.bootcamp.fullstackbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String saveUser (@RequestBody UserDto userDto){
        String id = userService.addUser(userDto);
        return id;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto){
        LoginResponse loginResponse = userService.loginUser(loginDto);
        return ResponseEntity.ok(loginResponse);
    }
}
