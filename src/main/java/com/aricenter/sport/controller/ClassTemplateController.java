package com.aricenter.sport.controller;

import com.aricenter.sport.dto.response.ClassTemplateServiceResponse;
import com.aricenter.sport.entity.ClassTemplate;
import com.aricenter.sport.service.ClassTemplateService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/template")
public class ClassTemplateController {

    private final ClassTemplateService classTemplateService;

    public ClassTemplateController(ClassTemplateService classTemplateService) {
        this.classTemplateService = classTemplateService;
    }

    @PostMapping("/create")
    public ResponseEntity<List<ClassTemplate>> create(@Valid @RequestBody List<ClassTemplate> requests) {

        List<ClassTemplate> saved = classTemplateService.create(requests);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
