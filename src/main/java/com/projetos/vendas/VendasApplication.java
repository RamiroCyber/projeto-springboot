package com.projetos.vendas;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projetos.vendas.domain.Categoria;
import com.projetos.vendas.domain.Cidade;
import com.projetos.vendas.domain.Estado;
import com.projetos.vendas.domain.Produto;
import com.projetos.vendas.repositories.CategoriaRepository;
import com.projetos.vendas.repositories.CidadeRepository;
import com.projetos.vendas.repositories.EstadoRepository;
import com.projetos.vendas.repositories.ProdutosRepository;

@SpringBootApplication
public class VendasApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepositorio;
	
	@Autowired
	private ProdutosRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto prod1 = new Produto("Computador", 2000.00);
		Produto prod2 = new Produto("Impressora", 800.00);
		Produto prod3 = new Produto("Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(prod1,prod2,prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod2));
		
		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		prod3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepositorio.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(prod1,prod2,prod3));
		
		Estado estado1 = new Estado("Minas Gerais");
		Estado estado2 = new Estado("São Paulo");
		
		Cidade c1 = new Cidade("Uberlandia", estado1);
		Cidade c2 = new Cidade("São paulo", estado2);
		Cidade c3 = new Cidade("Campinas", estado2);
		
		estado1.getCidades().addAll(Arrays.asList(c1));
		estado2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(estado1,estado2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
	}

}
