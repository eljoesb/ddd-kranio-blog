package com.kranio.infrastructure.amq.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.JMSRuntimeException;
import jakarta.jms.Session;
import com.kranio.domain.classes.User;
import com.kranio.domain.repositories.IUserRepository;
import com.kranio.infrastructure.mongodb.repositories.MongoRepository;

@ApplicationScoped
public class AMQProducerRepository implements IUserRepository {

  @Inject
  private ConnectionFactory connectionFactory;

  @Inject
  private MongoRepository mongoRepository;

  public void sendMessage(String message) {
    try (JMSContext context = connectionFactory.createContext(Session.AUTO_ACKNOWLEDGE)) {
      context.createProducer().send(context.createQueue("exampleQueue"), message);
      System.out.println("Message sent: " + message);
    } catch (JMSRuntimeException ex) {
      System.err.println("Error sending message: " + ex.getMessage());
    }
  }

  public String save(User user) {
    mongoRepository.persist(user);
    return "User saved";
  }
}
