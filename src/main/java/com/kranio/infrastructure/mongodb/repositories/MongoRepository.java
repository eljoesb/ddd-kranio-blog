package com.kranio.infrastructure.mongodb.repositories;

import io.quarkus.mongodb.panache.PanacheMongoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import com.kranio.domain.classes.User;

@ApplicationScoped
public class MongoRepository implements PanacheMongoRepository<User> {
}
