/*package com.caseStudy.eCommerce.controller;

import com.caseStudy.eCommerce.Repository.UserRepo;
import com.caseStudy.eCommerce.model.Users;
import com.caseStudy.eCommerce.model.items;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class UsersController {
    UserRepo u;
    @GetMapping("/getuser")
    public List<Users> getUsers()
    {
        return u.findAll();
    }

}*/
