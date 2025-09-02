package com.byte_trio.entity_service.service;

import com.byte_trio.entity_service.config.TokenConfig;
import com.byte_trio.entity_service.feign.BookFeignClients;
import com.byte_trio.entity_service.model.EntityDTO;
import com.byte_trio.entity_service.model.EntityField;
import com.byte_trio.entity_service.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class EntityService {
    private EntityRepository repo;
    @Autowired
    private void setRepo(EntityRepository repo) {this.repo = repo;}

    private TokenConfig config;
    @Autowired
    private void setConfig(TokenConfig config) {this.config = config;}

    private BookFeignClients feign;
    @Autowired
    private void setFeign(BookFeignClients feign) {this.feign = feign;}

    public ResponseEntity<String> save(String token, EntityField entityField) {
        entityField = entityField.setId(config.getUsername(token));
        repo.save(entityField);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Saved successfully...");
    }

    public ResponseEntity<String> update(String token, EntityField entityField) {
        String username = config.getUsername(token);
        EntityField presentEntity = repo.findById(username).orElse(null);

        if (presentEntity == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The user is not present");
        }

        entityField = entityField.setId(username);

        if (!entityField.toString().equals(presentEntity.toString())) {
            repo.save(entityField);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("update successful...");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This update is not do able");
    }

//    public ResponseEntity<String> borrowBook(String token, String bookId) {
//        bookId = new String(Base64.getDecoder().decode(bookId));
//        String username = config.getUsername(token);
//        ResponseEntity<Book> book = feign.borrowBook(bookId);
//
//        if (repo.findById(username).orElse(null) == null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//
//        if (!book.getStatusCode().equals(HttpStatusCode.valueOf(200))) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//
//        repo.updateBookBorrow(bookId, username);
//
//        String bId = repo.getBookId(username);
//
//        return bId == null || bId.isEmpty()?
//                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null) :
//                ResponseEntity.status(HttpStatus.ACCEPTED).body("updated successfully...");
//    }

    public ResponseEntity<EntityDTO> findMember(String id) {
        id = new String(Base64.getDecoder().decode(id));
        EntityField field = repo.findById(id).orElse(null);

        if (field == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(new EntityDTO().setId(field.getId())
                .setName(field.getName()).setEmail(field.getEmail()).setPhoneNumber(field.getPhoneNumber()));
    }

    public ResponseEntity<String> removeMember(String id) {
        id = new String(Base64.getDecoder().decode(id));

        if (repo.findById(id).orElse(null) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Already deleted");
        }

        repo.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("delete successfully...");
    }
}
