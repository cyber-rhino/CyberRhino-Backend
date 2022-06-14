package com.chyberrhino.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chyberrhino.domain.Address;

@Repository
public interface AddressDAO extends JpaRepository<Address, Integer>{
		
}
