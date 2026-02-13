package com.example.wallet.service;

import com.example.wallet.entity.User;
import com.example.wallet.entity.Wallet;
import com.example.wallet.repository.UserRepository;
import com.example.wallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository, WalletRepository walletRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {

        User savedUser = userRepository.save(user);

        Wallet wallet = new Wallet();
        wallet.setUser(savedUser);
        wallet.setBalance(BigDecimal.ZERO);

        return savedUser;
    }
}
