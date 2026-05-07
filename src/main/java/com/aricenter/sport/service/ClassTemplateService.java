package com.aricenter.sport.service;

import com.aricenter.sport.entity.ClassTemplate;
import com.aricenter.sport.entity.Rooms;
import com.aricenter.sport.entity.SportType;
import com.aricenter.sport.entity.User;
import com.aricenter.sport.repository.ClassTemplateRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassTemplateService {
    private final ClassTemplateRepository classTemplateRepository;

    public ClassTemplateService(ClassTemplateRepository classTemplateRepository) {
        this.classTemplateRepository = classTemplateRepository;
    }

    public List<ClassTemplate> create(List<ClassTemplate> requests){

        List<ClassTemplate> entities = requests.stream().map(req -> {
            ClassTemplate t = new ClassTemplate();

            SportType sportType = new SportType();
            sportType.setId(req.getSportTypeId());

            Rooms room = new Rooms();
            room.setId(req.getRoomId());

            User user = new User();
            user.setId(req.getUserId());

            t.setSportType(sportType);
            t.setRooms(room);
            t.setUser(user);

            t.setTitle(req.getTitle());
            t.setDayOfWeek(req.getDayOfWeek());
            t.setStartTime(req.getStartTime());
            t.setEndTime(req.getEndTime());
            t.setTotalSports(req.getTotalSports());
            t.setActive(req.getIsActive());
            t.setValidFrom(req.getValidFrom());
            t.setValidUntil(req.getValidUntil());

            return t;
        }).toList();

        return classTemplateRepository.saveAll(entities);
    }
}
