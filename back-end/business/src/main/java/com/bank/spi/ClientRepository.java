package com.bank.spi;

import java.sql.ResultSet;

import com.bank.model.Account;

public interface ClientRepository extends H2_ConnexionRepo{
	
	
	public static final String ACCOUNT_SELECT_QUERY =
    		"select distinct a.* from account a where a.owner_id = :clientId";
	
	public static final String ACCOUNT_DEPOT_QUERY =
    		"update account a  set a.balance = (a.balance+ :deposit) where a.owner_id = :clientId";
	
	public static final String ACCOUNT_RETRAIT_QUERY =
    		"update account a  set a.balance = (a.balance - :deposit) where a.owner_id = :clientId";
	
	
	    //  ResultSet getAccountByClientId();
}
