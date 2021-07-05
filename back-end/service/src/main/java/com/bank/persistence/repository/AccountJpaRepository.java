package com.bank.persistence.repository;

 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.persistence.entity.AccountEntity;

@Repository
public interface AccountJpaRepository extends  JpaRepository<AccountEntity, String>  {
	
	
	@Query(value="select distinct a.* from account a where a.owner_id = ?clientId", nativeQuery=true)
	AccountEntity findAccountByClientId(@Param("clientId") String code);
	
	@Query(value = "update account a  set a.balance = (a.balance+ :depot) where a.owner_id = :clientId",nativeQuery = true)
	AccountEntity makeDepotInAccount(@Param("clientId") String code, @Param("depot") double plus);
    
	@Query(value = "update account a  set a.balance = (a.balance - :retrait) where a.owner_id = :clientId",nativeQuery = true)
	AccountEntity makeWithDrawFromAccount(@Param("clientId") String code, @Param("retrait") double min);

}
