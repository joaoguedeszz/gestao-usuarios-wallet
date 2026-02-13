package com.example.wallet.service;

import com.example.wallet.dto.TransferDTO;
import com.example.wallet.entity.*;
import com.example.wallet.exception.BusinessException;
import com.example.wallet.repository.TransactionRepository;
import com.example.wallet.repository.UserRepository;
import com.example.wallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final WalletRepository walletRepository;
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    @Transactional
    public void transfer(TransferDTO dto) {

        if (dto.getAmount().doubleValue() <= 0) {
            throw new BusinessException("Invalid amount");
        }

        User payer = userRepository.findById(dto.getPayer())
                .orElseThrow(() -> new BusinessException("Payer not found"));

        if (payer.getType() == UserType.MERCHANT) {
            throw new BusinessException("Merchant cannot send money");
        }

        Wallet payerWallet = walletRepository.findByUserId(dto.getPayer())
                .orElseThrow(() -> new BusinessException("Wallet not found"));

        Wallet payeeWallet = walletRepository.findByUserId(dto.getPayee())
                .orElseThrow(() -> new BusinessException("Wallet not found"));

        if (payerWallet.getBalance().compareTo(dto.getAmount()) < 0) {
            throw new BusinessException("Insufficient balance");
        }

        payerWallet.setBalance(payerWallet.getBalance().subtract(dto.getAmount()));
        payeeWallet.setBalance(payeeWallet.getBalance().add(dto.getAmount()));

        walletRepository.save(payerWallet);
        walletRepository.save(payeeWallet);

        Transaction transaction = new Transaction();
        transaction.setPayer(dto.getPayer());
        transaction.setPayee(dto.getPayee());
        transaction.setAmount(dto.getAmount());
        transaction.setDate(LocalDateTime.now());
        transaction.setStatus(TransactionStatus.SUCCESS);

        transactionRepository.save(transaction);
    }
}
