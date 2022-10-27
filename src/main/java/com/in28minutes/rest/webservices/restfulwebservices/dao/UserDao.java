package com.in28minutes.rest.webservices.restfulwebservices.dao;

import com.in28minutes.rest.webservices.restfulwebservices.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userDaoService")
public class UserDao {

    private static List<User> userList = new ArrayList<>();

    private static int userCount = 0;

    static {

        userList.add(new User(++userCount,"mert","kaan",23));
        userList.add(new User(++userCount,"ali","yılmaz",35));
        userList.add(new User(++userCount,"ayse","gul",30));
    }


    public List<User> getUsers(){
        return userList;
    }

    public User getUserByName(String name){
        return userList.stream().filter(u -> u.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public User save(User user){
        user.setId(++userCount);
        userList.add(user);
        return user;
    }

}
