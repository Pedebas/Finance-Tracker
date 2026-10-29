package com.fintrack.fintrack.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity 
@Table(name = "transactions")
public class Transaction {
    
    @Id 
    @GeneratedValue 
    long id;
    
    @NotBlank(message = "A descrição é obrigatória")
    @Column 
    String description;
    
    @Column(precision = 12, scale = 2)
    @NotNull 
    @Positive 
    BigDecimal value;

    @Enumerated(EnumType.STRING)
    @NotNull 
    TransactionType type;

    @Column 
    @NotNull 
    LocalDate date;

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
