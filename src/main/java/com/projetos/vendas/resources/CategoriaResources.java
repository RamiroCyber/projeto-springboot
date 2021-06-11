package com.projetos.vendas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetos.vendas.domain.Categoria;
import com.projetos.vendas.servicies.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> buscaPorId(@PathVariable Long id) {
		Categoria cate = service.buscarPorId(id);
	
		return ResponseEntity.ok().body(cate);
	}

	@GetMapping
	public ResponseEntity<List<Categoria>> buscarTodos(){
		List<Categoria> lista = service.buscarTodos();
		
		return ResponseEntity.ok().body(lista);
	}
}
