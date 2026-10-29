package com.fintrack.fintrack.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fintrack.fintrack.service.TransactionService;

import jakarta.validation.Valid;

import com.fintrack.fintrack.model.Transaction;

@RequestMapping ("/api/transactions")
@RestController 
public class TransactionController {
    
    private final TransactionService service;

    public TransactionController(TransactionService service){
        this.service = service;
    }

    @GetMapping
    public List<Transaction> listAll(){
        return service.listAll();
    }

    @PostMapping
    public Transaction save(@Valid @RequestBody Transaction transaction){
        return service.save(transaction);
    }

    @GetMapping ("/{id}")
    public Transaction findById(@PathVariable long id){
        return service.findById(id);
    }

    @PutMapping ("/{id}")
    public Transaction update(@PathVariable long id, @Valid @RequestBody Transaction transaction){
        return service.update(id, transaction);
    }

    @DeleteMapping ("/{id}")
    public void delete(@PathVariable long id){
        service.delete(id);
    }


}
