package com.chyberrhino.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chyberrhino.dao.ClientDAO;
import com.chyberrhino.domain.Client;
import com.chyberrhino.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientDAO repo;
	public Client find(Integer id) {
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found ID: " + id + ", Type: " + Client.class.getName()));
	}
	
}
