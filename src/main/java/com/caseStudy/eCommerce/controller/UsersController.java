package com.caseStudy.eCommerce.controller;

import com.caseStudy.eCommerce.Repository.UserRepo;
import com.caseStudy.eCommerce.model.Users;
import com.caseStudy.eCommerce.model.items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class UsersController {
    @Autowired
    UserRepo u;
    //public static Principal principal;
   @PostMapping
    public Users newUser(@Valid @RequestBody Users user)
   {
       return u.save(user);
   }
   @GetMapping("/validuser")
   public String valUser(Principal principal)
   {
       System.out.println("Logging in user"+principal.getName());
       //this.principal=principal;
       return "\"user successfully authenticated\"";
   }
      @GetMapping("/getUsers")
    public List<Users> getAll()
      {
          return u.findAll();
      }
}
