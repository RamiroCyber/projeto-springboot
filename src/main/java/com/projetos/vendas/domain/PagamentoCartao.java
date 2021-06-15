package com.projetos.vendas.domain;

import javax.persistence.Entity;

import com.projetos.vendas.domain.enuns.EstadoPagamento;

@Entity
public class PagamentoCartao extends Pagamento {
	private static final long serialVersionUID = 1L;

	private Integer numeroDasParcelas;

	public PagamentoCartao() {
	}

	public PagamentoCartao(EstadoPagamento estado, Pedido pedido, Integer numeroDasParcelas) {
		super(estado, pedido);
		this.numeroDasParcelas = numeroDasParcelas;
	}

	public Integer getNumeroDasParcelas() {
		return numeroDasParcelas;
	}

	public void setNumeroDasParcelas(Integer numeroDasParcelas) {
		this.numeroDasParcelas = numeroDasParcelas;
	}

}
