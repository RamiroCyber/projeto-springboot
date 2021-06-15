package com.projetos.vendas;


import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projetos.vendas.domain.Categoria;
import com.projetos.vendas.domain.Cidade;
import com.projetos.vendas.domain.Cliente;
import com.projetos.vendas.domain.Endereco;
import com.projetos.vendas.domain.Estado;
import com.projetos.vendas.domain.Pagamento;
import com.projetos.vendas.domain.PagamentoBoleto;
import com.projetos.vendas.domain.PagamentoCartao;
import com.projetos.vendas.domain.Pedido;
import com.projetos.vendas.domain.Produto;
import com.projetos.vendas.domain.enuns.EstadoPagamento;
import com.projetos.vendas.domain.enuns.TipoCliente;
import com.projetos.vendas.repositories.CategoriaRepository;
import com.projetos.vendas.repositories.CidadeRepository;
import com.projetos.vendas.repositories.ClienteRepository;
import com.projetos.vendas.repositories.EnderecoRepository;
import com.projetos.vendas.repositories.EstadoRepository;
import com.projetos.vendas.repositories.PagamentoRepository;
import com.projetos.vendas.repositories.PedidoRepository;
import com.projetos.vendas.repositories.ProdutosRepository;

@SpringBootApplication
public class VendasApplication implements CommandLineRunner {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienterepository;
	
	@Autowired
	private CategoriaRepository categoriaRepositorio;
	
	@Autowired
	private ProdutosRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
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
		
		Cliente cliente1 = new Cliente("Josi", "josie@gmail.com", "01545115141", TipoCliente.PESSOAFISICA);
		Cliente cliente2 = new Cliente("rubens", "rubens@gmail.com", "02151515484", TipoCliente.PESSOAJURIDICA);
		
		cliente2.getTelefone().addAll(Arrays.asList("32515144","85484841"));
		
		cliente1.getTelefone().addAll(Arrays.asList("32181811","854848284"));
		
		Endereco end1 = new Endereco("Rua josesin viana", "1080", "casa", "juaozin", "21515415", cliente1, c1);
		
		Endereco end2 = new Endereco("Rua chiquin da silva", "100", "casa", "perpetua", "60515151", cliente2, c3);
		
		cliente1.getEnderecos().addAll(Arrays.asList(end1));
		cliente1.getEnderecos().addAll(Arrays.asList(end2));
		
		clienterepository.saveAll(Arrays.asList(cliente1,cliente2));
		
		enderecoRepository.saveAll(Arrays.asList(end1,end2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido pedido1 = new Pedido(sdf.parse("25/09/2020 20:55"), end1, cliente1);
		
		Pedido pedido2 = new Pedido(sdf.parse("28/10/2020 00:00"), end2, cliente2);
		
		Pagamento pagamento1 = new PagamentoCartao(EstadoPagamento.PAGO, pedido1, 4);
		pedido1.setPagamento(pagamento1);
		
		Pagamento pagamento2 = new  PagamentoBoleto(EstadoPagamento.PENDENTE, pedido2, sdf.parse("05/05/2020 00:00"), sdf.parse("10/11/2020 00:00"));
		pedido2.setPagamento(pagamento2);
		
		cliente1.getPedidos().addAll(Arrays.asList(pedido1));
		cliente2.getPedidos().addAll(Arrays.asList(pedido2));
		
		pedidoRepository.saveAll(Arrays.asList(pedido1,pedido2));
		pagamentoRepository.saveAll(Arrays.asList(pagamento1,pagamento2));
	}

}
