package com.aluracursos.challenge.conversor_monedas.modelos;

public class realesBra extends Conversion{

    String name = "BRL";

    public String getName() {
        return name;
    }
    public double obtenerTasa (){
        return obtenerTasaAPI("BRL");
    }
}
