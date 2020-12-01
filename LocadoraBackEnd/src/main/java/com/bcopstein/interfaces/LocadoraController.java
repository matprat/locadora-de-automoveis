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

  @GetMapping("/todas-locacoes")
  @CrossOrigin(origins = "*")
  public Collection<CarroCustoDTO> todasLocacoes() {
    return this.controleDeLocacoes.todasLocacoes();
  }

  @GetMapping("/locacoes-vigentes")
  @CrossOrigin(origins = "*")
  public Collection<CarroCustoDTO> locacoesVigentes() {
    return this.controleDeLocacoes.locacoesVigentes();
  }
  
  @GetMapping("/carros-disponiveis")
  @CrossOrigin(origins = "*")
  public List<CarroCustoDTO> carrosDisponiveis(FiltroDTO filtro) {
    return this.controleDeCarros.carrosDisponiveis(filtro);
  }
  
  @PostMapping("/devolve-carro")
  @CrossOrigin(origins = "*")
  public boolean devolveCarro(@RequestBody final CarroDTO carro) {
    return this.controleDeLocacoes.devolveCarro(carro.getPlaca());
  }

  @PostMapping("/confirma-locacao")
  @CrossOrigin(origins = "*")
  public boolean confirmaLocacao(@RequestBody CarroCustoDTO carro) {
    return this.controleDeLocacoes.alugarCarro(carro);
  }

}
