package com.byte_trio.transaction_service.feign;

import com.byte_trio.transaction_service.model.EntityDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("ENTITY-SERVICE")
public interface EntityFeignController {
    @GetMapping("/entity/find-entity")
    ResponseEntity<EntityDTO> find(@RequestParam String id); //encoded data is accepted; status code 200
}
