package com.projetos.vendas.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projetos.vendas.domain.Categoria;
import com.projetos.vendas.servicies.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id) {
		Categoria cate = categoriaService.findById(id);
		return ResponseEntity.ok().body(cate);
	}

	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria> lista = categoriaService.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@PostMapping
	public ResponseEntity<Categoria> insert(@RequestBody Categoria obj) {
		obj = categoriaService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> upData(@PathVariable Long id, @RequestBody Categoria cate) {
		cate = categoriaService.upDate(id, cate);
		return ResponseEntity.noContent().build();

	}
}
