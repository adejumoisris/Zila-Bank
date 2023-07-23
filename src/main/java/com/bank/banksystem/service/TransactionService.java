package com.bank.banksystem.service;

import com.bank.banksystem.dto.request.TransactionDto;
import com.bank.banksystem.entity.Transaction;

public interface TransactionService {
    void saveTransaction(TransactionDto transactionDto);
}
