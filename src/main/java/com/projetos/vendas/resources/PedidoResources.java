package com.projetos.vendas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetos.vendas.domain.Pedido;
import com.projetos.vendas.servicies.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResources {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> buscaPorId(@PathVariable Long id) {
		Pedido cate = pedidoService.buscarPorId(id);

		return ResponseEntity.ok().body(cate);
	}

	@GetMapping
	public ResponseEntity<List<Pedido>> buscarTodos() {
		List<Pedido> lista = pedidoService.buscarTodos();

		return ResponseEntity.ok().body(lista);
	}
}
