package com.aricenter.sport.controller;

import com.aricenter.sport.dto.UserResponse;
import com.aricenter.sport.entity.User;
import com.aricenter.sport.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

  private final UserService userService;

  public UserController(final UserService userService) {
      this.userService = userService;
  }

  @PostMapping("create")
    public ResponseEntity<UserResponse> save(@Valid @RequestBody User user){
      User saved = userService.save(user);
      return ResponseEntity.status(HttpStatus.CREATED).body(new UserResponse("User is created.", List.of(saved)));
  }

  @DeleteMapping("/{email}/{firstName}")
  public ResponseEntity<Void> delete(@PathVariable String email,@PathVariable String firstName) {

    userService.deleteByEmailAndName(email, firstName);

    return ResponseEntity.noContent().build();
  }
}
