package com.bcopstein.entidades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bcopstein.interfaces.CarroDTO;
import com.bcopstein.interfaces.FiltroDTO;


public class CarroService {
	
	private IRepositorioCarros repositorio;
	
	@Autowired
	public CarroService(IRepositorioCarros repositorio) {
		this.repositorio = repositorio;
	}
	
}
