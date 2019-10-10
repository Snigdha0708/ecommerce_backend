package com.caseStudy.eCommerce.service;

import com.caseStudy.eCommerce.Repository.UserRepo;
import com.caseStudy.eCommerce.model.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public class CurrentUser
{
    UserRepo ur;
  /*public Long getuserid(Principal principal)
  {
      String email=principal.getName();
      Long id=ur.findByEmail(email).get().getId();
  }*/
}
