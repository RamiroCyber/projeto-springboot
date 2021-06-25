package com.projetos.vendas.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetos.vendas.domain.Categoria;
import com.projetos.vendas.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria findById(Long id) {
		Optional<Categoria> cate = categoriaRepository.findById(id);
		return cate.get();
	}

	public List<Categoria> findAll() {
		List<Categoria> lista = categoriaRepository.findAll();
		return lista;
	}

	public Categoria insert(Categoria obj) {
		return categoriaRepository.save(obj);
	}

	public Categoria upDate(Long id, Categoria cate) {
		Categoria categoria = categoriaRepository.getOne(id);
		categoria.setNome(cate.getNome());
		return categoriaRepository.save(categoria);
	}

	public void delete(Long id) {
		categoriaRepository.deleteById(id);
	}

}
