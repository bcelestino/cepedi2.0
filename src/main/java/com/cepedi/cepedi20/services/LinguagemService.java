package com.cepedi.cepedi20.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cepedi.cepedi20.repositories.LinguagemRepository;
import com.cepedi.cepedi20.domain.Linguagem;

@Service
public class LinguagemService {

	@Autowired
	private LinguagemRepository repo;

	public Linguagem find(Integer id) {
		Optional<Linguagem> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
