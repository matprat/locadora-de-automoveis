package com.bcopstein.dominio.entidades;

import com.bcopstein.dominio.interfaces.RegraSeguro;

public class SeguroPrata implements RegraSeguro {

	private String nome;
	private double valor;

	@Override
	public double calcular(double subtotal) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getNome() {
		return this.nome;
	}

	public double getValor() {
		return this.valor;
	}

}
