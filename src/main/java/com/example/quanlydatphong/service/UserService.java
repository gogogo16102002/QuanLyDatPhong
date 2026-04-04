package com.example.quanlydatphong.service;

import com.example.quanlydatphong.dto.request.UserCreationRequest;
import com.example.quanlydatphong.dto.response.UserResponse;
import com.example.quanlydatphong.repository.UserRepository;

import java.util.List;

public interface UserService {
    List<UserResponse> getUsers();
    UserResponse getUserById(Long id);
    UserResponse createUser(UserCreationRequest request);
}
