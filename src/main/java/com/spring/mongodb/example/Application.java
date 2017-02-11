package com.spring.mongodb.example;

import com.spring.mongodb.example.dao.UserDAO;
import com.spring.mongodb.example.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.UUID;

public class Application {

    public static void main(String[] args) {

        //Create a new ClassPathXmlApplicationContext, loading the definitions
        //from the given XML file and automatically refreshing the context
        final ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //Getting the UserDAO bean
        final UserDAO userDAO = UserDAO.class.cast(ctx.getBean("userDAO"));

        // creating the user model
        final User user = new User();
        final String uuid = UUID.randomUUID().toString();
        final String username = "testUsername" + uuid;
        user.setUserName("");
        user.setEmailAddress(uuid + "test@test.com");
        user.setPassword("testEncryptedPassword");

        // saving the user into the database
        userDAO.save(user);

        // update the user
        user.setUserName("updatedUsername");
        userDAO.update(user);

        // delete the user
        userDAO.delete(user);

        // getting all users from the database
        List<User> list = userDAO.list();
        for (User u : list) {
            System.out.println(u);
        }

        //getting the user count
        long count = userDAO.count();
        System.out.println(count);

        //find the user by ID
        User user1 = userDAO.findById(list.get(0).getId());
        System.out.println(user1);

        // find the user by username and delete date
        User byUserNameAndDeleteDate = userDAO.findByUserNameAndDeleteDate(username, null);
        System.out.println(byUserNameAndDeleteDate);

    }
}
