package com.chyberrhino.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chyberrhino.domain.Client;

@Repository
public interface ClientDAO extends JpaRepository<Client, Integer>{
		
}
