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
        ifc.setActive(1);
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
    @GetMapping("search/{name}")
    public List<items> getSearch(@PathVariable(value = "name")String name)
    {
        return it.findByName(name);
    }
    @PutMapping("/update/{id}")
    public items updateItem(@PathVariable(value = "id")Long productId, @Valid @RequestBody items items)
    {
        items i = it.findByProductId(productId);
        i.setActive(1);
        i.setCategory(items.getCategory());
        i.setSubcategory(items.getSubcategory());
        i.setPrice(items.getPrice());
        i.setDetails(items.getDetails());
        i.setImage(items.getImage());
        i.setName(items.getName());
        items newItem = it.save(i);
        return newItem;
    }
}
