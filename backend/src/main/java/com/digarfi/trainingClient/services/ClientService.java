
package com.digarfi.trainingClient.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digarfi.trainingClient.entities.Client;
import com.digarfi.trainingClient.repositories.ClientRepository;


@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	
	@Transactional(readOnly = true)
		public List<Client> findAll(){
			return repository.findAll();
	}
	
}
