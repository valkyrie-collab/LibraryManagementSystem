package com.byte_trio.entity_service.controller;

import com.byte_trio.entity_service.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entity")
public class EntityController {
    private EntityService service;
    @Autowired
    private void setService(EntityService service) {this.service = service;}
}
