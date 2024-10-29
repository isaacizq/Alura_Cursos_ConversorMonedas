package com.aluracursos.challenge.conversor_monedas.modelos;

public class pesosCop extends Conversion {
    String name = "COP";

    public String getName() {
        return name;
    }

    public double obtenerTasa (){
        return obtenerTasaAPI("COP");
    }
}
