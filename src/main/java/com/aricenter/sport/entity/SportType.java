package com.aricenter.sport.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "sport_type")
public class SportType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    boolean isActive ;
    private String description;

    public SportType(){

    }

    public SportType(Long id, String name, boolean isActive, String description) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.description = description;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
