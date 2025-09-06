package com.byte_trio.book_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Book {


    @Id
    private long isbn_no;
    private String title;
    private String author;
    private String genre;
    private boolean availabilty;
    private int avail_copies;
}
