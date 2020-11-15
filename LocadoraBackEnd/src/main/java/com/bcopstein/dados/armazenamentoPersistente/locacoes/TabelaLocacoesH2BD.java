package com.bcopstein.dados.armazenamentoPersistente.locacoes;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bcopstein.dominio.entidades.Locacao;

public interface TabelaLocacoesH2BD extends CrudRepository<Locacao, String>  {
	List<Locacao> findAll();
	List<Locacao> findById(Long placa);
}
