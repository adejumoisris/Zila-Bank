package com.bank.banksystem.service;

import com.bank.banksystem.dto.request.CreditDebitRequest;
import com.bank.banksystem.dto.request.EnquiryRequest;
import com.bank.banksystem.dto.request.TransferRequest;
import com.bank.banksystem.dto.request.UserRequest;
import com.bank.banksystem.dto.response.BankResponse;

public interface UserService {
    BankResponse createAccount(UserRequest userRequest);
    // Balance Enquiry
    BankResponse balanceEnquiry(EnquiryRequest request);
    // Name Enquiry
    String nameEnquiry(EnquiryRequest request);
    // to credit account
    BankResponse creditAccount(CreditDebitRequest request );
    // to debit an Account
    BankResponse debitAccount(CreditDebitRequest request);
    // Transfering money to Another Account
    BankResponse transfer(TransferRequest request);
}
