package com.itmuch.cloud.microservicesimpleconsumermovie.controller;
import java.math.BigDecimal;

import com.itmuch.cloud.microservicesimpleconsumermovie.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    public User findById (@PathVariable Long id){
        return this.restTemplate.getForObject("http://localhost:8000/"+id,User.class);
    }

    @GetMapping("/users")
    public List<User> findUsers (){
        List<User> users=new ArrayList<User>();
        User user1=new User();
        user1.setId(1L);
        user1.setUsername("zou1");
        user1.setName("zou1");
        user1.setAge(10);
        user1.setBalance(new BigDecimal("1000"));

        User user2=new User();
        user2.setId(2L);
        user2.setUsername("zou2");
        user2.setName("zou2");
        user2.setAge(30);
        user2.setBalance(new BigDecimal("2000"));

        users.add(user2);
        users.add(user1);

        return users;
    }
}
