package com.example.firstspringapps.controller;
import com.example.firstspringapps.model.Greeting;
import com.example.firstspringapps.model.User;
import com.example.firstspringapps.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private IGreetingService greetingService;

    @GetMapping("/addgreeting")
    public Greeting greeting(@RequestParam(value = "firstName") String firstName,
                             @RequestParam(value = "lastName") String lastName){
        User user=new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
       return greetingService.addGreeting(user);
    }

    @RequestMapping("/getallgreeting")
    public List<Greeting> getAll(){
        return greetingService.getAll();
    }

    @GetMapping("/getgreetingbyid/{id}")
    public Greeting getGreetingById(@PathVariable Long id){
        return greetingService.getGreetingById(id);
    }

    @PutMapping("/update/{id}")
    public Greeting updateGreetingById(@PathVariable Long id,@RequestParam String fName,@RequestParam String lName){
        User user=new User();
        user.setFirstName(fName);
        user.setLastName(lName);
        return greetingService.updateById(id,user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        greetingService.deleteById(id);
    }
}
