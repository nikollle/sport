package com.aricenter.sport.controller;

import com.aricenter.sport.entity.Rooms;
import com.aricenter.sport.service.RoomService;
import com.aricenter.sport.dto.response.RoomServiceResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rooms")
public class RoomController {
    private final RoomService roomService;

    public RoomController(final RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("create-room")
    public ResponseEntity<RoomServiceResponse> save(@Valid @RequestBody Rooms room){
        Rooms saved = roomService.save(room);
        return  ResponseEntity.status(HttpStatus.CREATED).body(new RoomServiceResponse("Room is created" , List.of(saved)));
    }

    @PostMapping("create-multiple-rooms")
    public ResponseEntity<RoomServiceResponse> saveAllRooms(@Valid @RequestBody List<@Valid Rooms> roomList){
        List<Rooms> saved = roomService.saveAllRooms(roomList);

        return ResponseEntity.status(HttpStatus.CREATED).body(new RoomServiceResponse("Rooms are created successfully",saved));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> delete(@PathVariable String name){
        roomService.deleteByName(name);
        return ResponseEntity.noContent().build();
    }
}