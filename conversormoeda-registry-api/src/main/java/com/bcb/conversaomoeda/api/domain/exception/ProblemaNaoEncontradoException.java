package com.bcb.conversaomoeda.api.domain.exception;

public class ProblemaNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	private static final String MSG_PROBLEMA_NAO_ENCONTRADO = "Não existe um cadastro de problema com o código %d";;
	
	public ProblemaNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public ProblemaNaoEncontradoException(Long problemaId) {
		this(String.format(MSG_PROBLEMA_NAO_ENCONTRADO, problemaId));
	}
}
