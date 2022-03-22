package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
public class Controller {

    private final UserRepository repository;

    Controller(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/user")
    List<User> all(){
        return repository.findAll();
    }

    @GetMapping("/user/{id}")
    User one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find employee " + id));
    }

    @PostMapping("/user")
    User newEmployee(@RequestBody User newUser) {
        return repository.save(newUser);
    }
}