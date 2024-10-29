package com.aluracursos.challenge.conversor_monedas.modelos;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Conversion {
    private double cantidad;
    private String name;

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    public double convertir_To_dollar(double tasaCambio) {
        return cantidad * tasaCambio;
    }
    public double convertir_To_KeyLocal(double tasaCambio) {
        return cantidad/tasaCambio;
    }
    public double getCantidad() {
        return cantidad;
    }
    public void setName(String name) {
        this.name = name;
    }
    // Método para obtener la tasa desde la API usando GSON
    public  double obtenerTasaAPI(String monedaDestino) {
        String apiURL = "https://v6.exchangerate-api.com/v6/8fbbd6712ef263a165df4501/latest/USD";
        try {
            // Conectar a la API
            URL url = new URL(apiURL);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Leer el JSON desde la API
            JsonParser jp = new JsonParser();
            JsonObject json = (JsonObject) jp.parse(new InputStreamReader((request.getInputStream())));

            // Obtener el objeto "conversion_rates" que contiene las tasas
            JsonObject conversionRates = json.getAsJsonObject("conversion_rates");

            // Retorna la tasa de la moneda destino
            return conversionRates.get(monedaDestino).getAsDouble();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1.0; // Retorna 1.0 en caso de error, para evitar errores en la conversión
    }
}
