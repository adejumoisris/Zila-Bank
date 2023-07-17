package com.bank.banksystem.service.impl;

import com.bank.banksystem.dto.request.EmailDetails;
import com.bank.banksystem.dto.request.UserRequest;
import com.bank.banksystem.dto.response.AccountInfo;
import com.bank.banksystem.dto.response.BankResponse;
import com.bank.banksystem.entity.Users;
import com.bank.banksystem.repository.UserRepository;
import com.bank.banksystem.service.EmailService;
import com.bank.banksystem.service.UserService;
import com.bank.banksystem.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class UserServiceImpl implements UserService {
    // service communicating with the database
    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailService emailService;

    // <<<<<< creating account which a return type of BankResponse which as an input of UserRequest >>>>>>
    @Override
    public BankResponse createAccount(UserRequest userRequest) {
        /**
         * creating an account is usually creating a new user into DB
         * is by instatiating a new user using builder patter
         * check if user already has an account
         */
        // << checking if the user ALlready Exist in the database
        if (userRepository.existsByEmail(userRequest.getEmail())){
            // returning a custom message to the user interface
           return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_EXISTS_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
                   .accountInfo(null)
                    .build();


        }
        // <<creating an Instance of user making use of design pattern getting it from the User Request >>
        Users newUser = Users.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .otherName(userRequest.getOtherName())
                .gender(userRequest.getGender())
                .address(userRequest.getAddress())
                .stateOfOrigin(userRequest.getStateOfOrigin())
                // there should be method that generate ramdom account number
                .accountNumber(AccountUtils.generateAccountNumber())
                .accountBalance(BigDecimal.ZERO)
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                .alternativePhoneNumber(userRequest.getAlternativePhoneNumber())
                .status("ACTIVE")

                .build();

        Users saveUser = userRepository.save(newUser);
        // sending email Alert to the user
        EmailDetails emailDetails = EmailDetails.builder()
                .recipient(saveUser.getEmail())
                .subject("ACCOUNT CREATION ")
                .messageBody("Congratulation! Your account as been successfully created.\n Your account details:\n" + "Account Name: " + saveUser.getFirstName() + " "  + saveUser.getLastName() + " " + saveUser.getOtherName() + "\n Account Number : " + saveUser.getAccountNumber())
                .build();
        emailService.sendEmailAlert(emailDetails);
        return BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS)
                .responseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE)
                .accountInfo(AccountInfo.builder()
                        .accountBalance(saveUser.getAccountBalance())
                        .accountNumber(saveUser.getAccountNumber())
                        .accountName(saveUser.getFirstName() + " " + saveUser.getLastName() + " " + saveUser.getOtherName())
                        .build())

                .build();
    }
}
