package com.example.quanlydatphong.service;

import com.example.quanlydatphong.dto.request.User.UserCreationRequest;
import com.example.quanlydatphong.dto.request.User.UserUpdateRequest;
import com.example.quanlydatphong.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getUsers();
    UserResponse getUserById(Long id);
    UserResponse createUser(UserCreationRequest request);
    UserResponse updateUser(Long id,UserUpdateRequest request);
    UserResponse deleteUser(Long id);
}
