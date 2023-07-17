package com.bank.banksystem.repository;

import com.bank.banksystem.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    //  check if user already exist in database
    Boolean existsByEmail(String email);
}
