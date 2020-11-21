package com.bcopstein.entidades;

import java.util.List;

public interface IRepositorioCarros extends IRepositorio<Carro, String> {
	Carro pesquisarPorPlaca(String placa);  
}