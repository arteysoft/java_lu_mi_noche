package edu.it.ejemplojson;

import java.util.HashMap;

import com.google.gson.Gson;

public class EjemploJson implements Runnable {
	public void run() {
		// Ejemplos de conversion a Json
		
		HashMap<String, Object> mapa = new HashMap<String, Object>();
		
		mapa.put("Nombre", "Adri");
		mapa.put("Edad", 43);
		mapa.put("Le gusta su trabajo", true);
		mapa.put("otroKey", mapa.clone());
		
		String strJson1 = new Gson().toJson("Un string simple");
		String strJson2 = new Gson().toJson(new String[] { "uno", "dos" });
		String strJson3 = new Gson().toJson(new Object[] { "uno", 23, true });
		String strJson4 = new Gson().toJson(mapa);
		
		
		System.out.println(strJson1);
		System.out.println(strJson2);
		System.out.println(strJson3);
		System.out.println(strJson4);
		
	}
}
