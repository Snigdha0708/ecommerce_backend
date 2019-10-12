package com.caseStudy.eCommerce.Repository;

import com.caseStudy.eCommerce.model.orderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface orderRepo extends JpaRepository<orderHistory,Long> {
    List<orderHistory> findAllByUserId(Long id);
}
