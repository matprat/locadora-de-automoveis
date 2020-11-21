package com.bcopstein.entidades;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TabelaLocacoesH2BD extends CrudRepository<Locacao, String>  {
	List<Locacao> findAll();
	List<Locacao> findById(Long placa);
}
