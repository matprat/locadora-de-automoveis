package com.bcopstein.entidades;

import org.springframework.stereotype.Component;

@Component
public class FactoryDesconto {
	
	// TO DO
	public DescontoNormal getRegraDesconto() {
		return new DescontoNormal();
	}

}
