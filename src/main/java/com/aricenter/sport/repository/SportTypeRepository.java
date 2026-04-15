package com.aricenter.sport.repository;

import com.aricenter.sport.entity.SportType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportTypeRepository extends JpaRepository<SportType, Long> {
   SportType findByName(String name);

    boolean existsByName(String name);
    List<SportType> findByNameIn(List<String> names);

    void deleteByName(String name);
}
