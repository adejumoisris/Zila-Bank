package com.bank.banksystem.utils;

import java.time.Year;

public class AccountUtils {

    public static final String ACCOUNT_EXISTS_CODE = "001";
    public static final String ACCOUNT_EXISTS_MESSAGE = "This user already have account created!";
    public static final String ACCOUNT_CREATION_SUCCESS = "002";
    public static final String ACCOUNT_CREATION_MESSAGE = " Account as being successfully created!";
    public static final String ACCOUNT_NOT_EXIST_CODE = "003";
    public static  final String ACCOUNT_NOT_EXIST_MESSAGE = "User with the provided account Number does not exist";
    public static final String ACCOUNT_FOUND_CODE = "004";
    public static final String ACCOUNT_FOUND_SUCCESS= "User Account Found ";
    public static final String ACCOUNT_CREDITED_SUCCESS = "005";
    public static final String ACCOUNT_CREDITED_SUCCESS_MESSAGE = "User credited account";
    public static  final String INSUFFICIENT_BALANCE_CODE = "006";
    public static final String INSUFFICIENT_BALANCE_MESSAGE = "Insufficient Balance";
    public static final String ACCOUNT_DEBITED_SUCCESS = "007";
    public static final String ACCOUNT_DEBITED_MESSAGE = "Account as being successfuly debited";
    public static final String  TRANSFER_SUCCESSFUL_CODE ="008";
    public static final String  TRANSFER_SUCCESSFUL_MESSAGE= "Transfer Successful";




    // << this static methods shows that , this methods is applied to all users
    public static String generateAccountNumber(){
        /**
         * method that generate account number which will have current year
         * 2023 + and any random six digit
         */
        // current year
        Year currentYear = Year.now();
        // minimum six digit
        int min = 100000;
        // maximum six digit
        int max = 999999;
        // generate a random number btw min and max
        int randNumber = (int) Math.floor (Math.random() * (max -min +1) +min) ;
        // convert the current and randomNumber to strings , then concatenate them

        String year = String.valueOf(currentYear);
        String randomNumber = String.valueOf(randNumber);
        // to append it
        StringBuilder accountNumber = new StringBuilder();
        return accountNumber.append(year).append(randomNumber).toString();


    }

}

