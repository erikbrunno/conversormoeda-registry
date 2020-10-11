package com.bcb.conversaomoeda.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcb.conversaomoeda.api.domain.model.RastreamentoProblema;
import com.bcb.conversaomoeda.api.model.RastreamentoProblemaModel;

@Component
public class RastreamentoProblemaModelAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public RastreamentoProblemaModel toModel(RastreamentoProblema rastreamentoProblema) {
		return modelMapper.map(rastreamentoProblema, RastreamentoProblemaModel.class);
	}
}
