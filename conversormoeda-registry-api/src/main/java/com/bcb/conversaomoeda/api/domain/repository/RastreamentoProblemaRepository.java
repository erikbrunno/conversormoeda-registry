package com.bcb.conversaomoeda.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcb.conversaomoeda.api.domain.model.RastreamentoProblema;

@Repository
public interface RastreamentoProblemaRepository extends JpaRepository<RastreamentoProblema, Long>{
	
}
