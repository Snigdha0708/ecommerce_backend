package com.caseStudy.eCommerce.controller;
import com.caseStudy.eCommerce.Repository.CartRepo;
import com.caseStudy.eCommerce.model.Cart;
import com.caseStudy.eCommerce.service.CurrentCart;
import com.caseStudy.eCommerce.service.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mycart")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class CartController {
    @Autowired
    CurrentCart currentCart;
    //Principal principal;
    @GetMapping(path="/cart")
    public ArrayList<Cart> getCart(Principal principal)
    {
        return currentCart.getEmail(principal);
    }
    @GetMapping(path="/cart/add/productId/{id}")
    public String addItemToCart(@PathVariable("id") Long productId,Principal principal)
    {
        return currentCart.addItemToCart(principal,productId);
    }
    @GetMapping(path="/cart/delete/productId/{id}")
    public String deleteItemFromCart(@PathVariable("id")Long id,Principal principal)
    {
        return currentCart.deleteItemFromCart(id,principal);
    }
    @GetMapping("/cart/increment/{value}/product/{productId}")
    public String increment(@PathVariable("value")int value,@PathVariable("productId")Long productId,Principal principal)
    {
        return currentCart.increment(value,productId,principal);
    }
    @GetMapping("/cart/decrement/{value}/product/{productId}")
    public String decrement(@PathVariable("value")int value,@PathVariable("productId")Long productId,Principal principal)
    {
        return currentCart.decrement(value,productId,principal);
    }
}