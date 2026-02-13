package com.example.wallet.service;

import com.example.wallet.entity.Wallet;
import com.example.wallet.exception.BusinessException;
import com.example.wallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private final WalletRepository repository;

    public WalletService(WalletRepository repository) {
        this.repository = repository;
    }

    public Wallet getByUserId(Long userId) {
        return repository.findByUserId(userId)
                .orElseThrow(() -> new BusinessException("Wallet not found"));
    }
}
