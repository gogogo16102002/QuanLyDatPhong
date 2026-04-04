package com.example.quanlydatphong.mapper;

import com.example.quanlydatphong.entity.User;
import com.example.quanlydatphong.dto.request.User.UserCreationRequest;
import com.example.quanlydatphong.dto.response.UserResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserCreationRequest request);

    UserResponse toResponse(User entity);

    List<UserResponse> toResponseList(List<User> users);
}
