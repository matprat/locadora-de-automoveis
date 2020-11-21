package com.bcopstein.interfaces;

import java.util.ArrayList;
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

import com.bcopstein.entidades.Carro;
import com.bcopstein.entidades.IRepositorioCarros;

@RestController
@RequestMapping("/locadora")
public class LocadoraController {
  private IRepositorioCarros carros;

  @Autowired
  public LocadoraController(IRepositorioCarros carros) {
	  this.carros = carros;
  }

  @GetMapping("/teste")
  @CrossOrigin(origins = "*")
  public String teste() {
    return "Testado com sucesso!!";
  }

  @GetMapping("/carrosDisponiveis")
  @CrossOrigin(origins = "*")
  public List<CarroCustoDTO> carrosDisponiveis(FiltroDTO filtro) {
    System.out.println(filtro);
    // Está selecionando apenas pelos equipamentos
    // Não está verificando se o carro está livre naquelas datas
    List<Carro> disponiveis = carros.todos().stream()
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
    // Está confirmando qualquer coisa
    return true;
  }

}
