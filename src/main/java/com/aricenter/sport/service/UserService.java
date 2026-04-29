package com.aricenter.sport.service;

import com.aricenter.sport.entity.User;
import com.aricenter.sport.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //creating a user
    public User saveUser(User user){
        if(user == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing mandatory filed");
        }

        if(user.getEmail() == null ||  user.getEmail().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing email filed");
        }

        String email = user.getEmail();

        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid email format");
        }

        if(user.getFirstName() == null ||  user.getFirstName().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing First Name filed");
        }

        if(user.getLastName() == null ||  user.getLastName().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing Last Name filed");
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing Password filed");
        }

        if(user.getPhoneNumber() == null || user.getPhoneNumber().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing Phone Number filed");
        }

        if(user.getRole() == null || user.getRole().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing Role filed");
        }


        if(userRepository.existsByEmail(email)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exist filed");
        }

        user.setEmail(email);

        return userRepository.save(user);
    }

    //delete user
    @Transactional
    public void deleteByEmailAndName(String firstName, String email){
        if(email == null || email.isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing email filed");
        }

        if(firstName == null || firstName.isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing First Name filed");
        }

        String trimmedEmail = email.trim();

        if (!trimmedEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid email format");
        }

        if(!userRepository.existsByEmailAndFirstName(firstName.trim(),trimmedEmail)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Email not found");
        }

        userRepository.deleteByEmailAndFirstName(firstName.trim(),trimmedEmail);
    }
}
