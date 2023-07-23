package com.bank.banksystem.controller;

import com.bank.banksystem.dto.request.CreditDebitRequest;
import com.bank.banksystem.dto.request.EnquiryRequest;
import com.bank.banksystem.dto.request.TransferRequest;
import com.bank.banksystem.dto.request.UserRequest;
import com.bank.banksystem.dto.response.BankResponse;
import com.bank.banksystem.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "User Account management APIs")
@RequestMapping("api/user")
public class UserController {
    @Autowired
    UserService userService;
    // swagger configuration documentation
    //<-----------------------------------Swagger---------------------------------------------->
    @Operation(
            summary = "Create new User Account ",
            description = "creating a new user and assigning an account Id"
    )
    @ApiResponse(
            responseCode = "201",
            description = " http status 201 CREATED"
    )
    //<------------------------------------------Swagger---------------------------------------->
    @PostMapping
    public BankResponse createAccount(@RequestBody UserRequest userRequest){
        return userService.createAccount(userRequest);
    }

    @Operation(
            summary = "Balance Enquiry ",
            description = "Given an account number check how much the user has"
    )
    @ApiResponse(
            responseCode = "200",
            description = " http status 200 SUCCESS"
    )

    @GetMapping("balanceEnquiry")
    public BankResponse BalanceEnquiry(@RequestBody EnquiryRequest request){
        return userService.balanceEnquiry(request);

    }

    @GetMapping("nameEnquiry")
    public String nameEnquiey(@RequestBody EnquiryRequest request){
        return userService.nameEnquiry(request);
    }
    
     @PostMapping("credit")
    public BankResponse creditAccount(@RequestBody CreditDebitRequest request){
        return userService.creditAccount(request);
     }

     @PostMapping("debit")
    public BankResponse debitAccount(@RequestBody CreditDebitRequest request){
        return userService.debitAccount(request);
     }

     @PostMapping("transfer")
    public  BankResponse  transfer(@RequestBody TransferRequest request){
        return userService.transfer(request);
     }


}
