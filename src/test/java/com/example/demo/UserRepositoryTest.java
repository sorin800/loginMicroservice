package com.example.demo;

import com.example.login.model.User;
import com.example.login.repository.UserRepository;
import com.example.login.service.UserService;
import com.example.login.service.UserServiceImp;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    void findByName_returnUser(){
        User user = new User();
        user.setName("Gustaf");
        User foundUser = new User();
        List<User> userList = userRepository.findAll();

        for(int i=0;i<userList.size();i++)
        {
            System.out.println(userList.get(i).getName());
            if(userList.get(i).getName()==user.getName()){
                foundUser.setName(userList.get(i).getName());
            }
        }
        System.out.println(foundUser.getName());
        Assert.assertEquals(user.getName(),foundUser.getName());
    }


}
