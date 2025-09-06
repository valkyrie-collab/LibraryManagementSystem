package com.byte_trio.book_service.service;

import com.byte_trio.book_service.model.Book;
import com.byte_trio.book_service.model.BookDTO;
import com.byte_trio.book_service.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.Base64;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepo bookRepo;

    private BookDTO getBook(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setIsbn_no(book.getIsbn_no());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setGenre(book.getGenre());
        bookDTO.setAvailabilty(book.isAvailabilty());
        bookDTO.setAvail_copies(book.getAvail_copies());
        return bookDTO;
    }
    public List<BookDTO> searchByTitle(String title) {
        List<Book> book = bookRepo.findAllBookByTitle(title.toLowerCase());
        System.out.println(title+" "+book.toString());
        List<BookDTO> bookDTOS = book.stream().map(this::getBook).toList();
        return bookDTOS;
    }

    public List<BookDTO> searchByAuthor(String author) {
        List<Book> book = bookRepo.findAllBookByAuthor(author.toLowerCase());
        List<BookDTO> bookDTOS = book.stream().map(this::getBook).toList();
        return bookDTOS;
    }

    public List<BookDTO> searchByISBN(long isbnNo) {
        List<Book> book = bookRepo.findAllBookByISBN(isbnNo);
        List<BookDTO> bookDTOS = book.stream().map(this::getBook).toList();
        return bookDTOS;
    }

    public List<BookDTO> searchByGenre(String genre) {
        List<Book> book =  bookRepo.findAllBookByGenre(genre.toLowerCase());
        List<BookDTO> bookDTOS = book.stream().map(this::getBook).toList();
        return bookDTOS;
    }

//    public List<BookDTO> searchByAvailability(String availability) {
//        List<Book> book = bookRepo.findAllBookByAvailability(availability.toLowerCase());
//        List<BookDTO> bookDTOS = book.stream().map(this::getBook).toList();
//        return bookDTOS;
//    }

    public String editBook(Book book) {
        if (bookRepo.findById(book.getIsbn_no()).orElse(null) != null) {
            bookRepo.save(book); // update existing book
            return "Book details updated successfully.";
        } else {
            bookRepo.save(book); // save new book
            return "New book details added successfully.";
        }
    }

    public String addNewBook(Book book) {
        bookRepo.save(book);
        return "New Book Added Successfully.";
    }

    public String deleteBookById(Long isbn_no) {
        if (bookRepo.existsById(isbn_no)) {
            bookRepo.deleteById(isbn_no);
            return "Book removed successfully.";
        } else {
            return "Book not found with id: " + isbn_no;
        }
    }

    public ResponseEntity<BookDTO> borrowBook(String bookId) {
        long longBookId = Long.parseLong(new String(Base64.getDecoder().decode(bookId)));
        Book book = bookRepo.findById(longBookId).orElse(null);

        if (book == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(getBook(book));
    }
}
