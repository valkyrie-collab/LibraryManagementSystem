package com.byte_trio.entity_service.feign;

import com.byte_trio.entity_service.model.BookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("BOOK-SERVICE")
public interface BookFeignClients {

    @GetMapping("/book/borrow-book")
    ResponseEntity<BookDTO> borrowBook(@RequestParam String bookId);
}
