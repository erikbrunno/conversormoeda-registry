package com.bcb.conversaomoeda.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcb.conversaomoeda.amqp.message.ProblemaMessage;
import com.bcb.conversaomoeda.api.domain.model.Problema;

@Component
public class ProblemaMessageDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Problema toDomainObject(ProblemaMessage problemMessage) {
		return modelMapper.map(problemMessage, Problema.class);
	}

}
