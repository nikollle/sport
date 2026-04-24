package com.aricenter.sport.controller;

import com.aricenter.sport.entity.SportType;
import com.aricenter.sport.service.SportTypeService;
import com.aricenter.sport.dto.response.SportTypeServiceResponce;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sport-type")
public class SportTypeController {
    private final SportTypeService sportTypeService;

    public SportTypeController(final SportTypeService sportTypeService) {
        this.sportTypeService = sportTypeService;
    }

    @PostMapping("create")
    public ResponseEntity<SportTypeServiceResponce> save(@RequestBody SportType sportType){
       SportType saved =  sportTypeService.save(sportType);

       return ResponseEntity.status(201).body(new SportTypeServiceResponce("Sport is created",List.of(saved)));
    }


   @PostMapping("create/multi-sports")
   public ResponseEntity<SportTypeServiceResponce> saveAll(@RequestBody List<SportType> sportTypeList) {

       List<SportType> saved = sportTypeService.saveAll(sportTypeList);

       return ResponseEntity.status(201).body(new SportTypeServiceResponce("Sport types created successfully", saved));
   }

  @DeleteMapping("/{name}")
    public ResponseEntity<Void> delete(@PathVariable String name){
        sportTypeService.deleteByName(name);
        return ResponseEntity.noContent().build();
  }

}
