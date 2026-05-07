package com.aricenter.sport.repository;

import com.aricenter.sport.entity.ClassTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassTemplateRepository extends JpaRepository<ClassTemplate, Long> {

}
