package com.caseStudy.eCommerce.service;

import com.caseStudy.eCommerce.Repository.MycartRepo;
import com.caseStudy.eCommerce.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public class CurrentUser
{
    @Autowired
    MycartRepo mycartRepo;
     public Users getProfile(Principal principal){
         Optional<Users> myp=mycartRepo.findByEmail(principal.getName());
         return  myp.get();
     }
}
