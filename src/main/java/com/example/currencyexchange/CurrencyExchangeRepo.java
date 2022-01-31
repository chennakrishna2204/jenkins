package com.example.currencyexchange;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CurrencyExchangeRepo extends CrudRepository<CurrencyExchange, Long>{

	
	CurrencyExchange findByFromAndTo(String from,String to);
	

}
