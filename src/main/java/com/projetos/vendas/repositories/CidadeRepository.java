package com.projetos.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetos.vendas.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
