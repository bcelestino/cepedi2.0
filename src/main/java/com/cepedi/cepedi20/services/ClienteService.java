package com.cepedi.cepedi20.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cepedi.cepedi20.repositories.ClienteRepository;
import com.cepedi.cepedi20.services.exceptions.ObjectNotFoundException;
import com.cepedi.cepedi20.domain.Cliente;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		}

}
