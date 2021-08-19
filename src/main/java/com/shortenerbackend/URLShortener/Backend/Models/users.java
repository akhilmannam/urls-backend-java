package com.shortenerbackend.URLShortener.Backend.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserMongoDb {
    @Id
    private String userId;
    private String email;
    private String password;
    private ArrayList<Links> links;

    public UserMongoDb(UserRequest userRequest){
        this.email = userRequest.getEmail();
        this.password = userRequest.getPassword();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public ArrayList<Links> getLinks() {
        return links;
    }

    public void setLinks(ArrayList<Links> links) {
        this.links = links;
    }

    public String toString(){
        return this.userId + " " +  this.email + " " +this.password ;
    }
}