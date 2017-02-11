package com.spring.mongodb.example.dao;

import com.spring.mongodb.example.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("userDAO")
public class UserDAO extends AbstractDAO<User> {

    /**
     * {@inheritDoc}
     */
    @Override
    public User findById(ObjectId id) {
        return mongoTemplate.findById(id, User.class, User.COLLECTION_NAME);
    }

    /**
     *
     * @param userName the username
     * @param deleteDate the delete date
     * @return the User by username and delete date
     */
    public User findByUserNameAndDeleteDate(String userName, Date deleteDate) {
        return mongoTemplate.findOne(new Query(Criteria.where(User.FIELD_USER_NAME)
                .is(userName).and(User.FIELD_DELETE_DATE)
                .is(deleteDate)), User.class, User.COLLECTION_NAME);
    }

    /**
     *
     * @return the list of users from the database
     */
    public List<User> list() {
        return mongoTemplate.findAll(User.class, User.COLLECTION_NAME);
    }

    /**
     *
     * @return the count of users
     */
    public long count() {
        return mongoTemplate.getCollection(User.COLLECTION_NAME).count();
    }

    /**
     * @param user
     */
    public void save(User user) {
        user.setCreateDate(new Date());
        mongoTemplate.insert(user, User.COLLECTION_NAME);
    }

    /**
     * @param user
     */
    public void update(User user) {
        user.setModifyDate(new Date());
        mongoTemplate.save(user, User.COLLECTION_NAME);
    }


    /**
     * @param user
     */
    public void delete(User user) {
        user.setDeleteDate(new Date());
        mongoTemplate.save(user, User.COLLECTION_NAME);
    }

}
