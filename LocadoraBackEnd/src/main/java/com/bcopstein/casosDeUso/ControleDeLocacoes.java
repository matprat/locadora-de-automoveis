package com.bcopstein.casosDeUso;

import java.util.Collection;
import java.util.Date;

import com.bcopstein.entidades.Carro;
import com.bcopstein.entidades.CarroService;
import com.bcopstein.entidades.Locacao;
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
	
	public Collection<Locacao> teste() {
		return this.servicoDeLocacao.todos();
	}
	
	public Collection<CarroCustoDTO> pesquisarCarrosDisponiveis(FiltroDTO filtro) {
		// TO DO
		return null;
	}
	
	public boolean alugarCarro(CarroCustoDTO carroCustoDTO) {
		try {
			Date inicioLocacao = carroCustoDTO.getInicioLocacao().toDate();
			Date fimLocacao = carroCustoDTO.getFimLocacao().toDate();
			
			if(periodoDeLocacaoIsValido(inicioLocacao, fimLocacao)) {
				Carro carro = this.servicoDeCarro.buscaCarroPorPlaca(carroCustoDTO.getPlaca());
				if(carroNaoLocalizadoOuIndisponivel(carro)) {
					return false;
				}
				boolean locacaoCriada = criaUmaLocacaoNoRepositorio(carroCustoDTO, carro);
				if(locacaoCriada) {
					buscaCarroPorPlacaEAlteraStatusParaIndisponivel(carro);
				}
				return locacaoCriada;
			}
			
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
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
	
	private boolean periodoDeLocacaoIsValido(Date dataInicial, Date dataFinal) {
		return dataInicial.compareTo(dataFinal) <= 0;
	}
	
	private boolean carroNaoLocalizadoOuIndisponivel(Carro carro) {
		return carro == null || !carro.getDisponivel();
	}
	
	private void buscaCarroPorPlacaEAlteraStatusParaIndisponivel(Carro carro) {
		Carro carroLocalizado = this.servicoDeCarro.buscaCarroPorPlaca(carro.getPlaca());
		carroLocalizado.setDisponivel(false);
		this.servicoDeCarro.atualiza(carro);
	}
	
	private boolean criaUmaLocacaoNoRepositorio(CarroCustoDTO carroCustoDTO, Carro carro) {
		return this.servicoDeLocacao.cadastrar(carroCustoDTO, carro);
	}

}
