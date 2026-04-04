package com.example.quanlydatphong.service.impl;

import com.example.quanlydatphong.dto.request.User.UserCreationRequest;
import com.example.quanlydatphong.dto.request.User.UserUpdateRequest;
import com.example.quanlydatphong.dto.response.UserResponse;
import com.example.quanlydatphong.entity.User;
import com.example.quanlydatphong.exception.ResourceNotFoundException;
import com.example.quanlydatphong.mapper.UserMapper;
import com.example.quanlydatphong.repository.UserRepository;
import com.example.quanlydatphong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;

    public List<UserResponse> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses =userMapper.toResponseList(users);

        return userResponses;
    }

    public UserResponse getUserById(Long id) {
        User user=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Khong tin thay id: "+id));
        UserResponse userResponse = userMapper.toResponse(user);
        return userResponse;
    }

    public UserResponse createUser(UserCreationRequest request) {

        User user = userMapper.toEntity(request);
        String hashedPassword = passwordEncoder.encode(request.getPassword());
        user.setPassword(hashedPassword);
        User savedUser = userRepository.save(user);

        return userMapper.toResponse(savedUser);
    }

    public UserResponse updateUser(Long id,UserUpdateRequest request) {
        User user=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Khong tin thay id: "+id));
        user.setFullName(request.getFullName());
        user.setUsername(request.getUsername());
        String hashedPassword = passwordEncoder.encode(request.getPassword());
        user.setPassword(hashedPassword);
        user.setRole(request.getRole());
        userRepository.save(user);
        return userMapper.toResponse(user);
    }

    public UserResponse deleteUser(Long id) {
        User user=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Khong tin thay id: "+id));
        userRepository.deleteById(id);
        return userMapper.toResponse(user);
    }
}
