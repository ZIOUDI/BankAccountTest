package com.bank.api;

import com.bank.model.Account;

/**
 * This interface should define the behavior of the service
 */
public interface ClientBankDomain {
	
 	//	Scenario: a client should be able to read his accounts
	    public Account readAccount(String code);
	    
	 // Scenario: a client should be able to make a deposit on his accounts
	    public Account depositAccount(String code , double plus);
	    
	 // Scenario: a client should be able to make a withdraw from his accounts
	    public Account withdrawAccount(String code , double min);
}
