package com.bcb.conversaomoeda.api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcb.conversaomoeda.api.domain.exception.ProblemaNaoEncontradoException;
import com.bcb.conversaomoeda.api.domain.model.Problema;
import com.bcb.conversaomoeda.api.domain.model.RastreamentoProblema;
import com.bcb.conversaomoeda.api.domain.repository.ProblemaRepository;
import com.bcb.conversaomoeda.api.domain.repository.RastreamentoProblemaRepository;

@Service
public class CadastroProblemaService {

	@Autowired
	private ProblemaRepository problemaRepository;
		
	@Autowired
	private RastreamentoProblemaRepository rastreamentoProblemaRepository;
	
	@Transactional
	public Problema salvar(Problema problema) {
		
		RastreamentoProblema rastreamentoProblema = problema.getRastreamento();
		rastreamentoProblemaRepository.save(rastreamentoProblema);

		problema = problemaRepository.save(problema);
		
		return problema;
	}
	
	public Problema buscar(Long problemaId) {
		return problemaRepository.findById(problemaId)
				.orElseThrow(() -> new ProblemaNaoEncontradoException(problemaId));
	}
	
}
