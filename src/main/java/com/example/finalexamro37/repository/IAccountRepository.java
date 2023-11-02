package com.example.finalexamro37.repository;

import com.example.finalexamro37.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Integer> {
}
