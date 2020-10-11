package com.bcb.conversaomoeda.api.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProblemaModel {

	private Long id;
	private Integer codigoHttp;
	private String tipo;
	private String titulo;
	private String detalhe;
	private LocalDateTime dataHora;
}
