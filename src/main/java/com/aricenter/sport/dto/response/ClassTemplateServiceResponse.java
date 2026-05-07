package com.aricenter.sport.dto.response;

public class ClassTemplateServiceResponse {

    private Long id;
    private String title;
    private String message;

    public ClassTemplateServiceResponse(Long id, String title, String message) {
        this.id = id;
        this.title = title;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }
}