package com.bank.persistence.entity;

import javax.persistence.*;

import com.bank.model.Account;

@Entity
@Table(name = "ACCOUNT")
public class AccountEntity extends Account {

    public AccountEntity(String code) {
		super(code);
 	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;

    @ManyToOne
    private ClientEntity owner;

    private double balance = 0;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ClientEntity getOwner() {
        return owner;
    }

    public void setOwner(ClientEntity owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
