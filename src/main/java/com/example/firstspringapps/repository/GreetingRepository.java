package com.example.firstspringapps.repository;
import com.example.firstspringapps.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting,Long> {
}
