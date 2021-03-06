package com.caseStudy.eCommerce.model;

import javax.persistence.*;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private items items;
    @ManyToOne
    private Users users;
    private int quantity;
    public Cart()
    {}
    public Cart(com.caseStudy.eCommerce.model.items items, Users user, int quantity)
    {
        this.items=items;
        this.users=users;
        this.quantity=quantity;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public com.caseStudy.eCommerce.model.items getItems() {
        return items;
    }

    public void setItems(com.caseStudy.eCommerce.model.items items) {
        this.items = items;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
