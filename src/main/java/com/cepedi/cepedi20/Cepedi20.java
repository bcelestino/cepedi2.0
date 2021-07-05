package com.cepedi.cepedi20;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cepedi.cepedi20.domain.Curso;
import com.cepedi.cepedi20.domain.Linguagem;
import com.cepedi.cepedi20.repositories.CursoRepository;
import com.cepedi.cepedi20.repositories.LinguagemRepository;

@SpringBootApplication
public class Cepedi20 implements CommandLineRunner {
	
	@Autowired
	private LinguagemRepository linguagemRepository;
	
	@Autowired
	private CursoRepository cursoRespository;

	public static void main(String[] args) {
		SpringApplication.run(Cepedi20.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Linguagem l1 = new Linguagem(null,"C");
		Linguagem l2 = new Linguagem(null,"C++");
		Linguagem l3 = new Linguagem(null,"JAVA");
		Linguagem l4 = new Linguagem(null,"LUA");
		
		Curso c1 = new Curso(null, "Spring", 200.00);
		Curso c2 = new Curso(null, "jogos", 40.00);
		Curso c3 = new Curso(null, "programaçãobasica", 30.00);
		
		l1.getCurso().addAll(Arrays.asList(c3));
		l2.getCurso().addAll(Arrays.asList(c2,c3));
		l3.getCurso().addAll(Arrays.asList(c1,c2,c3));
		l4.getCurso().addAll(Arrays.asList(c2,c3));
		
		c1.getLinguagem().addAll(Arrays.asList(l3));
		c2.getLinguagem().addAll(Arrays.asList(l2,l3,l4));
		c3.getLinguagem().addAll(Arrays.asList(l1,l2,l3,l4));
		
		
		linguagemRepository.saveAll(Arrays.asList(l1, l2, l3, l4));
		
		cursoRespository.saveAll(Arrays.asList(c1,c2,c3));
	}

}
