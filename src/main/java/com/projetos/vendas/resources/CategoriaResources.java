package com.projetos.vendas.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetos.vendas.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {
	
	@GetMapping
	public List<Categoria> listar() {
		
		List<Categoria> lista = new ArrayList<>();
		Categoria cat1 = new Categoria(1L, "Informatica");
		Categoria cat2 = new Categoria(2L, "Linha Marron");
		
		lista.add(cat1);
		lista.add(cat2);
		
		return lista;
	}

}
