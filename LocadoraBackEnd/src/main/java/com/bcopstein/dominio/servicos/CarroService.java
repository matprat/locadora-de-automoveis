package com.bcopstein.dominio.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bcopstein.dominio.dtos.CarroDTO;
import com.bcopstein.dominio.dtos.FiltroDTO;
import com.bcopstein.dominio.entidades.Carro;
import com.bcopstein.dominio.interfaces.IRepositorioCarros;

public class CarroService {
	
	private IRepositorioCarros repositorio;
	
	@Autowired
	public CarroService(IRepositorioCarros repositorio) {
		this.repositorio = repositorio;
	}
	
	// TO DO
	public List<Carro> pesquisarCarrosDisponiveis(FiltroDTO filtro) {
		return null;
	}
	
	// TO DO
	public boolean devolverCarro(CarroDTO carro) {
		return false;
	}

}
