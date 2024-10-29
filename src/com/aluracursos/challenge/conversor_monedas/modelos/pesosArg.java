package com.aluracursos.challenge.conversor_monedas.modelos;

public class pesosArg extends Conversion {
    String name = "ARS";

    public String getName() {
        return name;
    }

    public double obtenerTasa (){
        return obtenerTasaAPI("ARS");
    }
}
