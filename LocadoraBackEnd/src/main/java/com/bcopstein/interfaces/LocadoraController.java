package com.bcopstein.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bcopstein.casosDeUso.ControleDeCarros;
import com.bcopstein.casosDeUso.ControleDeLocacoes;
import com.bcopstein.entidades.Carro;
import com.bcopstein.entidades.Locacao;


@RestController
@RequestMapping("/locadora")
public class LocadoraController {
	
  private ControleDeLocacoes controleDeLocacoes;
  private ControleDeCarros controleDeCarros;

  @Autowired
  public LocadoraController(ControleDeLocacoes controleDeLocacoes, ControleDeCarros controleDeCarros) {
	  this.controleDeLocacoes = controleDeLocacoes;
	  this.controleDeCarros = controleDeCarros;
  }

  @GetMapping("/todasLocacoes")
  @CrossOrigin(origins = "*")
  public Collection<CarroCustoDTO> todasLocacoes() {
    return this.controleDeLocacoes.todasLocacoes();
  }

  @GetMapping("/carrosDisponiveis")
  @CrossOrigin(origins = "*")
  public List<CarroCustoDTO> carrosDisponiveis(FiltroDTO filtro) {
    // Está selecionando apenas pelos equipamentos
    // Não está verificando se o carro está livre naquelas datas
    List<Carro> disponiveis = this.controleDeCarros.todos().stream()
      .filter(c->c.isArcondicionado() == filtro.isArcondicionado())
      .filter(c->c.isDirecao() == filtro.isDirecao())
      .filter(c->c.isCambioautomatico() == filtro.isCambio())
      .collect(Collectors.toList());
    List<CarroCustoDTO> informacoes = new ArrayList<>(disponiveis.size());
    // Não está calculando o valor das diárias, seguro, desconto ou total
    disponiveis.forEach(c->{
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
    });
    return informacoes;
  }

  @PostMapping("/confirmaLocacao")
  @CrossOrigin(origins = "*")
  public boolean confirmaLocacao(@RequestBody final CarroCustoDTO carro) {
    return this.controleDeLocacoes.alugarCarro(carro);
  }

}
