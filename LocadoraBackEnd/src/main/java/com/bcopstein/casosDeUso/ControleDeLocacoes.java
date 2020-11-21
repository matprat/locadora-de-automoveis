package com.bcopstein.casosDeUso;

import java.util.Collection;

import com.bcopstein.entidades.CarroService;
import com.bcopstein.entidades.LocacaoService;
import com.bcopstein.interfaces.CarroCustoDTO;
import com.bcopstein.interfaces.FiltroDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ControleDeLocacoes {
	
	private LocacaoService servicoDeLocacao;
	private CarroService servicoDeCarro;
	
	
	@Autowired
	public ControleDeLocacoes(LocacaoService servicoLocacao, CarroService servicoCarro) {
		this.servicoDeLocacao = servicoLocacao;
		this.servicoDeCarro = servicoCarro;
	}
	
	public String teste() {
		return "Testado com sucesso!!";
	}
	
	public Collection<CarroCustoDTO> pesquisarCarrosDisponiveis(FiltroDTO filtro) {
		// TO DO
		return null;
	}
	
	public boolean alugarCarro(CarroCustoDTO carro) {
		// TO DO
		return false;
	}
	
	public boolean devolverCarro() {
		// TO DO
		return false;
	}
	
	public Collection<CarroCustoDTO> pesquisarTodasLocacoes() {
		// TO DO
		return null;
	}

}
