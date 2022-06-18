package com.chyberrhino.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chyberrhino.domain.RequestedItem;

@Repository
public interface RequestedItemDAO extends JpaRepository<RequestedItem, Integer>{
		
}
