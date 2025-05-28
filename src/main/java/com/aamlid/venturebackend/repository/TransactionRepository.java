package com.aamlid.venturebackend.repository;

import com.aamlid.venturebackend.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findTop10ByOrderByTimestampDesc();
}
