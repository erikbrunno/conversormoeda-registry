package com.bcb.conversaomoeda.api.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Problema {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, name="codigo_http")
	private Integer codigoHttp;
	
	@Column(nullable = false)
	private String tipo;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(nullable = false)
	private String detalhe;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private RastreamentoProblema rastreamento;
	
	@Column(nullable = false, name="data_hora", columnDefinition = "datetime")
	private LocalDateTime dataHora;
	
	@CreationTimestamp
	@Column(nullable = false, columnDefinition = "datetime", name="data_hora_cadastro")
	private LocalDateTime dataHoraCadastro;
}
