package com.kranio.presenters.kafka;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import io.vertx.mutiny.ext.auth.User;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import com.kranio.application.services.UserService;

@Singleton
public class KafkaConsumer {

  @Inject
  private UserService userService;

  @Incoming("consumer")
  public void consume(String message) {
    System.out.println("Consumiendo mensaje: " + message);
    userService.saveAndSendMessage(message);
  }
}
