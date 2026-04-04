package com.example.quanlydatphong.controller;

import com.example.quanlydatphong.dto.response.UserResponse;
import com.example.quanlydatphong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers(){
        List<UserResponse> users =userService.getUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
