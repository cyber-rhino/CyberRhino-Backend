package com.chyberrhino.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chyberrhino.domain.Service;

@Repository
public interface ServiceDAO extends JpaRepository<Service, Integer>{
		
}
