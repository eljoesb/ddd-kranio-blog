package com.kranio.application.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import com.kranio.domain.classes.User;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.StringReader;

@ApplicationScoped
public class UserMapper {

  public User convertStringToUser(String xml) throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    StringReader reader = new StringReader(xml);
    return (User) unmarshaller.unmarshal(reader);
  }

}
