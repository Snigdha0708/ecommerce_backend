package com.caseStudy.eCommerce.controller;

import com.caseStudy.eCommerce.Repository.MycartRepo;
import com.caseStudy.eCommerce.Repository.UserRepo;
import com.caseStudy.eCommerce.model.Users;
import com.caseStudy.eCommerce.service.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/myprofile")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class MyprofileController
{
   @Autowired
    MycartRepo mycartRepo;
    @Autowired
    CurrentUser currentUser;
    @Autowired
    UserRepo userRepo;
  @GetMapping("/get")
    public Users getData(Principal principal){
      return currentUser.getProfile(principal);
  }
    @PutMapping("/update")
    public Users update(@Valid @RequestBody Users users) {
        users.setActive(1);
        users.setAuthorisation("basic");
        userRepo.save(users);
        return users;
    }
}
