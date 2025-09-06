package com.byte_trio.fine_service.controller;

import com.byte_trio.fine_service.model.Fine;
import com.byte_trio.fine_service.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@RequestMapping("/fine")
public class FineController {

    @Autowired
    FineService fineService;

    @PostMapping("/add-fine")
    ResponseEntity<String> save(@RequestBody Fine fine){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(fineService.save(fine));
    }

    @GetMapping("checkfine")
    public ResponseEntity<Boolean> checkFine(@RequestParam String encoded_title){
        byte[] decodedbytes = Base64.getDecoder().decode(encoded_title);
        String fine_id = new String(decodedbytes);
        Boolean paidStatus = fineService.checkFine(fine_id);
        if (paidStatus == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.FOUND).body(paidStatus);
        }
    }

    @DeleteMapping("deletefine")
    public ResponseEntity<String> deleteFine(@RequestParam String id){
        return ResponseEntity.status(HttpStatus.OK).body(fineService.deletefine(id));
    }
}
