package edu.it.didi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;

public class EjemploChofer implements Runnable {
	private List<Chofer> crearChoferes() {
		var choferes = new ArrayList<Chofer>();
		
		choferes.add(new Chofer("Cristina", true, 0));
		choferes.add(new Chofer("Keo", true, 0));
		choferes.add(new Chofer("Leonardo", true, 3));
		choferes.add(new Chofer("Sabrina", true, 5));
		choferes.add(new Chofer("Lucia", false, 0));
		choferes.add(new Chofer("Osvaldo", false, 0));
		choferes.add(new Chofer("Manuela", false, 2));
		choferes.add(new Chofer("Esteban", false, 3));
		
		return choferes;
	}
	public void run() {
		/*
		 * Teniendo 8 choferes tengo que hacer una class
		 * que vaya filtrando a los choferes en virtud de unos
		 * rasgos que estos tienen
		 */
	
		var lstChoferes = crearChoferes();
		
		FiltrosChofer filtro = new FiltrosFase6();
		Object o = null;
		
		System.out.println("Le gusta su trabajo sin accidentes");
		o = filtro.choferesQueLesGusteSuTrabajoSinAccidentes(lstChoferes);
		System.out.println(new Gson().toJson(o));
		System.out.println();
		System.out.println("Le gusta su trabajo con accidentes");		
		o = filtro.choferesQueLesGusteSuTrabajoConAccidentes(lstChoferes);
		System.out.println(new Gson().toJson(o));
		System.out.println();
		System.out.println("NO gusta su trabajo sin accidentes");
		o = filtro.choferesQueNoLesGusteSuTrabajoSinAccidentes(lstChoferes);
		System.out.println(new Gson().toJson(o));
		System.out.println();
		System.out.println("NO gusta su trabajo con accidentes");
		o = filtro.choferesQueNoLesGusteSuTrabajoConAccidentes(lstChoferes);
		System.out.println(new Gson().toJson(o));
		System.out.println();
		
		System.out.println("--------------------------------------");
		
		var out = lstChoferes
			.stream()
			.map(z -> new String[] {z.nombre, z.nombre} )
			.map(zs -> zs[0].concat(zs[1]))
			.filter(z -> z.length() > 15)
			.collect(Collectors.toList());
		
		System.out.println(new Gson().toJson(out));
	}
}
