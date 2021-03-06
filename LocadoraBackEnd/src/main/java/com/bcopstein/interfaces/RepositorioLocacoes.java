package com.bcopstein.interfaces;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.entidades.IRepositorioLocacoes;
import com.bcopstein.entidades.Locacao;
import com.bcopstein.entidades.TabelaLocacoesH2BD;

@Component
public class RepositorioLocacoes implements IRepositorioLocacoes {
	
	private TabelaLocacoesH2BD database;
	
	@Autowired
	public RepositorioLocacoes(TabelaLocacoesH2BD bancoDeDados) {
		this.database = bancoDeDados;
	}

	@Override
	public Locacao recuperar(Long id) {
		return this.database.findById(id).get(0);
	}

	@Override
	public Collection<Locacao> todos() {
		return this.database.findAll();
	}

	@Override
	public void salvar(Locacao novaLocacao) {
		this.database.save(novaLocacao);		
	}

}
