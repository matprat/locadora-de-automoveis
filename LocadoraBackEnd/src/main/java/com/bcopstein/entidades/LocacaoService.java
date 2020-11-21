package com.bcopstein.entidades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bcopstein.interfaces.CarroCustoDTO;
import com.bcopstein.interfaces.CarroDTO;


public class LocacaoService {
	
private IRepositorioLocacoes repositorio;
	
	@Autowired
	public LocacaoService(IRepositorioLocacoes repositorio) {
		this.repositorio = repositorio;
	}
	
}
