package com.digarfi.trainingClient.resources;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digarfi.trainingClient.entities.Client;



@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	
	
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
	
		
		List<Client> list = new ArrayList<>();
		list.add(new Client(1L, "Maria de Oliveira", "76534598721", 4000.00,Instant.parse("1998-06-20T19:53:07Z"),2));
		list.add(new Client(1L, "Antonio dos Santos", "76539374665", 3500.00,Instant.parse("1992-09-20T10:25:10Z"),3));
		return ResponseEntity.ok(list);
	}

}
