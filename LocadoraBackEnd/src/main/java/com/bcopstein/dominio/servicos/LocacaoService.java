package com.bcopstein.dominio.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bcopstein.dominio.dtos.CarroCustoDTO;
import com.bcopstein.dominio.dtos.CarroDTO;
import com.bcopstein.dominio.entidades.Locacao;
import com.bcopstein.dominio.interfaces.IRepositorioLocacoes;


public class LocacaoService {
	
private IRepositorioLocacoes repositorio;
	
	@Autowired
	public LocacaoService(IRepositorioLocacoes repositorio) {
		this.repositorio = repositorio;
	}
	
	// TO DO
	public boolean alugarCarro(CarroCustoDTO dadosLocacao) {
		return false;
	}
	
	// TO DO
	public boolean devolverCarro(CarroDTO dadosDoCarro) {
		return false;
	}
	
	public List<Locacao> listarTodasLocacoes() {
		return null;
	}

}
