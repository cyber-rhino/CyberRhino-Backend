package com.chyberrhino.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chyberrhino.domain.Category;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Integer>{
		
}
