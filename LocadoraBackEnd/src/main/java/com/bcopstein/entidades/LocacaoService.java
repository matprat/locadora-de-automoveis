package com.bcopstein.entidades;

import java.util.ArrayList;
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
			this.aplicaDesconto(novaLocacao);
			this.locacoes.salvar(novaLocacao);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<CarroCustoDTO> todos() {
		Collection<Locacao> locacoesCadastradas = this.locacoes.todos();
		List<CarroCustoDTO> todasLocacoes = new ArrayList<>(locacoesCadastradas.size());
		for(Locacao locacao: locacoesCadastradas) {
			todasLocacoes.add(locacao.toCarroCustoDTO());
		}
		return todasLocacoes;
	}
	
	private void aplicaDesconto(Locacao novaLocacao) {
		this.factoryDesconto.getRegraDesconto().calcular(novaLocacao);
	}
	
}
