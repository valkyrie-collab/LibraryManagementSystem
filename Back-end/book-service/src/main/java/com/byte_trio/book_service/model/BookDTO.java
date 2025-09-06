package com.byte_trio.book_service.model;

import lombok.Data;

@Data
public class BookDTO {
    private long isbn_no;
    private String title;
    private String author;
    private String genre;
    private boolean availabilty;
    private int avail_copies;
}
