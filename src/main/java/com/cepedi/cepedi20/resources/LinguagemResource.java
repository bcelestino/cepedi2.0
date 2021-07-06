package com.cepedi.cepedi20.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cepedi.cepedi20.domain.Linguagem;
import com.cepedi.cepedi20.services.LinguagemService;

@RestController
@RequestMapping(value = "/linguagens")
public class LinguagemResource {
	
	@Autowired
	private LinguagemService service;

	@RequestMapping(value ="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Linguagem obj = service.find(id);
		return ResponseEntity.ok().body(obj);
				

	}

}
