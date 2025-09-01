package com.byte_trio.transaction_service.controller;

import com.byte_trio.transaction_service.repository.TransactionRepository;
import com.byte_trio.transaction_service.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private TransactionService service;
    @Autowired
    private void setService(TransactionService service) {this.service = service;}
}
