package com.caseStudy.eCommerce.service;

import com.caseStudy.eCommerce.Repository.*;
import com.caseStudy.eCommerce.model.Cart;
import com.caseStudy.eCommerce.model.Users;
import com.caseStudy.eCommerce.model.items;
import com.caseStudy.eCommerce.model.orderHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CurrentCart {
    @Autowired
    UserRepositoryClass userRepositoryClass;
    @Autowired
    CartRepo cartRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    orderRepo orderRepo;

    private ArrayList<Cart> getCartFromCurrentUser(Principal principal) {
        Optional<Users> users = userRepositoryClass.getByEmail(principal.getName());
        ArrayList<Cart> cart = cartRepo.findAllByUsers(users);
        return cart;
    }

    public ArrayList<Cart> getEmail(Principal principal) {
        String email = principal.getName();
        Optional<Users> users = userRepositoryClass.getByEmail(email);
        return cartRepo.findAllByUsers(users);
    }

    public String addItemToCart(Principal principal, Long id) {
        Optional<items> items = productRepo.getById(id);
        Optional<Users> users = userRepositoryClass.getByEmail(principal.getName());
        ArrayList<Cart> cart = getCartFromCurrentUser(principal);
        for (int i = 0; i < cart.size(); i++) {
            Cart cartObj = cart.get(i);
            if (cartObj.getItems() == items.get()) {
                cartObj.setQuantity(cartObj.getQuantity() + 1);
                cartRepo.save(cartObj);
                return "\"Quantity increases\"";
            }
        }
        Cart cartObj = new Cart();
        cartObj.setQuantity(1);
        cartObj.setItems(items.get());
        cartObj.setUsers(users.get());
        cartRepo.save(cartObj);
        return "\"Item added to cart\"";
    }
    @Transactional
    public String deleteItemFromCart(Long productId,Principal principal){
        Optional<items> items=productRepo.getById(productId);
        Optional<Users> users=userRepositoryClass.getByEmail(principal.getName());
        cartRepo.deleteByUsersAndItems(users,items);
        return "\"deletion completed\"";
     }
     public String increment(int value,Long productId,Principal principal)
     {
         ArrayList<Cart> cart=getCartFromCurrentUser(principal);
         Optional<items> items=productRepo.getById(productId);
         for(int i=0;i<cart.size();i++)
         {
             Cart cartObj=cart.get(i);
             int max=0;
             if(cartObj.getItems()==items.get())
             {
                 max=cartObj.getQuantity()+value;
                 cartObj.setQuantity(max);
                 cartRepo.save(cartObj);
                 return "\"successful\"";
             }
         }
         return "\"unsuccessful\"";
     }
    public String decrement(int value,Long productId,Principal principal)
    {
        ArrayList<Cart> cart=getCartFromCurrentUser(principal);
        Optional<items> items=productRepo.getById(productId);
        int q=0;
        for(int i=0;i<cart.size();i++)
        {
            Cart cartObj=cart.get(i);
            if(cartObj.getItems()==items.get())
            {
                q=cartObj.getQuantity()-value;
                if(q>0) {
                    cartObj.setQuantity(q);
                    cartRepo.save(cartObj);
                    return "\"successful\"";
                }
                else
                    deleteItemFromCart(productId,principal);
            }
        }
        return "\"unsuccessful\"";
    }
    public List<orderHistory> checkOut(Principal principal){
        Optional<Users> users = userRepositoryClass.getByEmail(principal.getName());
        ArrayList<Cart> cartList = cartRepo.findAllByUsers(users);
        for(Cart cart : cartList) {
            orderHistory orderHistory = new orderHistory();
            orderHistory.setUserId(cart.getUsers().getId());
            orderHistory.setQuantity(cart.getQuantity());
            orderHistory.setPrice(cart.getItems().getPrice());
            orderHistory.setItemName(cart.getItems().getName());
            orderHistory.setDate(new Date());
            cartRepo.delete(cart);
            orderRepo.saveAndFlush(orderHistory);
        }
        return orderRepo.findAllByUserId(users.get().getId());
        }

    }
