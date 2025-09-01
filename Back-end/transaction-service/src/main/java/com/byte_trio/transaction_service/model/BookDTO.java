package com.byte_trio.transaction_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BookDTO {

    @Id
    private long isbn_no;
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
    private String title;
    private String author;
    private String genre;
    private boolean availabilty;
    private int avail_copies;

//    public int getId() {
//        return id;
//    }
//
//    public Book setId(int id) {
//        this.id = id;
//        return this;
//    }

    public String getTitle() {
        return title;
    }

    public BookDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public BookDTO setAuthor(String author) {
        this.author = author;
        return this;
    }

    public long getIsbn_no() {
        return isbn_no;
    }

    public BookDTO setIsbn_no(long isbn_no) {
        this.isbn_no = isbn_no;
        return this;
    }

    public String getGenre() {
        return genre;
    }

    public BookDTO setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public boolean isAvailabilty() {
        return availabilty;
    }

    public BookDTO setAvailabilty(boolean availabilty) {
        this.availabilty = availabilty;
        return this;
    }

    public int getAvail_copies() {
        return avail_copies;
    }

    public BookDTO setAvail_copies(int avail_copies) {
        this.avail_copies = avail_copies;
        return this;
    }

    @Override
    public String toString() {
        return title + author + isbn_no + genre + availabilty + avail_copies;
    }
}
