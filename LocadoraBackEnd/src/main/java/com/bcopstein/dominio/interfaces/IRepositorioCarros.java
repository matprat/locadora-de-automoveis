package com.bcopstein.dominio.interfaces;

import java.util.List;

import com.bcopstein.dominio.entidades.Carro;

public interface IRepositorioCarros extends IRepositorio<Carro, String> {
	Carro pesquisarPorPlaca(String placa);  
}