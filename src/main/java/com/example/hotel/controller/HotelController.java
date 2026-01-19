package com.example.hotel.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.hotel.entity.Hotel;
import com.example.hotel.service.HotelService;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    // CREATE
    @PostMapping
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return hotelService.saveHotel(hotel);
    }

    // READ ALL
    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Hotel getHotel(@PathVariable int id) {
        return hotelService.getHotelById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Hotel updateHotel(@PathVariable int id,
                             @RequestBody Hotel hotel) {
        return hotelService.updateHotel(id, hotel);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteHotel(@PathVariable int id) {
        return hotelService.deleteHotel(id);
    }
}
