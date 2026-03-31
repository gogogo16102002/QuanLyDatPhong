package com.example.quanlydatphong.repository;

import com.example.quanlydatphong.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingReository extends JpaRepository<Booking,Long> {

}
