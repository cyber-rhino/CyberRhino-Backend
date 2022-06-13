package com.chyberrhino;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.chyberrhino.dao.CategoryDAO;
import com.chyberrhino.dao.CityDAO;
import com.chyberrhino.dao.ServiceDAO;
import com.chyberrhino.dao.StateDAO;
import com.chyberrhino.domain.Category;
import com.chyberrhino.domain.City;
import com.chyberrhino.domain.Service;
import com.chyberrhino.domain.State;

@SpringBootApplication
public class ChyberrhinoApplication implements CommandLineRunner{

	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ServiceDAO serviceDAO;
	@Autowired
	private StateDAO stateDAO;
	@Autowired
	private CityDAO cityDAO;
	
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
		serviceDAO.saveAll(Arrays.asList(s1 ,s2 ,s3));
		
		State es1 = new State(null, "CE");
		State es2 = new State(null, "SP");
		
		City c1 = new City(null, "Acopiara", es1);
		City c2 = new City(null, "São Paulo", es2);
		City c3 = new City(null, "Flamengo", es1);
		
		stateDAO.saveAll(Arrays.asList(es1,es2));
		cityDAO.saveAll(Arrays.asList(c1, c2, c3));
		
	}

}
