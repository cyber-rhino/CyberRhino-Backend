package com.chyberrhino.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chyberrhino.dao.CategoryDAO;
import com.chyberrhino.domain.Category;
import com.chyberrhino.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDAO repo;
	public Category find(Integer id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found ID: " + id + ", Type: " + Category.class.getName()));
	}
	
}
