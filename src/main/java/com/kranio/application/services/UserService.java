package com.kranio.application.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import com.kranio.domain.repositories.IUserRepository;
import com.kranio.application.mappers.UserMapper;
import com.kranio.domain.classes.User;

@ApplicationScoped
public class UserService {

  @Inject
  private IUserRepository userRepository;

  @Inject
  private UserMapper userMapper;

  public void saveAndSendMessage(String message) {
    try {
      User user = userMapper.convertStringToUser(message);
      String response = userRepository.save(user);
      userRepository.sendMessage(response);
    } catch (Exception e) {
      System.err.println("Error saving User: " + e.getMessage());
    }
  }

  public void saveAndSendMessage(User user) {
    try {
      String response = userRepository.save(user);
      userRepository.sendMessage(response);
    } catch (Exception e) {
      System.err.println("Error saving User: " + e.getMessage());
    }
  }
}
