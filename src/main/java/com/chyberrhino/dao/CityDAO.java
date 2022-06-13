package com.chyberrhino.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chyberrhino.domain.City;

@Repository
public interface CityDAO extends JpaRepository<City, Integer>{
		
}
