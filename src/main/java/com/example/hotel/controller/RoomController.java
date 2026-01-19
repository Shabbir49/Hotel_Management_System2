package com.example.hotel.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.hotel.entity.Room;
import com.example.hotel.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomService.saveRoom(room);
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable int id) {
        return roomService.getRoomById(id);
    }

    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable int id,
                           @RequestBody Room room) {
        return roomService.updateRoom(id, room);
    }

    @DeleteMapping("/{id}")
    public String deleteRoom(@PathVariable int id) {
        return roomService.deleteRoom(id);
    }
}
