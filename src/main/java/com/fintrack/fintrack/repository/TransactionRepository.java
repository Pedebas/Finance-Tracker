package com.fintrack.fintrack.repository;

import com.fintrack.fintrack.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

        
    }