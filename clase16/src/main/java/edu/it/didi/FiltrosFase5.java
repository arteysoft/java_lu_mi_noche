package edu.it.didi;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FiltrosFase5 implements FiltrosChofer {	
	private List<Chofer> filtroGenerico(List<Chofer> lstTodos, Predicate<Chofer> predicado) {
		var lstChoferesRet = new ArrayList<Chofer>();
		
		for (var c : lstTodos) {
			if (predicado.test(c)) {
				lstChoferesRet.add(c);
			}
		}
		
		return lstChoferesRet;
	}
	public List<Chofer> choferesQueLesGusteSuTrabajoSinAccidentes(List<Chofer> lstTodos) { 
		Predicate<Chofer> criterio = (c) -> ((c.leGustaSuTrabajo) &&(c.cantidadAccidentes == 0));
		return filtroGenerico(lstTodos, criterio);
	}
	public List<Chofer> choferesQueLesGusteSuTrabajoConAccidentes(List<Chofer> lstTodos) { 
		Predicate<Chofer> criterio = (Chofer c) -> ((c.leGustaSuTrabajo) && (c.cantidadAccidentes > 0));
		return filtroGenerico(lstTodos, criterio);
	}
	public List<Chofer> choferesQueNoLesGusteSuTrabajoSinAccidentes(List<Chofer> lstTodos) { 
		Predicate<Chofer> criterio = (Chofer c) -> ((c.leGustaSuTrabajo == false) && (c.cantidadAccidentes == 0));
		return filtroGenerico(lstTodos, criterio); 
	}
	public List<Chofer> choferesQueNoLesGusteSuTrabajoConAccidentes(List<Chofer> lstTodos) { 
		Predicate<Chofer> criterio = (Chofer c) -> ((c.leGustaSuTrabajo == false) && (c.cantidadAccidentes > 0));
		return filtroGenerico(lstTodos, criterio);
	}
}
