package com.example.quanlydatphong.dto.request.User;

import lombok.Data;

@Data
public class UserCreationRequest {
    private String fullName;

    private String username;

    private String password;

    private String role;
}
