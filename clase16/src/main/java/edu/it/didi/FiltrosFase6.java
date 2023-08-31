package edu.it.didi;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FiltrosFase6 implements FiltrosChofer {
	public List<Chofer> choferesQueLesGusteSuTrabajoSinAccidentes(List<Chofer> lstTodos) {		
		return lstTodos
			.stream()
			.filter(c -> c.leGustaSuTrabajo)
			.filter(c -> c.cantidadAccidentes == 0)			
			.collect(Collectors.toList());
		
	}
	public List<Chofer> choferesQueLesGusteSuTrabajoConAccidentes(List<Chofer> lstTodos) { 
		return lstTodos
				.stream()
				.filter(c -> c.leGustaSuTrabajo)
				.filter(c -> c.cantidadAccidentes > 0)
				.collect(Collectors.toList());
	}
	public List<Chofer> choferesQueNoLesGusteSuTrabajoSinAccidentes(List<Chofer> lstTodos) { 
		return lstTodos
				.stream()				
				.filter(c -> c.leGustaSuTrabajo == false)
				.filter(c -> c.cantidadAccidentes == 0)				
				.collect(Collectors.toList());
	}
	public List<Chofer> choferesQueNoLesGusteSuTrabajoConAccidentes(List<Chofer> lstTodos) { 
		return lstTodos
				.stream()
				.filter(c -> c.leGustaSuTrabajo == false)
				.filter(c -> c.cantidadAccidentes > 0)
				.collect(Collectors.toList());
	}
}
