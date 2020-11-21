package com.bcopstein.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Carro {
	@Id
    private String placa;
    private String marca;
    private String modelo;
    private boolean arcondicionado;
    private boolean direcao;
    private boolean cambioautomatico;
    private boolean disponivel;

    public Carro(String placa, String marca, String modelo, boolean arcondicionado, boolean direcao, boolean cambioautomatico) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.arcondicionado = arcondicionado;
        this.direcao = direcao;
        this.cambioautomatico = cambioautomatico;
    }
    
    protected Carro(){}

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public boolean isArcondicionado() {
        return arcondicionado;
    }

    public boolean isDirecao() {
        return direcao;
    }

    public boolean isCambioautomatico() {
        return cambioautomatico;
    }
    
    public boolean getDIsponivel() {
    	return this.disponivel;
    }

    @Override
    public String toString() {
        return "Carro [arcondicionado=" + arcondicionado + ", cambioautomatico=" + cambioautomatico + ", direcao="
                + direcao + ", marca=" + marca + ", modelo=" + modelo + ", placa=" + placa + "]";
    } 
}
