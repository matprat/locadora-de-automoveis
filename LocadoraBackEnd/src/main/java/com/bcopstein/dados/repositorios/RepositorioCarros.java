package com.bcopstein.dados.repositorios;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.dados.armazenamentoPersistente.carros.TabelaCarrosH2BD;
import com.bcopstein.dominio.entidades.Carro;
import com.bcopstein.dominio.interfaces.IRepositorioCarros;

@Component
public class RepositorioCarros implements IRepositorioCarros {
	
	private TabelaCarrosH2BD database;
	
	@Autowired
	public RepositorioCarros(TabelaCarrosH2BD bancoDeDados) {
		this.database = bancoDeDados;
	}

	@Override
	public Carro recuperar(String placa) {
		return this.database.findByPlaca(placa).get(0);
	}

	@Override
	public Collection<Carro> todos() {
		return this.database.findAll();
	}

	@Override
	public void salvar(Carro novoCarro) {
		this.database.save(novoCarro);
	}

	@Override
	public Carro pesquisarPorPlaca(String placa) {
		return this.recuperar(placa);
	}


}
