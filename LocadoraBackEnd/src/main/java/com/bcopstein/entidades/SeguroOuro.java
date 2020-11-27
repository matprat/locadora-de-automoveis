package com.bcopstein.entidades;

public class SeguroOuro implements RegraSeguro {
	
	@Override
	public void valida(Locacao locacao) {
		locacao.setSeguro(100);
	}

}
