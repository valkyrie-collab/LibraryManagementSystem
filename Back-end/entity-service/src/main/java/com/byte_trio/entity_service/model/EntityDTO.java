package com.byte_trio.entity_service.model;

public class EntityDTO {
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

    public EntityDTO setId(String id) {
        this.id = id;
        return this;
    }

    public EntityDTO setName(String name) {
        this.name = name;
        return this;
    }

    public EntityDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public EntityDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
