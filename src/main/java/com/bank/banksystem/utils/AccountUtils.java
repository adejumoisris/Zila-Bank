package com.bank.banksystem.utils;

import java.time.Year;

public class AccountUtils {

    public static final String ACCOUNT_EXISTS_CODE = "001";
    public static final String ACCOUNT_EXISTS_MESSAGE = "This user already have account created!";
    public static final String ACCOUNT_CREATION_SUCCESS = "002";
    public static final String ACCOUNT_CREATION_MESSAGE = " Account as being successfully created!";

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

