package com.byte_trio.transaction_service.feign;

import com.byte_trio.transaction_service.model.Fine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("FINE-SERVICE")
public interface FineFeignController {

    @PostMapping("/fine/add-fine")
    ResponseEntity<String> save(@RequestBody Fine fine);
}
