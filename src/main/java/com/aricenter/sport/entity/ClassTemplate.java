package com.aricenter.sport.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name ="template")
public class ClassTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private SportType sportType;

    @ManyToOne
    private Rooms rooms;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    @NotBlank
    private String title;

    @Column(nullable = false)
    @Min(0)
    @Max(6)
    private int dayOfWeek;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    @Column(nullable = false)
    @Min(0)
    @Max(20)
    private int totalSports;

    @Column(nullable = false)
    @NotNull
    private Boolean isActive;

    @Column(nullable = false)
    @NotNull
    private LocalDate validFrom;
    @Column(nullable = false)
    private LocalDate validUntil;

    public ClassTemplate() {
    }

    public ClassTemplate(Long id, SportType sportType, Rooms rooms, User user, String title, int dayOfWeek, LocalTime startTime, LocalTime endTime, int totalSports, Boolean isActive, LocalDate validFrom, LocalDate validUntil) {
        this.id = id;
        this.sportType = sportType;
        this.rooms = rooms;
        this.user = user;
        this.title = title;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalSports = totalSports;
        this.isActive = isActive;
        this.validFrom = validFrom;
        this.validUntil = validUntil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rooms getRooms() {
        return rooms;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }

    public SportType getSportType() {
        return sportType;
    }

    public void setSportType(SportType sportType) {
        this.sportType = sportType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getTotalSports() {
        return totalSports;
    }

    public void setTotalSports(int totalSports) {
        this.totalSports = totalSports;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }

    public Long getSportTypeId() {
        return sportType != null ? sportType.getId() : null;
    }

    public Long getUserId() {
        return user != null ? user.getId() : null;
    }

    public Long getRoomId() {
        return rooms != null ? rooms.getId() : null;
    }

    public void setRoomId(Long roomId) {
        Rooms room = new Rooms();
        room.setId(roomId);

        this.rooms = room;
    }

    public void setSportTypeId(Long sportTypeId) {
        SportType sportType = new SportType();
        sportType.setId(sportTypeId);
        this.sportType = sportType;
    }

    public void setUserId(Long userId) {
        User user = new User();
        user.setId(userId);
        this.user = user;
    }

}
