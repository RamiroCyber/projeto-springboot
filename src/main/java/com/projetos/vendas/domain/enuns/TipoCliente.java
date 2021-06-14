package com.projetos.vendas.domain.enuns;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Física"), 
	PESSOAJURIDICA(2, "Pessoa Jurídica");

	private Integer numero;
	private String descricao;

	private TipoCliente(int numero, String descricao) {
		this.numero = numero;
		this.descricao = descricao;
	}

	public int getNumero() {
		return numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoCliente retornoCliente(Integer numero) {
		for (TipoCliente x : TipoCliente.values()) {
			if (numero.equals(x.getNumero())) {
				return x;
			}
		}
		throw new NullPointerException("Id não encontrado");
	}
}
