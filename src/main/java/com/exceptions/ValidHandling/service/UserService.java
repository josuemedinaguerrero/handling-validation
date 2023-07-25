package com.exceptions.ValidHandling.service;

import com.exceptions.ValidHandling.dto.UserRequest;
import com.exceptions.ValidHandling.entity.User;
import com.exceptions.ValidHandling.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public User getUserById(int id) {
    return userRepository.findById(id).get();
  }

  public List<User> getAllUsersFromDB() {
    return userRepository.findAll();
  }

  public User insertUser(UserRequest userRequest) {
    User user = new User();
    user.setName(userRequest.getName());
    user.setAge(userRequest.getAge());
    user.setSalary(userRequest.getSalary());
    user.setEmail(userRequest.getEmail());
    user.setAddress(userRequest.getAddress());
    return userRepository.save(user);
  }

}
