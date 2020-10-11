package com.bcb.conversaomoeda.api.domain.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bcb.conversaomoeda.api.domain.model.Problema;

@Repository
public interface ProblemaRepository extends JpaRepository<Problema, Long>{
	
	@Query("select max(dataHoraCadastro) from Problema")
	LocalDateTime getDataUltimaAtualizacao();
	
}
