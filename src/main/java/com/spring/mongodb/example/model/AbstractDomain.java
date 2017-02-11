package com.spring.mongodb.example.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class AbstractDomain {

    /**
     *
     */
    @Id
    protected ObjectId id;

    /**
     * @return the id
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

}

