package com.example.hotel.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.hotel.entity.Room;
import com.example.hotel.repository.RoomRepository;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    // CREATE
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    // READ ALL
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    // READ BY ID
    public Room getRoomById(int id) {
        return roomRepository.findById(id).orElse(null);
    }

    // UPDATE
    public Room updateRoom(int id, Room room) {
        Room existing = roomRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setRoomType(room.getRoomType());
            existing.setPrice(room.getPrice());
            return roomRepository.save(existing);
        }
        return null;
    }

    // DELETE
    public String deleteRoom(int id) {
        roomRepository.deleteById(id);
        return "Room Deleted";
    }
}
