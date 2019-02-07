/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juba13.identityhub.model;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "app_info")
public class App {

    @Id
    @Column(name = "app_id")
    @Type(type="pg-uuid")
    private UUID id;
    
    
    @Column(name = "app_name",nullable=false,unique = true)
    private String name;
    
  
   
    
    
    @Column(name = "public_key",nullable=false,unique = true)
    private String publicKey;
    
    @Column(name = "private_key",nullable=false,unique = true)
    private String privateKey;
    
    
    
    @Column(name = "app_url" ,nullable=false)
    private String appUrl;
    
    
    @Column(name = "note" ,nullable=true)
    private String note;
    
    @Column(name = "about_url",nullable=false)
    private String aboutUrl;
    
    @Column(name = "terms_url")
    private String termsUrl;
    
    @Column(name = "privacy_url")
    private String privacyUrl;
    
    
    @Column(name = "logout_url")
    private String logoutUrl;
    
    
    @Column(name = "logo_url")
    private String logoUrl;
    
   
    @Pattern(regexp = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$")
    @Column(name = "server_ip" ,nullable=false)
    private String serverIp;
    
    
    @Column(name = "expire_on" ,nullable=false)
    private Date expireOn;
    
  
    
    
    @Column(name = "sl",nullable=false)
    private int sl;    
    
    @Column(name = "active" ,nullable=false)
    private boolean  active=true;
    
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="category_id"  ,referencedColumnName="category_id", nullable = true)
    private Category category;
    
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "app_user", joinColumns = @JoinColumn(name = "app_id", referencedColumnName = "app_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
    private Set<User> users= new HashSet<>();

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<User> getUsers() {
        return users;
    }
    
    
    
    public App() {
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

  
    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public void setAboutUrl(String aboutUrl) {
        this.aboutUrl = aboutUrl;
    }

    public String getAboutUrl() {
        return aboutUrl;
    }

   

    public String getTermsUrl() {
        return termsUrl;
    }

    public void setTermsUrl(String termsUrl) {
        this.termsUrl = termsUrl;
    }

    public String getPrivacyUrl() {
        return privacyUrl;
    }

    public void setPrivacyUrl(String privacyUrl) {
        this.privacyUrl = privacyUrl;
    }

    

    public String getLogoutUrl() {
        return logoutUrl;
    }

    public void setLogoutUrl(String logoutUrl) {
        this.logoutUrl = logoutUrl;
    }

    public Date getExpireOn() {
        return expireOn;
    }

    public void setExpireOn(Date expireOn) {
        this.expireOn = expireOn;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
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

  
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    
    private boolean newApp =false;

    public void setNewApp(boolean newApp) {
        this.newApp = newApp;
    }

    public boolean getNewApp() {
        return newApp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getServerIp() {
        return serverIp;
    }
    
    
    public List<String> getUserIds(){
        List<String> uuids=new ArrayList<>();
        users.stream().forEach((t) -> {
            uuids.add(t.getId().toString());
        });
        return  uuids;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }
    
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
      
        return Objects.equals(id, ((App)o).getId());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
}



