package com.bcopstein.interfaces;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataLocal {
    private int dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    private int mes = Calendar.getInstance().get(Calendar.MONTH) + 1;
    private int ano = Calendar.getInstance().get(Calendar.YEAR);

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getDia() {
        return dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getMes() {
        return mes;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getAno() {
        return ano;
    }
    
    public Date toDateFormatDatabase() {
    	SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
		try {
			String dataString = this.getAno() + "-" + this.getMes() + "-" + this.getDia();
			Date dataFormatada = formatador.parse(dataString);
			long time = dataFormatada.getTime();
			return new Timestamp(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public Date toDate() {
    	SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		try {
			String dataString = this.getDia() + "/" + this.getMes() + "/" + this.getAno();
			Date dataFormatada = formatador.parse(dataString);
			return dataFormatada;
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return null;
    }

    @Override
    public String toString() {
        return "DataLocal [ano=" + ano + ", dia=" + dia + ", mes=" + mes + "]";
    }
}
