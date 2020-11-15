package com.bcopstein.dominio.interfaces;

import java.util.Collection;
import java.util.List;

public interface IRepositorio<E, K> {
	public E recuperar(K chave);
	public Collection<E> todos();
	public void salvar(E element);
}