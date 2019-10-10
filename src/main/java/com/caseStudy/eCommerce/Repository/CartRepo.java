package com.caseStudy.eCommerce.Repository;

import com.caseStudy.eCommerce.model.Cart;
import com.caseStudy.eCommerce.model.Users;
import com.caseStudy.eCommerce.model.items;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepo extends CrudRepository<Cart,Long>
{
    ArrayList<Cart> findAllByUsers(Optional<Users> users);
   void deleteByUsersAndItems(Optional<Users> users, Optional<items> items);

}
