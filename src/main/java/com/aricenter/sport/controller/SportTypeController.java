package com.aricenter.sport.controller;

import com.aricenter.sport.entity.SportType;
import com.aricenter.sport.service.SportTypeService;
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
    public SportType save(@RequestBody SportType sportType){
       return sportTypeService.save(sportType) ;
   }

   @PostMapping("create/multiSports")
    public List<SportType> saveAll(@RequestBody List<SportType> sportTypeList){
        return  sportTypeService.saveAll(sportTypeList);
   }

  @DeleteMapping("/{name}")
    public ResponseEntity<Void> delete(@PathVariable String name){
        sportTypeService.deleteByName(name);
        return ResponseEntity.noContent().build();
  }

}
