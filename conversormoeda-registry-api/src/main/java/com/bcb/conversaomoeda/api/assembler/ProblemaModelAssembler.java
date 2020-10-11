package com.bcb.conversaomoeda.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcb.conversaomoeda.api.domain.model.Problema;
import com.bcb.conversaomoeda.api.model.ProblemaModel;

@Component
public class ProblemaModelAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public ProblemaModel toModel(Problema problema) {
		return modelMapper.map(problema, ProblemaModel.class);
	}

	public List<ProblemaModel> toCollectionModel(List<Problema> problemas) {
		return problemas.stream().map(problema -> toModel(problema)).collect(Collectors.toList());
	}

}
