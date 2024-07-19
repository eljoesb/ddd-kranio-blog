package com.kranio.presenters.http;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import com.kranio.application.services.UserService;
import com.kranio.domain.classes.User;

@Path("/user")
public class UserController {

  @Inject
  private UserService userService;

  @POST
  public Response create(User newUser) {
    userService.saveAndSendMessage(newUser);
    return Response.status(Response.Status.CREATED).entity(newUser).build();
  }

}
