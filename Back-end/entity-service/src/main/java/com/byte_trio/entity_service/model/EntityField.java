package com.byte_trio.entity_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "entity_field")
public class EntityField {
    @Id
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
//    private String borrowedBook;

    public String getId() {return id;}

    public String getName() {return name;}
    
    public String getEmail() {return email;}
    
    public String getPhoneNumber() {return phoneNumber;}
    
//    public String getBorrowedBook() {return borrowedBook;}
    
    public EntityField setId(String id) {
        this.id = id;
        return this;
    }

    public EntityField setName(String name) {
        this.name = name;
        return this;
    }

    public EntityField setEmail(String email) {
        this.email = email;
        return this;
    }

    public EntityField setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

//    public EntityField setBorrowedBook(String borrowedBook) {
//        this.borrowedBook = borrowedBook;
//        return this;
//    }

    @Override
    public String toString() {
        return id + name + email + phoneNumber;
    }
}
