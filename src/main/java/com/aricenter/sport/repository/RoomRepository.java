package com.aricenter.sport.repository;

import com.aricenter.sport.entity.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository  extends JpaRepository<Rooms, Long> {
    Rooms  findByName(String name);
    boolean existsByName(String name);
    List<Rooms> findByNameIn(List<String> saved);
    void deleteByName(String name);



}