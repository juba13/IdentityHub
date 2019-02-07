package com.juba13.identityhub.repo;

import com.juba13.identityhub.model.App;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AppRepo extends JpaRepository<App, UUID>{
    @Override
    List<App>  findAll();
    List<App>  findAllByActive(boolean  active);
    App findBypublicKey(String publicKey);
    
    
    @Query(value = "select a.* from app_info a join app_user u on a.app_id=u.app_id where  u.user_id=:user_id and a.active=:active ",nativeQuery = true)
    public List<App> fetchApps(@Param("user_id") UUID userId,@Param("active") boolean active);
    
    
    @Query(value = "select a.* from app_info a join app_user u on a.app_id=u.app_id where  u.user_id=:user_id and u.app_id=:app_id  ",nativeQuery = true)
    public App fetchApp(@Param("app_id") UUID appId,@Param("user_id") UUID userId);
}
