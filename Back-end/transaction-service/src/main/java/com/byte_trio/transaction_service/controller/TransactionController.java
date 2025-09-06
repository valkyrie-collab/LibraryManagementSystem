package com.byte_trio.transaction_service.controller;

import com.byte_trio.transaction_service.model.BookDTO;
import com.byte_trio.transaction_service.model.Transaction;
import com.byte_trio.transaction_service.model.TransactionDTO;
import com.byte_trio.transaction_service.repository.TransactionRepository;
import com.byte_trio.transaction_service.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private TransactionService service;
    @Autowired
    private void setService(TransactionService service) {this.service = service;}

    @PostMapping("/save-transaction")
    public ResponseEntity<String> save(@RequestParam String username,
                                       @RequestBody Transaction transaction) {return service.save(username, transaction);}

    @PostMapping("/return-book")
    public ResponseEntity<String> returnBook(@RequestParam String transactionId, @RequestParam String lateReason) {
        return service.bookReturn(transactionId, lateReason);
    }

    @GetMapping("/borrowed-book")
    public ResponseEntity<List<TransactionDTO>> getBooks(@RequestParam String token) {
        return service.numberOfBooksBorrowed(token);
    }
}
