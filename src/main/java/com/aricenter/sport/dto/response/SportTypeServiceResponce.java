package com.aricenter.sport.dto.response;

import com.aricenter.sport.entity.SportType;
import java.util.List;

public class SportTypeServiceResponce {
    private String message;
    private List<SportType> data;

    public SportTypeServiceResponce(String message, List<SportType> data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public List<SportType> getData() {
        return data;
    }
}
