package com.bank.persistence.repository;

 
import org.springframework.data.jpa.repository.JpaRepository;
 import com.bank.persistence.entity.ClientEntity;

public interface ClientJpaRepository   extends  JpaRepository<ClientEntity, String>  {
	
	
    // Account makeDepotInAccount();

    
    // Account makeWithDrawFromAccount();

}
