package com.caseStudy.eCommerce.controller;

import com.caseStudy.eCommerce.Repository.UserRepo;
import com.caseStudy.eCommerce.model.Users;
import com.caseStudy.eCommerce.model.items;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class UsersController {
    UserRepo u;
   @PostMapping("/createUser")
    public Users newUser(@Valid @RequestBody Users user)
   {
       return u.save(user);
   }
   @GetMapping("/validuser")
   public String valUser()
   {
       return "\"user successfully authenticated\"";
   }
}
