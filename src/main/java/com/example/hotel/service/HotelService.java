package com.example.hotel.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.hotel.entity.Hotel;
import com.example.hotel.repository.HotelRepository;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    // CREATE
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    // READ ALL
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    // READ BY ID
    public Hotel getHotelById(int id) {
        return hotelRepository.findById(id).orElse(null);
    }

    // UPDATE
    public Hotel updateHotel(int id, Hotel hotel) {
        Hotel existing = hotelRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(hotel.getName());
            existing.setCity(hotel.getCity());
            return hotelRepository.save(existing);
        }
        return null;
    }

    // DELETE
    public String deleteHotel(int id) {
        hotelRepository.deleteById(id);
        return "Hotel Deleted Successfully";
    }
}
