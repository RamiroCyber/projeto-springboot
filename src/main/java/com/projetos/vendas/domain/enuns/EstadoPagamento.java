package com.projetos.vendas.domain.enuns;

public enum EstadoPagamento {
	PENDENTE(1, "Pagamento Pendente"), 
	PAGO(2, "Pagamento Efetuado"), 
	CANCELADO(3, "Pagamento Cancelado");

	private Integer numero;
	private String descricao;

	private EstadoPagamento(int numero, String descricao) {
		this.numero = numero;
		this.descricao = descricao;
	}

	public int getNumero() {
		return numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EstadoPagamento retornoCliente(Integer numero) {
		for (EstadoPagamento x : EstadoPagamento.values()) {
			if (numero.equals(x.getNumero())) {
				return x;
			}
		}
		return null;
	}
}
