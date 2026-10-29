
package com.fintrack.fintrack.service;

public class TransactionNotFoundException extends RuntimeException {

    public TransactionNotFoundException(long id) {
        super("Transação não encontrada com o ID: " + id);
    }
}
