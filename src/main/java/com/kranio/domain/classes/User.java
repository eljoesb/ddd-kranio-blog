package com.kranio.domain.classes;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import lombok.Data;

public class User extends PanacheMongoEntity {
    public String name;
    public String email;
}
