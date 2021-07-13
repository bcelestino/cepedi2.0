package com.cepedi.cepedi20.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cepedi.cepedi20.domain.Endereço;

@Repository
public interface EndereçoRepository extends JpaRepository<Endereço, Integer> {

}
