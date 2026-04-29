package com.aricenter.sport.repository;

import com.aricenter.sport.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {

    boolean existsByEmail(String email);
    boolean existsByEmailAndFirstName(String email, String firstName);

    List<User> findByEmailIn(List<String> emails);
    void deleteByEmailAndFirstName(String email, String firstName);

}
