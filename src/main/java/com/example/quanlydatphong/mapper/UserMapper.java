package com.example.quanlydatphong.mapper;

import com.example.quanlydatphong.entity.User;
import com.example.quanlydatphong.dto.request.UserCreationRequest;
import com.example.quanlydatphong.dto.response.UserResponse;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserCreationRequest request);

    UserResponse toResponse(User entity);
}
