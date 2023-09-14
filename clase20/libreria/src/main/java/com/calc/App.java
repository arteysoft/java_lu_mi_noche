package com.calc;

import com.calc.model.PrecioVolatilidad;
import com.google.gson.Gson;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Prueba calc");
        
        PrecioVolatilidad pv = new PrecioVolatilidad(4f, 20);
        System.out.println(new Gson().toJson(pv));
    }
}
