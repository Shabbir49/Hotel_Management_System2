package com.example.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking , Integer>{

}
