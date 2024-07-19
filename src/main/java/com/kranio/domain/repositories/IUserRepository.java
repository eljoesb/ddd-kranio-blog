package com.kranio.domain.repositories;

import com.kranio.domain.classes.User;

public interface IUserRepository {
  public void sendMessage(String message);

  public String save(User user);
}
