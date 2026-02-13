package com.example.wallet.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class TransferDTO {
    private Long payer;
    private Long payee;
    private BigDecimal amount;
}
