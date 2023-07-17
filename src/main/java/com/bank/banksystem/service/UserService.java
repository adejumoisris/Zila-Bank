package com.bank.banksystem.service;

import com.bank.banksystem.dto.request.UserRequest;
import com.bank.banksystem.dto.response.BankResponse;

public interface UserService {
    BankResponse createAccount(UserRequest userRequest);
}
