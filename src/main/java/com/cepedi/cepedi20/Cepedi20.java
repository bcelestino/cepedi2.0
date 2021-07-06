package com.cepedi.cepedi20;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cepedi.cepedi20.domain.Cidade;
import com.cepedi.cepedi20.domain.Curso;
import com.cepedi.cepedi20.domain.Estado;
import com.cepedi.cepedi20.domain.Linguagem;
import com.cepedi.cepedi20.repositories.CidadeRepository;
import com.cepedi.cepedi20.repositories.CursoRepository;
import com.cepedi.cepedi20.repositories.EstadoRepository;
import com.cepedi.cepedi20.repositories.LinguagemRepository;

@SpringBootApplication
public class Cepedi20 implements CommandLineRunner {

	@Autowired
	private LinguagemRepository linguagemRepository;

	@Autowired
	private CursoRepository cursoRespository;

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;

	

	public static void main(String[] args) {
		SpringApplication.run(Cepedi20.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Linguagem l1 = new Linguagem(null, "C");
		Linguagem l2 = new Linguagem(null, "C++");
		Linguagem l3 = new Linguagem(null, "JAVA");
		Linguagem l4 = new Linguagem(null, "LUA");

		Curso c1 = new Curso(null, "Spring", 200.00);
		Curso c2 = new Curso(null, "jogos", 40.00);
		Curso c3 = new Curso(null, "programaçãobasica", 30.00);

		Estado est1 = new Estado(null, "Sao Paulo");
		Estado est2 = new Estado(null, "Bahia");
		Estado est3 = new Estado(null, "Minas Gerais");

		Cidade cd1 = new Cidade(null, "Sao Paulo",est1);
		Cidade cd2 = new Cidade(null, "Itabuna", est2);
		Cidade cd3 = new Cidade(null, "Ilheus", est2);
		Cidade cd4 = new Cidade(null, "Belo horizonte",est3);

		l1.getCurso().addAll(Arrays.asList(c3));
		l2.getCurso().addAll(Arrays.asList(c2, c3));
		l3.getCurso().addAll(Arrays.asList(c1, c2, c3));
		l4.getCurso().addAll(Arrays.asList(c2, c3));

		c1.getLinguagem().addAll(Arrays.asList(l3));
		c2.getLinguagem().addAll(Arrays.asList(l2, l3, l4));
		c3.getLinguagem().addAll(Arrays.asList(l1, l2, l3, l4));
		
		
		est1.getCidades().addAll(Arrays.asList(cd1));
		est2.getCidades().addAll(Arrays.asList(cd2,cd3));
		est3.getCidades().addAll(Arrays.asList(cd4));
		
		
		
		estadoRepository.saveAll(Arrays.asList(est1, est2, est3));
		cidadeRepository.saveAll(Arrays.asList(cd1, cd2, cd3, cd4));
		linguagemRepository.saveAll(Arrays.asList(l1, l2, l3, l4));
		cursoRespository.saveAll(Arrays.asList(c1, c2, c3));
	}

}
