package com.bcb.conversaomoeda.amqp.message;

import static com.bcb.conversaomoeda.api.util.DataUtil.converterStringToLocalDateTime;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcb.conversaomoeda.amqp.config.ProblemAMQPConfig;
import com.bcb.conversaomoeda.api.assembler.ProblemaMessageDisassembler;
import com.bcb.conversaomoeda.api.domain.model.Problema;
import com.bcb.conversaomoeda.api.domain.model.RastreamentoProblema;
import com.bcb.conversaomoeda.api.domain.service.CadastroProblemaService;

@Service
public class ProblemaMessageListener {

	private static final Logger log = LoggerFactory.getLogger(ProblemaMessageListener.class);

	@Autowired
	private CadastroProblemaService cadastroProblema;

	@Autowired
	private ProblemaMessageDisassembler problemaMessageDisassembler;

	@RabbitListener(queues = ProblemAMQPConfig.DEFAULT_QUEUE)
	public void consumeDefaultMessage(final ProblemaMessage problemMessage) {
		log.info("Mensagem recebida: {} ", problemMessage.getDetalhe());

		Problema problema = problemaMessageDisassembler.toDomainObject(problemMessage);
		RastreamentoProblema rastreamento = new RastreamentoProblema();
		rastreamento.setStacktrace(problemMessage.getStacktrace());
		problema.setRastreamento(rastreamento);

		LocalDateTime dataHoraProblema = converterStringToLocalDateTime(problemMessage.getTimestamp().substring(0, 19));
		problema.setDataHora(dataHoraProblema);

		cadastroProblema.salvar(problema);

		log.info("Problema registrado com sucesso");
	}
}