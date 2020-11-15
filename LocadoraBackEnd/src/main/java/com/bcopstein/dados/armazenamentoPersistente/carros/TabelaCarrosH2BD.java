package com.bcopstein.dados.armazenamentoPersistente.carros;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bcopstein.dominio.entidades.Carro;

public interface TabelaCarrosH2BD extends CrudRepository<Carro, String>  {
	List<Carro> findAll();
	List<Carro> findByPlaca(String placa);
}
