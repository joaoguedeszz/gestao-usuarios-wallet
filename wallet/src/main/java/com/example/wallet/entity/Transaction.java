package com.example.wallet.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long payer;
    private Long payee;

    private BigDecimal amount;
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;
}
