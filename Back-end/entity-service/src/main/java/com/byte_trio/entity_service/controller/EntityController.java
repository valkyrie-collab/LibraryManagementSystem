package com.byte_trio.entity_service.controller;

import com.byte_trio.entity_service.model.EntityDTO;
import com.byte_trio.entity_service.model.EntityField;
import com.byte_trio.entity_service.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entity")
public class EntityController {
    private EntityService service;
    @Autowired
    private void setService(EntityService service) {this.service = service;}

    @PostMapping("/save-entity")
    public ResponseEntity<String> save(@RequestParam String token,
                                       @RequestBody EntityField entityField) {return service.save(token, entityField);}

    @PostMapping("/update-entity")
    public ResponseEntity<String> update(@RequestParam String token,
                                         @RequestBody EntityField entityField) {return service.update(token, entityField);}

    @GetMapping("/find-entity")
    public ResponseEntity<EntityDTO> find(@RequestParam String id) {return service.findMember(id);}

    @DeleteMapping("/remove-member")
    public ResponseEntity<String> remove(@RequestParam String id) {return service.removeMember(id);}
}
