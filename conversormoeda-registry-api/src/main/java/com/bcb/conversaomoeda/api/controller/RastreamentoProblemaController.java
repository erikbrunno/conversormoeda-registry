package com.bcb.conversaomoeda.api.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcb.conversaomoeda.api.assembler.RastreamentoProblemaModelAssembler;
import com.bcb.conversaomoeda.api.domain.model.Problema;
import com.bcb.conversaomoeda.api.domain.service.CadastroProblemaService;
import com.bcb.conversaomoeda.api.model.RastreamentoProblemaModel;

@RestController
@RequestMapping("/problemas/{problemaId}/detalhar")
public class RastreamentoProblemaController {

	@Autowired
	private CadastroProblemaService cadastroProblema;

	@Autowired
	private RastreamentoProblemaModelAssembler rastreamentoProblemaModelAssembler;

	@GetMapping
	public ResponseEntity<RastreamentoProblemaModel> buscar(@PathVariable Long problemaId) {
		Problema problema = cadastroProblema.buscar(problemaId);
		RastreamentoProblemaModel rastreamentoProblemaModel = rastreamentoProblemaModelAssembler
				.toModel(problema.getRastreamento());

		return ResponseEntity.ok().cacheControl(CacheControl.maxAge(3, TimeUnit.SECONDS))
				.body(rastreamentoProblemaModel);
	}
}
