package com.example.springboot.Repository;

import com.example.springboot.model.CarBuyingRequest;
import com.example.springboot.model.Transaction;
import com.example.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {


    List<Transaction> findTransactionByUser(User user );

}
