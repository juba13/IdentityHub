/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juba13.identityhub.model;

import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Type;

/**
 *
 * @author juba
 */
@Entity
@Table(name = "category" )
public class Category {
 
    @Id
    @Column(name = "category_id")
    @Type(type="pg-uuid")
    private UUID id;
       
    @Size(min = 1, max = 100)
    @Column(name = "category_name",nullable = false,unique = true)
    private String name;


    @Column(name = "sl",nullable = false)
    private int sl;    
   
    @Column(name = "active",nullable = false )
    private boolean active=true;
    
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id", referencedColumnName="category_id", nullable = true)
    private List<App> apps;

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

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<App> getApps() {
        return apps;
    }

    public void setApps(List<App> apps) {
        this.apps = apps;
    }
    
    
    
}
