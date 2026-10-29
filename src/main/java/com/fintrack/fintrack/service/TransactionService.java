package com.fintrack.fintrack.service;

import com.fintrack.fintrack.repository.TransactionRepository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fintrack.fintrack.model.Transaction;

@Service 
public class TransactionService {
    
    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository){
        this.repository = repository;
    }

    public List<Transaction> listAll(){
        return repository.findAll();
    }

    public Transaction save(Transaction transaction){
        return repository.save(transaction);
    }

    public Transaction findById(long id){
        return repository.findById(id).orElseThrow(() -> new TransactionNotFoundException(id));
    }

    public Transaction update(long id, Transaction updatedData) {
        Transaction transaction = findById(id);

        transaction.setDescription(updatedData.getDescription());
        transaction.setValue(updatedData.getValue());
        transaction.setType(updatedData.getType());
        transaction.setDate(updatedData.getDate());

        return repository.save(transaction);
    }

    public void delete(long id){
        Transaction transaction = findById(id);
        repository.delete(transaction);
    }



}
