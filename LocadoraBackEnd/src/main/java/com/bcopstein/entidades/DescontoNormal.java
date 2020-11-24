package com.bcopstein.entidades;

public class DescontoNormal {
	
	private double percentual = 0.05;
	
	public void calcular(Locacao locacao) {
		locacao.setDesconto(locacao.getSeguro());
		locacao.setTotalPagar(locacao.getCustoLocacao() - locacao.getDesconto());
	}
	
	public double getPercentual() {
		return this.percentual;
	}

}
