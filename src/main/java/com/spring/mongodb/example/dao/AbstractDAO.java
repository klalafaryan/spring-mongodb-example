package com.spring.mongodb.example.dao;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;

public abstract class AbstractDAO<T> {

    /**
     * Injection of Spring Mongo template.
     */
    @Qualifier("coreMongoTemplate")
    @Autowired(required = true)
    protected MongoTemplate mongoTemplate;

    /**
     * @param id the user ObjectId
     * @return the entity
     */
    protected abstract T findById(ObjectId id);
}
