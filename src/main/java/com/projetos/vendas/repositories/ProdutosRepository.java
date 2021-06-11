package com.projetos.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetos.vendas.domain.Produto;

@Repository
public interface ProdutosRepository extends JpaRepository<Produto, Long> {

}
