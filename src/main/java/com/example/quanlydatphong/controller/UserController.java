package com.example.quanlydatphong.controller;

import com.example.quanlydatphong.dto.request.User.UserCreationRequest;
import com.example.quanlydatphong.dto.request.User.UserUpdateRequest;
import com.example.quanlydatphong.dto.response.UserResponse;
import com.example.quanlydatphong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("id") Long id){
        UserResponse user =userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserCreationRequest request){
        UserResponse userResponse= userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable("id") Long id, @RequestBody UserUpdateRequest request){
        UserResponse userResponse =userService.updateUser(id,request);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable("id") Long id){
        UserResponse user =userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
