package com.exceptions.ValidHandling.controller;

import com.exceptions.ValidHandling.dto.UserRequest;
import com.exceptions.ValidHandling.entity.User;
import com.exceptions.ValidHandling.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/findAll")
  public List<User> findAllUsersFromDB() {
    return userService.getAllUsersFromDB();
  }

  @GetMapping("/user/{id}")
  public User findUserById(@PathVariable int id) {
    return userService.getUserById(id);
  }

  @PostMapping("/insert")
  public User insertUser(@RequestBody @Valid UserRequest userRequest) {
    return userService.insertUser(userRequest);
  }

}
