package com.projetos.vendas.servicies;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetos.vendas.domain.Pedido;
import com.projetos.vendas.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public Pedido buscarPorId(Long id) {
		Optional<Pedido> cate = pedidoRepository.findById(id);
		return cate.get();

	}

	public List<Pedido> buscarTodos() {
		List<Pedido> lista = pedidoRepository.findAll();
		return lista;
	}

}
