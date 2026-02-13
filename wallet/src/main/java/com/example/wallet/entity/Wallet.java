package com.example.wallet.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Data
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    private BigDecimal balance;

    @Version
    private Long version;

    public void setBalance(BigDecimal zero) {
    }

    public void setUser(User savedUser) {

    }
}
