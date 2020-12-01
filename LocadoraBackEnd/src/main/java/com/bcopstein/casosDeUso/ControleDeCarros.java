package com.bcopstein.casosDeUso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.entidades.Carro;
import com.bcopstein.entidades.CarroService;
import com.bcopstein.interfaces.CarroCustoDTO;
import com.bcopstein.interfaces.FiltroDTO;

@Component
public class ControleDeCarros {
	
	private CarroService servicoDeCarro;
	
	@Autowired
	public ControleDeCarros(CarroService servicoCarro) {
		this.servicoDeCarro = servicoCarro;
	}
	
	 public List<CarroCustoDTO> carrosDisponiveis(FiltroDTO filtro) {
		   List<Carro> disponiveis = this.todos().stream()
		      .filter(c->c.isArcondicionado() == filtro.isArcondicionado())
		      .filter(c->c.isDirecao() == filtro.isDirecao())
		      .filter(c->c.isCambioautomatico() == filtro.isCambio())
		      .collect(Collectors.toList());
		    List<CarroCustoDTO> informacoes = new ArrayList<>(disponiveis.size());
		    // Não está calculando o valor das diárias, seguro, desconto ou total
		    disponiveis.forEach(c->{
		    if(c.getDisponivel()) {
		    	
		      informacoes.add(new CarroCustoDTO(filtro.getInicioLocacao(),
		                                        filtro.getFimLocacao(),
		                                        c.getPlaca(),
		                                        c.getMarca(),
		                                        c.getModelo(),
		                                        c.isArcondicionado(),
		                                        c.isDirecao(),
		                                        c.isCambioautomatico(),
		                                        1000.0, // Total das diárias
		                                        100.0,  // Custo do seguro
		                                        200.0,  // Total do desconto
		                                        900.0)); // Valor a pagar
	   }
	   });
	    return informacoes;
	 }
	
	public Collection<Carro> todos() {
		return this.servicoDeCarro.todos();
	}

}
