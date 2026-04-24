package com.aricenter.sport.service;

import com.aricenter.sport.entity.Rooms;
import com.aricenter.sport.repository.RoomRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(final RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    //for one room
    public Rooms save(Rooms room) {
        if(room == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing mandatory filed");
        }

        if(room.getName() == null || room.getName().trim().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing room name");
        }

        if(room.getLocation() == null || room.getLocation().trim().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing room location");
        }

        if(!room.getIsFree()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Room is ocuppaded");
        }

       if(room.getCapacity() <= 0 ||  room.getCapacity() > 20){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Room capacity must be between 1 and 20");
       }

        String name = room.getName().trim();

       if(roomRepository.existsByName(name)){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Room name already exists");
       }

        room.setName(name);
        return roomRepository.save(room);
    }

    //for multiple rooms
    @Transactional
    public List<Rooms> saveAllRooms(@Valid List<@Valid Rooms> roomsList) {
        if(roomsList == null || roomsList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empty request");
        }

        List<String> saved =  new ArrayList<>();

        for(Rooms room : roomsList){
            if(room.getName() == null || room.getName().trim().isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing room name");
            }

            String trimmedName = room.getName().trim();

            if(saved.contains(trimmedName)){
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Room name already exists");
            }

            saved.add(trimmedName);
            room.setName(trimmedName);
        }

        List<Rooms> existingRooms = roomRepository.findByNameIn(saved);

        if(!existingRooms.isEmpty()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Room name already exists");
        }

        return roomRepository.saveAll(roomsList);
    }

    @Transactional
    public void deleteByName(String name) {
       if( name == null || name.trim().isEmpty()){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid room name!");
       }

       String trimmedName = name.trim();

       if(!roomRepository.existsByName(trimmedName)){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found!");
       }
       roomRepository.deleteByName(trimmedName);
    }
}