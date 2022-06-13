package com.chyberrhino.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chyberrhino.domain.State;

@Repository
public interface StateDAO extends JpaRepository<State, Integer>{
		
}
