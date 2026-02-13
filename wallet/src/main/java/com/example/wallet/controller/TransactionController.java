package com.example.wallet.controller;

import com.example.wallet.dto.TransferDTO;
import com.example.wallet.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService service;

    @PostMapping("/transfer")
    public ResponseEntity<Void> transfer(@RequestBody TransferDTO dto) {
        service.transfer(dto);
        return ResponseEntity.ok().build();
    }
}
