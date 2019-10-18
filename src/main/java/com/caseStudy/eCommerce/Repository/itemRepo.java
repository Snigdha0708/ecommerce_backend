package com.caseStudy.eCommerce.Repository;

import com.caseStudy.eCommerce.model.items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface itemRepo extends JpaRepository<items,Long> {


    List<items> findByCategory(String category);

    List<items> findByCategoryAndPriceBetween(String category, Double a, Double b);

    List<items> findByPriceBetween(Double a, Double b);
    List<items> findByNameContaining(String name);
    items findByProductId(Long productId);

}
