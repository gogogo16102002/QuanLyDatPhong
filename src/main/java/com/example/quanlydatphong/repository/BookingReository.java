package com.example.quanlydatphong.repository;

import com.example.quanlydatphong.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingReository extends JpaRepository<Booking,Long> {

    @Query("SELECT COUNT(b) > 0 FROM Booking b WHERE b.room.id = :roomId " +
            "AND b.startTime < :newEnd AND b.endTime > :newStart " +
            "AND b.status != 'CANCELLED'")
    boolean isRoomOccupied(@Param("roomId") Long roomId,
                           @Param("newStart") LocalDateTime newStart,
                           @Param("newEnd") LocalDateTime newEnd);
    List<Booking> findByUserId(Long userId);
    List<Booking> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);
    List<Booking> findByRoomIdAndStatusNot(Long roomId, String status);
}
