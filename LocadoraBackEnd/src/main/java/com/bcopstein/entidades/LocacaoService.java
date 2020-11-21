package com.bcopstein.entidades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LocacaoService {
	
	private IRepositorioLocacoes locacoes;
	private IRepositorioCarros carros;
	
	@Autowired
	public LocacaoService(IRepositorioLocacoes locacoes, IRepositorioCarros carros) {
		this.locacoes = locacoes;
		this.carros = carros;
	}
	
}
