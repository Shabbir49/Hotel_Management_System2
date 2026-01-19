package com.example.hotel.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.hotel.entity.Booking;
import com.example.hotel.repository.BookingRepository;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    // CREATE
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    // READ ALL
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // READ BY ID
    public Booking getBookingById(int id) {
        return bookingRepository.findById(id).orElse(null);
    }

    // UPDATE
    public Booking updateBooking(int id, Booking booking) {
        Booking existing = bookingRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setCustomerName(booking.getcustomerName());
            existing.setDays(booking.getDays());
            return bookingRepository.save(existing);
        }
        return null;
    }

    // DELETE
    public String deleteBooking(int id) {
        bookingRepository.deleteById(id);
        return "Booking Deleted";
    }
}
