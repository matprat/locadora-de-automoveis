package com.bcopstein.casosDeUso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

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
	private Carros carros;
	
	
	@Autowired
	public ControleDeLocacoes(LocacaoService servicoLocacao, CarroService servicoCarro, Carros carros) {
		this.servicoDeLocacao = servicoLocacao;
		this.servicoDeCarro = servicoCarro;
	}

	public Collection<Carro> listaCarros() {
        return carros.todos();
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
	
    public boolean devolveCarro(String placa){
        for(Carro it: listaCarros()){ //passa na lista de carros
            if(it.getPlaca().toUpperCase().equals(placa.toUpperCase()) && it.getStatusCarro() == false){ //verifica se existe algum carro com a placa igual e se esta ocupado
                for(Aluguel alu: listaAlugueis()){//passa na lista de alugueis
                    if(alu.getCarroAlugado().getPlaca().toUpperCase().equals(placa.toUpperCase()) && alu.isCarroDevolvido() == false){//procura em algueis por uma placa igual e verifica se o carro ja foi devolvido para aquele aluguel
                        srvCarros.setCarroLivre(getCarro(placa).getPlaca());//coloca o carro como livre
                        alu.carroDevolvido(true);//coloca no aluguel que o carro foi devolvido
                        return true;                        
                    }
                }
            }
        }
        return false;        
    }
	
	public List<CarroCustoDTO> todasLocacoes() {
		return this.servicoDeLocacao.todos();
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
