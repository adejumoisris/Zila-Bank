package com.bank.banksystem.service.impl;

import com.bank.banksystem.dto.request.TransactionDto;
import com.bank.banksystem.entity.Transaction;
import com.bank.banksystem.repository.TransactionRepository;
import com.bank.banksystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public void saveTransaction(TransactionDto transactionDto) {
         Transaction transaction = Transaction.builder()
                 .transactionType(transactionDto.getTransactionType())
                 .accountNumber(transactionDto.getAccountNumber())
                 .amount(transactionDto.getAmount())
                 .status("SUCCESS")
                 .build();
         transactionRepository.save(transaction);
        System.out.println("Transaction saved Successfully");
    }
}
