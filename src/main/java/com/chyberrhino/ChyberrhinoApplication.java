package com.chyberrhino;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.chyberrhino.dao.AddressDAO;
import com.chyberrhino.dao.CategoryDAO;
import com.chyberrhino.dao.CityDAO;
import com.chyberrhino.dao.ClientDAO;
import com.chyberrhino.dao.PaymentDAO;
import com.chyberrhino.dao.RequestDAO;
import com.chyberrhino.dao.ServiceDAO;
import com.chyberrhino.dao.StateDAO;
import com.chyberrhino.domain.Address;
import com.chyberrhino.domain.CardPayment;
import com.chyberrhino.domain.Category;
import com.chyberrhino.domain.City;
import com.chyberrhino.domain.Client;
import com.chyberrhino.domain.Payment;
import com.chyberrhino.domain.Request;
import com.chyberrhino.domain.Service;
import com.chyberrhino.domain.SlipPayment;
import com.chyberrhino.domain.State;
import com.chyberrhino.domain.enums.PaymentStatus;
import com.chyberrhino.domain.enums.TypeClient;

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
	@Autowired
	private ClientDAO clientDAO;
	@Autowired
	private AddressDAO addressDAO;
	@Autowired
	private PaymentDAO paymentDAO;
	@Autowired
	private RequestDAO requestDAO;
	
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
		
		City ct1 = new City(null, "Acopiara", es1);
		City ct2 = new City(null, "São Paulo", es2);
		City ct3 = new City(null, "Flamengo", es1);
		
		stateDAO.saveAll(Arrays.asList(es1,es2));
		cityDAO.saveAll(Arrays.asList(ct1, ct2, ct3));
		
		Client cli1 = new Client(null, "Jadson", "jadson@gmail.com", "31293872183", TypeClient.PHYSICALPERSON);
		Client cli2 = new Client(null, "Kilmer", "kilmer@gmail.com", "31293772183", TypeClient.PHYSICALPERSON);
		
		cli1.getPhones().addAll(Arrays.asList("3283198372", "29381321831"));
		cli2.getPhones().addAll(Arrays.asList("9983987212"));
		
		Address ad1 = new Address(null, "Avenida", "476", "apto 289", "Centro", "63560000", cli2, ct1);
		Address ad2 = new Address(null, "Fransisco pereira de souza", "900", "apto 89", "Vila esperança", "63560000", cli1, ct2);
		
		cli1.getAdresses().addAll(Arrays.asList(ad1));
		cli2.getAdresses().addAll(Arrays.asList(ad2));
		
		clientDAO.saveAll(Arrays.asList(cli2, cli1));
		addressDAO.saveAll(Arrays.asList(ad2, ad1));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Request re1 = new Request(null, sdf.parse("12/04/2021 19:39"), ad2, cli1);
		Request re2 = new Request(null, sdf.parse("28/03/2022 09:57"), ad1, cli1);
		
		Payment pay1 = new CardPayment(null, PaymentStatus.REQUESTED,re1 , 4);
		re1.setPayment(pay1);
		
		Payment pay2 = new SlipPayment(null, PaymentStatus.REQUESTED, re2, sdf.parse("05/04/2022 09:57"), sdf.parse("01/04/2022 09:57"));
		re2.setPayment(pay2);
				
		cli1.getRequests().addAll(Arrays.asList(re1, re2));
		
		requestDAO.saveAll(Arrays.asList(re1, re2));
		paymentDAO.saveAll(Arrays.asList(pay1, pay2));
		
	}

}
