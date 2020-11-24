package com.bcopstein.entidades;

public class DescontoNormal {
	
	private RegraSeguro regraSeguro = new SeguroOuro();
	
	public void calcular(Locacao locacao) {
		locacao.setDesconto(locacao.getSeguro());
		locacao.setTotalPagar(locacao.getCustoLocacao() - locacao.getDesconto());
	}
	
	public RegraSeguro getRegra() {
		return this.regraSeguro;
	}

}
