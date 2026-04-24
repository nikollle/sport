package com.aricenter.sport.dto.response;

import com.aricenter.sport.entity.Rooms;

import java.util.List;

public class RoomServiceResponse {
    private String massage;
    private List<Rooms> data;

    public RoomServiceResponse(String massage, List<Rooms> data) {
        this.massage = massage;
        this.data = data;
    }

    public String getMassage() {
        return massage;
    }

    public List<Rooms> getData() {
        return data;
    }

}
