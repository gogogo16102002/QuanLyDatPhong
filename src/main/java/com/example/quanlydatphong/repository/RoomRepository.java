package com.example.quanlydatphong.repository;

import com.example.quanlydatphong.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
    List<Room> findByIsActiveTrue();
    List<Room> findByIsActiveFalse();
}
