package com.example.firstspringapps.service;
import com.example.firstspringapps.model.Greeting;
import com.example.firstspringapps.model.User;
import com.example.firstspringapps.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService {
    public static final String template="Hello,%s!";
    private final AtomicLong counter=new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(User user) {
       String message=String.format(template,(user.getFirstName().isEmpty()) ?
               "Hello World" :user.getFirstName()+" "+user.getLastName());
       return greetingRepository.save(new Greeting(counter.incrementAndGet(),message));
    }

    @Override
    public List<Greeting> getAll() {
        return greetingRepository.findAll();
    }

    @Override
    public Greeting getGreetingById(long id) {
        return greetingRepository.findById(id).get();
    }

    @Override
    public Greeting updateById(Long id, User user) {
        Greeting greetingById=getGreetingById(id);
        greetingById.setName(user.getFirstName() + " " + user.getLastName());
        return greetingRepository.save(greetingById);
    }

    @Override
    public void deleteById(Long id) {
        greetingRepository.deleteById(id);
    }

}
