package com.in28minutes.rest.webservices.restfulwebservices.controller;


import com.in28minutes.rest.webservices.restfulwebservices.dao.UserDao;
import com.in28minutes.rest.webservices.restfulwebservices.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping(path="users", method = RequestMethod.GET)
    public List<User> getUsers(){

        return userDao.getUsers();
    }

    @RequestMapping(path="users/{name}", method = RequestMethod.GET)
    public User getUserByName(@PathVariable String name){

        return userDao.getUserByName(name);
    }

    @PostMapping(path = "users")
    public ResponseEntity<Object> saveUser(@RequestBody User user){

        User savedUser = userDao.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
