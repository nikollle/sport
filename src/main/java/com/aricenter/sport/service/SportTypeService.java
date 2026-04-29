package com.aricenter.sport.service;

import com.aricenter.sport.entity.SportType;
import com.aricenter.sport.repository.SportTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@Service
public class SportTypeService {
   private final SportTypeRepository sportTypeRepository;

    public  SportTypeService(final SportTypeRepository sportTypeRepository) {
        this.sportTypeRepository = sportTypeRepository;
    }

    //za edin sport
    public SportType save(SportType sportType){
       if(sportType == null){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Missing mandatory filed");
       }

       if(sportType.getName() == null || sportType.getName().trim().isEmpty()){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Missing name");
       }

       String name = sportType.getName().trim();

       if(sportTypeRepository.existsByName(name)){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Sport type already exists");
       }

       sportType.setName(name);
       return sportTypeRepository.save(sportType);
    }

    //za mnogo sportove
   /* public List<SportType> saveAll(List<SportType> sportTypes) {

        if (sportTypes == null || sportTypes.isEmpty()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Empty request");
        }

        List<SportType> saved = new ArrayList<>();

        for (SportType sportType : sportTypes) {
            try {
                if (sportType.getName() == null || sportType.getName().trim().isEmpty()) {
                    continue;
                }

                String name = sportType.getName().trim();

                if (sportTypeRepository.existsByName(name)) {
                    continue;
                }

                sportType.setName(name);

                saved.add(sportTypeRepository.save(sportType));

            } catch (Exception e) {
                System.out.println("Skipped invalid sport type: " + e.getMessage());
            }
        }

        return saved;
    }*/

    @Transactional
    public List<SportType> saveAll(@RequestBody List<SportType> sportTypeList){
        if(sportTypeList == null || sportTypeList.isEmpty()){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Empty request");
        }

        List<String> saved = new ArrayList<>();

        for(SportType sportType : sportTypeList){
            if(sportType.getName() == null || sportType.getName().trim().isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing name");
            }

            String trimmedName = sportType.getName().trim();

            if(saved.contains(trimmedName)){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Duplicated name");
            }
            saved.add(trimmedName);
            sportType.setName(trimmedName);
        }

        List<SportType> exist = sportTypeRepository.findByNameIn(saved);
        if(!exist.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Sport is existing already");
        }

        return sportTypeRepository.saveAll(sportTypeList);
    }

   //delete
   @Transactional
   public void deleteByName(String name){
        if(name == null || name.trim().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid sport name");
        }

        String trimmedName = name.trim();

        if(!sportTypeRepository.existsByName(trimmedName)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Class not found");
        }

        sportTypeRepository.deleteByName(trimmedName);
   }
}
