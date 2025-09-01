package com.byte_trio.transaction_service.service;

import com.byte_trio.transaction_service.config.TokenConfig;
import com.byte_trio.transaction_service.feign.EntityFeignController;
import com.byte_trio.transaction_service.feign.FineFeignController;
import com.byte_trio.transaction_service.model.*;
import com.byte_trio.transaction_service.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    private TransactionRepository repo;
    @Autowired
    private void setRepo(TransactionRepository repo) {this.repo = repo;}

    private TokenConfig config;
    @Autowired
    private void setConfig(TokenConfig config) {this.config = config;}

    private EntityFeignController feign;
    @Autowired
    private void setFeign(EntityFeignController feign) {this.feign = feign;}

    private FineFeignController fineFeign;
    @Autowired
    private void setFineFeign(FineFeignController fineFeign) {this.fineFeign = fineFeign;}

    public ResponseEntity<String> save(String token, Transaction transaction) {
        String username = config.getUsername(token);
        String encodedUsername = Base64.getEncoder().encodeToString(username.getBytes());
        ResponseEntity<EntityDTO> response = feign.find(encodedUsername);

        if (!response.getStatusCode().equals(HttpStatusCode.valueOf(200)) || response.getBody() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("member not present");
        }

        String uuid = UUID.randomUUID().toString();
        transaction = transaction.setId(uuid).setBorrowerId(username);
        repo.save(transaction);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("saved successfully....");
    }

    public ResponseEntity<String> bookReturn(String token, String transactionId, String lateReason) {
        String username = config.getUsername(token);
//        bookId = new String(Base64.getDecoder().decode(bookId));
        transactionId = new String(Base64.getDecoder().decode(transactionId));
        Transaction transaction = repo.findById(transactionId).orElse(null);

        if (transaction == null || !transaction.getBorrowerId().equals(username)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("transaction with such Id not present...");
        }

        Date dueDate = new Date(System.currentTimeMillis());
        repo.updateDueDate(dueDate, username);
//        transaction.setDueDate(dueDate);

        long days = (dueDate.getTime() -
                transaction.getReturnDate().getTime()) / (1000 * 60 * 60 * 24);

        if (days > 0) {
            String uuid = UUID.randomUUID().toString();
            Fine fine = new Fine().setMemberId(username)
                    .setId(uuid).setAmount(11.9 * days).setReason(lateReason).setPaidStatus(false);
            fineFeign.save(fine);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("fine given....");
        }

//        repo.deleteById(transactionId);
//
//        return repo.findById(transactionId).orElse(null) == null?
//                ResponseEntity.status(HttpStatus.OK).body("The transaction removed successfully...") :
//                ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Transaction not removed.....");
        return ResponseEntity.status(HttpStatus.OK).body("Successfully.. book returned");
    }

    public ResponseEntity<List<BookDTO>> numberOfBooksBorrowed(String token) {
        String username = config.getUsername(token);
        //continue next time, controller left not done,
        // remove first one after 50 history, entity and transaction .properties
    }

}
