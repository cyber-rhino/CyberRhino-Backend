package com.chyberrhino.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chyberrhino.dao.RequestDAO;
import com.chyberrhino.domain.Request;
import com.chyberrhino.services.exceptions.ObjectNotFoundException;

@Service
public class RequestService {
	
	@Autowired
	private RequestDAO repo;
	public Request find(Integer id) {
		Optional<Request> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found ID: " + id + ", Type: " + Request.class.getName()));
	}
	
}
