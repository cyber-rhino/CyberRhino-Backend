package com.chyberrhino;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.chyberrhino.dao.CategoryDAO;
import com.chyberrhino.domain.Category;

@SpringBootApplication
public class ChyberrhinoApplication implements CommandLineRunner{

	@Autowired
	private CategoryDAO categoryDAO;
	public static void main(String[] args) {
		SpringApplication.run(ChyberrhinoApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Design");
		Category cat2 = new Category(null, "Hardware");
		Category cat3 = new Category(null, "Software");
		
		categoryDAO.saveAll(Arrays.asList(cat1, cat2, cat3));
	}

}
