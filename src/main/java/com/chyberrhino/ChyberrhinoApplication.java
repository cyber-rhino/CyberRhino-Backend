package com.chyberrhino;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.chyberrhino.dao.CategoryDAO;
import com.chyberrhino.dao.ServiceDAO;
import com.chyberrhino.domain.Category;
import com.chyberrhino.domain.Service;

@SpringBootApplication
public class ChyberrhinoApplication implements CommandLineRunner{

	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ServiceDAO serviceDAO;
	
	public static void main(String[] args) {
		SpringApplication.run(ChyberrhinoApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Design");
		Category cat2 = new Category(null, "Hardware");
		Category cat3 = new Category(null, "Software");
		
		Service s1 = new Service(null, "Manutenção", 200.00);
		Service s2 = new Service(null, "Front-end", 250.00);
		Service s3 = new Service(null, "Web Design", 100.00);
		
		cat1.getServices().addAll(Arrays.asList(s3));
		cat2.getServices().addAll(Arrays.asList(s1));
		cat3.getServices().addAll(Arrays.asList(s2));
		
		s1.getCategorys().addAll(Arrays.asList(cat2));
		s2.getCategorys().addAll(Arrays.asList(cat3));
		s3.getCategorys().addAll(Arrays.asList(cat1));
		
		categoryDAO.saveAll(Arrays.asList(cat1, cat2, cat3));
		serviceDAO.saveAll(Arrays.asList(s1,s2,s3));
		
	}

}
