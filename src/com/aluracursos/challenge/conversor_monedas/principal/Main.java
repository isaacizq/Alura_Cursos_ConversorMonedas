package com.aluracursos.challenge.conversor_monedas.principal;

import com.aluracursos.challenge.conversor_monedas.modelos.Conversion;
import com.aluracursos.challenge.conversor_monedas.modelos.pesosArg;
import com.aluracursos.challenge.conversor_monedas.modelos.pesosCop;
import com.aluracursos.challenge.conversor_monedas.modelos.realesBra;
import com.sun.deploy.net.HttpRequest;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Conversion conversion = null;
        double tasa = 0.0;
        boolean estado = true;
        while (estado) {
            // Menú de opciones
            System.out.println("****************************************************************");
            System.out.println("Selecciona una opción:");
            System.out.println("1. Pesos Argentinos a Dólares");
            System.out.println("2. Reales Brasileños a Dólares");
            System.out.println("3. Pesos Colombianos a Dólares");
            System.out.println("4. Dólares a Pesos Argentinos");
            System.out.println("5. Dólares a Reales Brasileños");
            System.out.println("6. Dólares a Pesos Colombianos");
            System.out.println("9. Salir");
            int opcion = scanner.nextInt();
            String keyName="";
            double cantidad;
            switch (opcion) {
                case 1:
                    System.out.println("Ingresa la cantidad a convertir:");
                    cantidad = scanner.nextDouble();
                    conversion = new pesosArg();
                    conversion.setCantidad(cantidad);
                    tasa = ((pesosArg) conversion).obtenerTasa();
                    break;
                case 2:
                    System.out.println("Ingresa la cantidad a convertir:");
                    cantidad = scanner.nextDouble();
                    conversion = new realesBra();
                    conversion.setCantidad(cantidad);
                    tasa = ((realesBra) conversion).obtenerTasa();
                    break;
                case 3:
                    System.out.println("Ingresa la cantidad a convertir:");
                    cantidad = scanner.nextDouble();
                    conversion = new pesosCop();
                    conversion.setCantidad(cantidad);
                    tasa = ((pesosCop) conversion).obtenerTasa();
                    break;
                case 4:
                    System.out.println("Ingresa la cantidad a convertir:");
                    cantidad = scanner.nextDouble();
                    conversion = new pesosArg();
                    conversion.setCantidad(cantidad);
                    tasa = ((pesosArg) conversion).obtenerTasa();
                    keyName= ((pesosArg) conversion).getName();
                    break;
                case 5:
                    System.out.println("Ingresa la cantidad a convertir:");
                    cantidad = scanner.nextDouble();
                    conversion = new realesBra();
                    conversion.setCantidad(cantidad);
                    tasa = ((realesBra) conversion).obtenerTasa();
                    keyName= ((realesBra) conversion).getName();
                    break;
                case 6:
                    System.out.println("Ingresa la cantidad a convertir:");
                    cantidad = scanner.nextDouble();
                    conversion = new pesosCop();
                    conversion.setCantidad(cantidad);
                    tasa = ((pesosCop) conversion).obtenerTasa();
                    keyName= ((pesosCop) conversion).getName();
                    break;
                case 9:
                    System.out.println("Gracias por usar nuestro sistema");
                    estado=false;
                    break;
            }
            // Si se eligió una opción válida, realiza la conversión
            if (conversion != null && opcion < 4) {
                double resultado = conversion.convertir_To_KeyLocal(tasa);
                System.out.println("El resultado de la conversión es: " + resultado + " USD");
            } else if (opcion>=4 && opcion <=6) {
                double resultado = conversion.convertir_To_dollar(tasa);
                System.out.println("El resultado de la conversión es: " + resultado + " " + keyName);
            } else if (opcion!=9) {
                System.out.println("Opción no válida.");
            }
        }
    }
}
