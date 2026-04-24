package com.aricenter.sport.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name= "rooms")
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "name is mandatory")
    private String name;

    @NotBlank(message = "location is mandatory")
    private String location;

    @Min(value = 1,message = "capacity must be at least 1")
    @Max(value = 20, message = "capacity cannot exceed 20")
    private int capacity;
    @Column(name = "is_free", nullable = false)
    private Boolean isFree;

    public Rooms() {}

    public Rooms(String location, String name, Long id, Boolean isFree, int capacity) {
        this.location = location;
        this.name = name;
        this.id = id;
        this.isFree = isFree;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(Boolean is_free) {
        this.isFree = is_free;
    }
}
