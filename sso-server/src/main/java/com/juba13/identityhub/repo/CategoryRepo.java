package com.juba13.identityhub.repo;

import com.juba13.identityhub.model.Category;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, UUID>{
   
    List<Category>  findAllByOrderBySlAsc();
}
