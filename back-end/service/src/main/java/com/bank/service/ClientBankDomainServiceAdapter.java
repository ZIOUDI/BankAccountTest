package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.api.ClientBankDomain;
import com.bank.model.Account;
import com.bank.persistence.entity.AccountEntity;
import com.bank.persistence.repository.AccountJpaRepository;
import com.bank.persistence.repository.ClientJpaRepository;

/**
 * THIS IS EXPECTED TO BECOME A SPRING-BOOT SERVICE
 */
@Service
public class ClientBankDomainServiceAdapter implements ClientBankDomain {
	
   @Autowired	ClientJpaRepository clientJpaRepository;
   @Autowired   AccountJpaRepository accountJpaRepository;

	@Override
	public Account readAccount(String code) {
		System.out.println("service : "+ accountJpaRepository.findAccount(code));
 		return accountJpaRepository.findAccount(code);
	}

	@Override
	public Account depositAccount(String code, double plus) {
 		return accountJpaRepository.makeDepotInAccount( code,  plus);
	}

	@Override
	public Account withdrawAccount(String code, double min) {
 		return accountJpaRepository.makeWithDrawFromAccount( code,  min);
	}

 
}
