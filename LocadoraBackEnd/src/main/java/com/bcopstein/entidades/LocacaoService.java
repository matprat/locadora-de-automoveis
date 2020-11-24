package com.bcopstein.entidades;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.interfaces.CarroCustoDTO;
import com.bcopstein.interfaces.DataLocal;


@Component
public class LocacaoService {
	
	private IRepositorioLocacoes locacoes;
	private IRepositorioCarros carros;
	private FactoryDesconto factoryDesconto;
	
	@Autowired
	public LocacaoService(IRepositorioLocacoes locacoes, IRepositorioCarros carros, FactoryDesconto factoryDesconto) {
		this.locacoes = locacoes;
		this.carros = carros;
		this.factoryDesconto = factoryDesconto;
	}
	
	public boolean cadastrar(CarroCustoDTO carroCustoDTO, Carro carro) {
		try {	
			double desconto = 0;
			double totalAPagar = 0;
			Locacao novaLocacao = new Locacao(carroCustoDTO.getInicioLocacao(),
					carroCustoDTO.getFimLocacao(),
					carro.getPlaca(),
					carro.getMarca(),
					carro.getModelo(),
					carro.isArcondicionado(),
					carro.isDirecao(),
					carro.isCambioautomatico(),
					carroCustoDTO.getCustoLocacao(),
					carroCustoDTO.getSeguro(),
					desconto,
					totalAPagar);
			this.factoryDesconto.getRegraDesconto().calcular(novaLocacao);
			this.locacoes.salvar(novaLocacao);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Collection<Locacao> todos() {
		return this.locacoes.todos();
	}
	
	private void aplicaDesconto() {
		
	}
	
	 private double custoLocacao;
	    private double seguro;
	    private double desconto;
	    private double totalPagar;
	
}
