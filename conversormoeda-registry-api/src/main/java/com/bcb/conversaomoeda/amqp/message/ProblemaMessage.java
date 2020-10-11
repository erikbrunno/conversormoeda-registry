package com.bcb.conversaomoeda.amqp.message;

import java.time.LocalDateTime;

import com.bcb.conversaomoeda.api.jackson.converter.ParseDeserializerToLocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProblemaMessage {

	@JsonProperty("codigo_http")
	private Integer codigoHttp;
	
	@JsonProperty("tipo")
	private String tipo;
	
	@JsonProperty("titulo")
	private String titulo;
	
	@JsonProperty("detalhe")
	private String detalhe;
	
	@JsonProperty("stacktrace")
	private String stacktrace;
	
	@JsonProperty("timestamp")
	private String timestamp;
		
}
