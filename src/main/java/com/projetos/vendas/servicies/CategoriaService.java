package com.projetos.vendas.servicies;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetos.vendas.domain.Categoria;
import com.projetos.vendas.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository reposi;
	
	public Categoria buscarPorId(Long id) {
		Optional<Categoria> cate = reposi.findById(id);
		return cate.orElse(null); 
	}

}
