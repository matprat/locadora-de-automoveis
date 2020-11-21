package com.bcopstein.casosDeUso;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.entidades.Carro;
import com.bcopstein.entidades.CarroService;

@Component
public class ControleDeCarros {
	
	private CarroService servicoDeCarro;
	
	@Autowired
	public ControleDeCarros(CarroService servicoCarro) {
		this.servicoDeCarro = servicoCarro;
	}
	
	public Collection<Carro> todos() {
		return this.servicoDeCarro.todos();
	}

}
