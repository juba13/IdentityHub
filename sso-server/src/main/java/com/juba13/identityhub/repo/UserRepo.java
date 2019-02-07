package com.juba13.identityhub.repo;

import com.juba13.identityhub.model.Category;
import com.juba13.identityhub.model.User;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, UUID> {

    List<User> findAllByActive(boolean  active);
    
     List<User> findAll();
     User  findByEmailAndPassword(String email ,String password);
    
}
