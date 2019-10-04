package com.caseStudy.eCommerce.controller;

import com.caseStudy.eCommerce.Exception.ResourceNotFoundException;
import com.caseStudy.eCommerce.Repository.itemRepo;
import com.caseStudy.eCommerce.model.items;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/item")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class Items_Controller
{
    @Autowired
    itemRepo it;

    @GetMapping("/prodetails")
    public List<items> getAlldetails()
    {
        return it.findAll();
    }
    @PostMapping("/details")
    public items createNewItem(@Valid @RequestBody items ifc)
    {
        return it.save(ifc);
    }
    @DeleteMapping("/del")
    public ResponseEntity<?> deleteDetails(@PathVariable(value="id")Long productId)
    {
        items abc = it.findById(productId).orElseThrow(()->new ResourceNotFoundException("Item","Id",productId));
        it.delete(abc);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/par/{id}")
    public items getDetailsById(@PathVariable(value="id")Long productId)
    {
        return it.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Details","Id",productId));
    }
    @GetMapping("/cat/{cat}")
    public List<items> getDetailsByCat(@PathVariable(value="cat")String category)
    {
        return it.findByCategory(category);
    }
    @GetMapping("/{cat}/{price1}/{price2}")
   public List<items> getMultiDetails(@PathVariable(value = "cat")String category,@PathVariable(value = "price1")Double price1,@PathVariable(value = "price2")Double price2)
    {
        return  it.findByCategoryAndPriceBetween(category, price1, price2);
    }
    @GetMapping("abc/{price1}/{price2}")
    public List<items> getPriceDetails(@PathVariable(value = "price1")Double price1,@PathVariable(value = "price2")Double price2)
    {
        return it.findByPriceBetween(price1, price2);
    }
}
