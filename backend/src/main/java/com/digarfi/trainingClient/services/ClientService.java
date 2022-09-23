
package com.digarfi.trainingClient.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digarfi.trainingClient.dto.ClientDTO;
import com.digarfi.trainingClient.entities.Client;
import com.digarfi.trainingClient.repositories.ClientRepository;


@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	
	@Transactional(readOnly = true)
		public List<ClientDTO> findAll(){
			List<Client>list =  repository.findAll();
			List<ClientDTO> listDto = list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
			return listDto;
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.get();
		return new ClientDTO(entity);
	}
	
}
