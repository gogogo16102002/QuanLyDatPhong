package com.example.quanlydatphong.repository;

import com.example.quanlydatphong.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReposirory extends JpaRepository<User,Long> {

}
