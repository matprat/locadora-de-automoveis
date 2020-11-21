package com.bcopstein.entidades;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TabelaCarrosH2BD extends CrudRepository<Carro, String>  {
	List<Carro> findAll();
	List<Carro> findByPlaca(String placa);
}
