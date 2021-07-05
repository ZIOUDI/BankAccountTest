package com.bank.domain;

import com.bank.api.ClientBankDomain;
import com.bank.model.Account;
import com.bank.spi.AccountRepository;
import com.bank.spi.ClientRepository;

/*
 * THIS IS NOT EXPECTED TO BECOME A SPRING-BOOT SERVICE
 */
public class ClientBankDomainImpl implements ClientBankDomain {
	
	  

    private AccountRepository accountRepository; 
    // call this to read and save accounts but no need to implement how for the moment
    
    
    private ClientRepository clientRepository;  
    // call this to read and save clients but no need to implement how for the moment
	
    
    @Override
	public Account readAccount(String code) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Account depositAccount(String code, double plus) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Account withdrawAccount(String code, double min) {
		// TODO Auto-generated method stub
		return null;
	}

    // DEFINE METHODS HERE. PAY ATTENTION TO INTERFACE
    
    
    
    
    
}