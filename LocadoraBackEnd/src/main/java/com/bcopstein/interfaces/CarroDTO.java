package com.bcopstein.interfaces;

public class CarroDTO {
    private String placa;
   
    public CarroDTO(String placa) {
        this.placa = placa;
    }

    public CarroDTO(){
        
    }
   
    public String getPlaca() {
        return placa;
    }

   
    @Override
    public String toString() {
        return "CarroDTO [placa=" + placa + "]";
    }
}
