package com.example.quanlydatphong.service.impl;

import com.example.quanlydatphong.dto.request.UserCreationRequest;
import com.example.quanlydatphong.dto.response.UserResponse;
import com.example.quanlydatphong.entity.User;
import com.example.quanlydatphong.exception.ResourceNotFoundException;
import com.example.quanlydatphong.mapper.UserMapper;
import com.example.quanlydatphong.repository.UserRepository;
import com.example.quanlydatphong.service.UserService;
import org.mapstruct.control.MappingControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public List<UserResponse> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses =users.stream().map(x->userMapper.toResponse(x)).toList();

        return userResponses;
    }

    public UserResponse getUserById(Long id) {
        User user=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Khong tin thay id: "+id));
        UserResponse userResponse = userMapper.toResponse(user);
        return userResponse;
    }

    public UserResponse createUser(UserCreationRequest request) {

        User user = userMapper.toEntity(request);

        User savedUser = userRepository.save(user);

        return userMapper.toResponse(savedUser);
    }
}
