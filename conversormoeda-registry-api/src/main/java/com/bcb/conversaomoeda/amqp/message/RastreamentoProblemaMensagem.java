package com.bcb.conversaomoeda.amqp.message;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RastreamentoProblemaMensagem {

	@JsonProperty("stacktrace")
	private String stacktrace;	
}
