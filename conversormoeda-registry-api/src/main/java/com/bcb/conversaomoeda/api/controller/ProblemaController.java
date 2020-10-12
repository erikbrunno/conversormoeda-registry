package com.bcb.conversaomoeda.api.controller;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import com.bcb.conversaomoeda.api.assembler.ProblemaModelAssembler;
import com.bcb.conversaomoeda.api.domain.model.Problema;
import com.bcb.conversaomoeda.api.domain.repository.ProblemaRepository;
import com.bcb.conversaomoeda.api.model.ProblemaModel;

@RestController
@RequestMapping("/problemas")
public class ProblemaController {
	
	@Autowired
	private ProblemaRepository problemaRepository;
	
	@Autowired
	private ProblemaModelAssembler problemaModelAssembler;
	
	@GetMapping
	public ResponseEntity<List<ProblemaModel>> listar(ServletWebRequest request) {
		ShallowEtagHeaderFilter.disableContentCaching(request.getRequest());
		
		String eTag = "0";
		
		LocalDateTime dataHoraAtualizacao = problemaRepository.getDataUltimaAtualizacao();
		
		if (dataHoraAtualizacao != null) {
			
			//Gerando a eTag
			long dataEmMilli = dataHoraAtualizacao.toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli();
			eTag = String.valueOf(dataEmMilli);
		}
		
		/*
		 * Se eTag passada no If-None-Match for igual a eTag gerada, é porque nao houve mudança na lista de problemas,
		 * Nesse caso retormados vazio para interromper o processamento que consulta todos os problemas
		 */
		if (request.checkNotModified(eTag)) {
			return null;
		}
		
		List<Problema> todosProblemas = problemaRepository.findAll();
		List<ProblemaModel> problemasModel = problemaModelAssembler.toCollectionModel(todosProblemas);

		return ResponseEntity.ok()
				.cacheControl(CacheControl.maxAge(30, TimeUnit.MINUTES))
				.eTag(eTag)
				.body(problemasModel);
	}
}
