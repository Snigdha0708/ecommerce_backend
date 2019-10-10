package com.caseStudy.eCommerce.Repository;

import com.caseStudy.eCommerce.model.Users;
import com.caseStudy.eCommerce.model.items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users,Long>
{
    @Override
    List<Users> findAll();
    Optional<Users> findByEmail(String email);
    }
