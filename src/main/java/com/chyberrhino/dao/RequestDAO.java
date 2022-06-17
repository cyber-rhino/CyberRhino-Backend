package com.chyberrhino.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chyberrhino.domain.Request;

@Repository
public interface RequestDAO extends JpaRepository<Request, Integer>{
		
}
