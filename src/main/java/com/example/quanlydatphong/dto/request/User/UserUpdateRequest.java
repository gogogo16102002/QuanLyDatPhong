package com.example.quanlydatphong.dto.request.User;

import lombok.Data;

@Data
public class UserUpdateRequest {
    private String fullName;

    private String username;

    private String password;

    private String role;
}
