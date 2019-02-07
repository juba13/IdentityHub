/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juba13.identityhub.service;

import com.juba13.identityhub.model.Category;
import com.juba13.identityhub.repo.CategoryRepo;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author juba
 */
@Service
public class CategoryService  {

    @Autowired
    CategoryRepo repo;
        
    public Category add(Category model) {
        model.setId(UUID.randomUUID());
        return repo.save(model);
    }

   
    public Category update(Category model) {
      return repo.save(model);
    }

    public List<Category> list() {
      return repo.findAll(new Sort(Sort.Direction.ASC, "sl"));
    }

   
    public Category get(UUID id) {
        return repo.findById(id).get();
    }

  
    public Category changeState(UUID id, boolean active) {
        Category  category=repo.findById(id).get();
        category.setActive(active);
        return repo.save(category);
    }
}
