package com.example.wallet.controller;

import com.example.wallet.entity.Wallet;
import com.example.wallet.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallets")
public class WalletController {

    private final WalletService service;

    public WalletController(WalletService service) {
        this.service = service;
    }

    @GetMapping("/{userId}")
    public Wallet getBalance(@PathVariable Long userId) {
        return service.getByUserId(userId);
    }
}
