package com.byte_trio.book_service.controller;

import com.byte_trio.book_service.model.Book;
import com.byte_trio.book_service.model.BookDTO;
import com.byte_trio.book_service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("search")
    public ResponseEntity<List<BookDTO>> searchByTitle(@RequestParam String encoded_title){
        byte[] decodedbytes = Base64.getDecoder().decode(encoded_title);
        String title = new String(decodedbytes);
        return ResponseEntity.status(HttpStatus.OK).body(bookService.searchByTitle(title));
    }

    @GetMapping("search")
    public ResponseEntity<List<BookDTO>> searchByAuthor(@RequestParam String encoded_title){
        byte[] decodedbytes = Base64.getDecoder().decode(encoded_title);
        String author = new String(decodedbytes);
        //return bookService.searchByAuthor(author);
        return ResponseEntity.status(HttpStatus.OK).body(bookService.searchByAuthor(author));
    }

    @GetMapping("search")
    public ResponseEntity<List<BookDTO>> searchByISBN(@RequestParam String encoded_title){
        byte[] decodedbytes = Base64.getDecoder().decode(encoded_title);
        String isbn_no = new String(decodedbytes);
        //return bookService.searchByISBN(isbn_no);
        return ResponseEntity.status(HttpStatus.OK).body(bookService.searchByISBN(isbn_no));
    }

    @GetMapping("search")
    public ResponseEntity<List<BookDTO>> searchByGenre(@RequestParam String encoded_title){
        byte[] decodedbytes = Base64.getDecoder().decode(encoded_title);
        String genre = new String(decodedbytes);
        //return bookService.searchByGenre(genre);
        return ResponseEntity.status(HttpStatus.OK).body(bookService.searchByGenre(genre));
    }

    @GetMapping("search")
    public ResponseEntity<List<BookDTO>> searchByAvailabilty(@RequestParam String encoded_title){
        byte[] decodedbytes = Base64.getDecoder().decode(encoded_title);
        String availability = new String(decodedbytes);
        //return bookService.searchByGenre(genre);
        return ResponseEntity.status(HttpStatus.OK).body(bookService.searchByAvailability(availability));
    }

    @PostMapping("edit")
    public ResponseEntity<String> editBook(@RequestBody Book book){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.editBook(book));
    }

    @PostMapping("addnewbook")
    public ResponseEntity<String> addNewBook(@RequestBody Book book){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addNewBook(book));
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteBook(@RequestParam String encoded_title) {
        byte[] decodedbytes = Base64.getDecoder().decode(encoded_title);
        String isbn = new String(decodedbytes);
        long isbn_No = Long.parseLong(isbn);
        String response = bookService.deleteBookById(isbn_No);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
