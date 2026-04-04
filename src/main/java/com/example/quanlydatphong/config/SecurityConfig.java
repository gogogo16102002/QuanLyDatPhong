package com.example.quanlydatphong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // 1. Khai báo công cụ mã hóa BCrypt
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 2. Mở khóa tạm thời cho các API (Vì khi cài Spring Security, mặc định nó sẽ chặn toàn bộ API của bạn)
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Tắt chống giả mạo request (cần khi làm API)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/users/**").permitAll() // Cho phép tất cả truy cập vào API users mà không cần đăng nhập
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}
