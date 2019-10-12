package com.caseStudy.eCommerce.Repository;


import com.caseStudy.eCommerce.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MycartRepo extends JpaRepository<Users,Long>
{
   Optional<Users> findByEmail(String email);

}
