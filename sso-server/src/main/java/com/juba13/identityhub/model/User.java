/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juba13.identityhub.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Type;

/**
 *
 * @author juba
 */
@Entity
@Table(name = "user_info")
public class User {
 
    @Id
    @Column(name = "user_id")
    @Type(type="pg-uuid")
    private UUID id;
   
    @Size(min = 1, max = 100)
    @Column(name = "user_name")
    private String name;
    
    @Size(min = 1, max = 100)
    @Column(name = "user_code")
    private String code;
    
    
    @Size(min = 1, max = 100)
    @Column(name = "user_email",nullable = false,unique = true)
    private String email;
    
    
    @Size(min = 1, max = 100)
    @Column(name = "user_mobile",nullable = true)
    private String mobile;
    
    
    @Size(min = 1, max = 1000)
    @Column(name = "user_password",nullable = false)
    private String password;
    
    
    @Column(name = "active",nullable = false)
    private boolean active=true;
    
    
    
    @ManyToMany(mappedBy = "users",fetch = FetchType.LAZY)
    private Set<App> apps ;
    
    

    public void setApps(Set<App> apps) {
        this.apps = apps;
    }

    public Set<App> getApps() {
        return apps;
    }
    

    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    
    private boolean master=false;

    public void setMaster(boolean master) {
        this.master = master;
    }

    public boolean isMaster() {
        return master;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }
    
     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
      
        return Objects.equals(id, ((User)o).getId());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    
}
