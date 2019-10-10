package com.caseStudy.eCommerce.controller;

import com.caseStudy.eCommerce.Repository.UserRepo;
import com.caseStudy.eCommerce.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/abc")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class SignUp
{
    @Autowired
    UserRepo u;
    @PostMapping(value = "/somedata" , consumes = "application/json")
    public Users signUp(@RequestBody Users user)
    {
        user.setActive(1);
        user.setAuthorisation("basic");
        // user.setId(user.id++);
        System.out.println("Working");
        u.save(user);
        return user;
    }
}
