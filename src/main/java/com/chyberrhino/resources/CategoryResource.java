package com.chyberrhino.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chyberrhino.domain.Category;

@RestController
@RequestMapping(value= "/categories")
public class CategoryResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Category> lista() {
		Category cat = new Category(1,"Hardware");
		Category cat2 = new Category (2,"Design");
		Category cat3 = new Category(3,"Software");
		
		List<Category> Lista = new ArrayList<>();
		Lista.add(cat3);
		Lista.add(cat2);
		Lista.add(cat);
		
		return Lista;
	}
}
