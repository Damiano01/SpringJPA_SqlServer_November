package com.working.Working.controller;

import com.working.Working.module.Users;
import com.working.Working.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController
{
    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    public List<Users> getAll()
    {
        return userRepository.findAll();
    }

    @PostMapping()
    public List<Users> saveData(@RequestBody final Users november)
    {
        userRepository.save(november);
        return userRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteData(@PathVariable int id)
    {
        Optional<Users> user = userRepository.findById(id);

        if (user.isPresent())
        {
            userRepository.delete(user.get());
            return "User Is Deleted Successfully";
        }
        else
        {
            throw new RuntimeException("User is not Found");
        }
    }

    @PutMapping()
    public Users update(@RequestBody Users users)
    {
        return userRepository.save(users);
    }
}
