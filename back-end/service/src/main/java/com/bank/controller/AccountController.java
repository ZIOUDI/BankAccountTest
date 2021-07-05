package com.bank.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Account;
import com.bank.service.ClientBankDomainServiceAdapter;

 
@RestController
@RequestMapping("/api/v1/clients/steve.jobs")
public class AccountController  {
	
	@Autowired
	ClientBankDomainServiceAdapter bankDomainServiceAdapter;
 
	@GetMapping("/accounts/{idClient}")
	public ResponseEntity<Account> getAccountByClientId(
			@PathVariable(name="idClient") String idClient){
		System.out.println("****************************    @GetMapping   **********************************");

		Account account = bankDomainServiceAdapter.readAccount(idClient);
		System.out.println(account);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
    
	
	@PutMapping("/depot/{idClient}/{plus}")
    public ResponseEntity<Account> deposerInMyAccount (
			@PathVariable(name="idClient") String idClient,
			@PathVariable(name="plus") double plus){
		
		Account account = bankDomainServiceAdapter.readAccount(idClient);
  		try {
 			bankDomainServiceAdapter.depositAccount(idClient, plus);
			
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
		}		
		return new ResponseEntity<Account>(account, HttpStatus.ACCEPTED);
	}
	
	
	@PutMapping("/retrait/{idClient}/{minus}")
    public ResponseEntity<Account> retraitInMyAccount (
			@PathVariable(name="idClient") String idClient,
			@PathVariable(name="minus") double min){
		
		Account account = bankDomainServiceAdapter.readAccount(idClient);
  		try {
 			bankDomainServiceAdapter.withdrawAccount(idClient, min);
			
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
		}		
		return new ResponseEntity<Account>(account, HttpStatus.ACCEPTED);
	}

 
}
