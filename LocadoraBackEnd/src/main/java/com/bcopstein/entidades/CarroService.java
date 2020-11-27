package com.bcopstein.entidades;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CarroService {
	
	private IRepositorioCarros repositorio;
	
	@Autowired
	public CarroService(IRepositorioCarros repositorio) {
		this.repositorio = repositorio;
	}
	
	public Collection<Carro> todos() {
		return this.repositorio.todos();
	}
	
	public Carro buscaCarroPorPlaca(String placa) {
		return this.repositorio.pesquisarPorPlaca(placa);
	}

	public void atualiza(Carro carro) {
		this.repositorio.salvar(carro);
	}
	
}
