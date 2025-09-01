package com.byte_trio.entity_service.feign;

import com.byte_trio.entity_service.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("BOOK-SERVICE")
public interface BookFeignClients {

    @GetMapping("/book/borrow-book")
    ResponseEntity<List<Book>> borrowBook(@RequestParam String bookId);
}
