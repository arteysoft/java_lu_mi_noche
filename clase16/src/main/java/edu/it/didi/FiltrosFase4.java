package edu.it.didi;

import java.util.ArrayList;
import java.util.List;

public class FiltrosFase4 implements FiltrosChofer {	
	private List<Chofer> filtroGenerico(List<Chofer> lstTodos, Predicado<Chofer> predicado) {
		var lstChoferesRet = new ArrayList<Chofer>();
		
		for (var c : lstTodos) {
			if (predicado.test(c)) {
				lstChoferesRet.add(c);
			}
		}
		
		return lstChoferesRet;
	}
	public List<Chofer> choferesQueLesGusteSuTrabajoSinAccidentes(List<Chofer> lstTodos) { 
		Predicado<Chofer> criterio = (c) -> ((c.leGustaSuTrabajo) &&(c.cantidadAccidentes == 0));
		return filtroGenerico(lstTodos, criterio);
	}
	public List<Chofer> choferesQueLesGusteSuTrabajoConAccidentes(List<Chofer> lstTodos) { 
		Predicado<Chofer> criterio = (Chofer c) -> ((c.leGustaSuTrabajo) && (c.cantidadAccidentes > 0));
		return filtroGenerico(lstTodos, criterio);
	}
	public List<Chofer> choferesQueNoLesGusteSuTrabajoSinAccidentes(List<Chofer> lstTodos) { 
		Predicado<Chofer> criterio = (Chofer c) -> ((c.leGustaSuTrabajo == false) && (c.cantidadAccidentes == 0));
		return filtroGenerico(lstTodos, criterio); 
	}
	public List<Chofer> choferesQueNoLesGusteSuTrabajoConAccidentes(List<Chofer> lstTodos) { 
		Predicado<Chofer> criterio = (Chofer c) -> ((c.leGustaSuTrabajo == false) && (c.cantidadAccidentes > 0));
		return filtroGenerico(lstTodos, criterio);
	}
}
