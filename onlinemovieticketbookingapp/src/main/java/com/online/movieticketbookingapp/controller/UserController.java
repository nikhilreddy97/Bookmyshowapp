package com.online.movieticketbookingapp.controller;

import com.online.movieticketbookingapp.dto.UserDto;
import com.online.movieticketbookingapp.entity.User;
import com.online.movieticketbookingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<String> creatUser(@RequestBody User user) throws Exception {
        service.creatUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto user){
        service.login(user);
        return ResponseEntity.status(HttpStatus.OK).body("Logged In Successfull");
    }
}
