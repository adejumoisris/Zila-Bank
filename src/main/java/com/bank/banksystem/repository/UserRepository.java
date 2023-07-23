package com.bank.banksystem.repository;

import com.bank.banksystem.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    //  check if user already exist in database
    Boolean existsByEmail(String email);
    // check if account number already exist
    Boolean existsByAccountNumber(String accountNumber);
    // finding accountNumber in the database
    Users findByAccountNumber(String accountNumber);
}
