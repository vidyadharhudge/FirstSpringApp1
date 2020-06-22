package com.example.firstspringapps.service;
import com.example.firstspringapps.model.Greeting;
import com.example.firstspringapps.model.User;

import java.util.List;

public interface IGreetingService {
    Greeting addGreeting(User user);
    Greeting getGreetingById(long id);
    List<Greeting>getAll();
    void deleteById(Long id);
    Greeting updateById(Long id,User user);
}
