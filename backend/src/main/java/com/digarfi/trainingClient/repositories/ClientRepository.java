package com.digarfi.trainingClient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digarfi.trainingClient.entities.Client;



@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

		
	}


