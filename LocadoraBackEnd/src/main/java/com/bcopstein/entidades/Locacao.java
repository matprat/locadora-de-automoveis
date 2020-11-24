package com.bcopstein.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bcopstein.interfaces.DataLocal;



@Entity
public class Locacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Date inicioLocacao;
	private Date fimLocacao;
	private String placa;
    private String marca;
    private String modelo;
    private boolean arcondicionado;
    private boolean direcao;
    private boolean cambioautomatico;
    private double custoLocacao;
    private double seguro;
    private double desconto;
    private double totalPagar;
    
    public Locacao(DataLocal inicioLocacao, DataLocal fimLocacao, String placa, String marca, String modelo, boolean arcondicionado, boolean direcao,
    				boolean cambioautomatico, double custoLocacao, double seguro, double desconto, double totalPagar) {
    	this.inicioLocacao = inicioLocacao.toDateFormatDatabase();
    	this.fimLocacao = fimLocacao.toDateFormatDatabase();
    	this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.arcondicionado = arcondicionado;
        this.direcao = direcao;
        this.cambioautomatico = cambioautomatico;
        this.custoLocacao = custoLocacao;
        this.seguro = seguro;
        this.desconto = desconto;
        this.totalPagar = totalPagar;
    }
    
    protected Locacao(){}
    
    public Long getId() {
    	return this.id;
    }
    
    public Date getInicioLocacao() {
        return this.inicioLocacao;
    }
    
    public Date getFimLocacao() {
        return this.fimLocacao;
    }
   
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

    @Override
    public String toString() {
        return "Aluguel [inicioLocacao=" + this.inicioLocacao + ", fimLocacao="+ this.fimLocacao +
        				", placa=" + placa +", marca=" + marca + ", modelo=" + modelo +
        				", arcondicionado=" + arcondicionado + ", cambioautomatico=" + cambioautomatico +
        				", direcao=" + direcao + "]";
    }

	public double getCustoLocacao() {
		return custoLocacao;
	}

	public double getSeguro() {
		return seguro;
	}
	
	public void setSeguro(double novoSeguro) {
		this.seguro = novoSeguro;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public double getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}
}
