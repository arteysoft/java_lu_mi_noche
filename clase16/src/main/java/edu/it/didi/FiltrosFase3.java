package edu.it.didi;

import java.util.ArrayList;
import java.util.List;

public class FiltrosFase3 implements FiltrosChofer {	
	private List<Chofer> filtroGenerico(List<Chofer> lstTodos, GrupoInclusion grupoInclusion) {
		var lstChoferesRet = new ArrayList<Chofer>();
		
		for (var c : lstTodos) {
			if (grupoInclusion.test(c)) {
				lstChoferesRet.add(c);
			}
		}
		
		return lstChoferesRet;
	}
	public List<Chofer> choferesQueLesGusteSuTrabajoSinAccidentes(List<Chofer> lstTodos) { 
		GrupoInclusion criterio = (c) -> ((c.leGustaSuTrabajo) &&(c.cantidadAccidentes == 0));
		return filtroGenerico(lstTodos, criterio);
	}
	public List<Chofer> choferesQueLesGusteSuTrabajoConAccidentes(List<Chofer> lstTodos) { 
		GrupoInclusion criterio = (Chofer c) -> ((c.leGustaSuTrabajo) && (c.cantidadAccidentes > 0));
		return filtroGenerico(lstTodos, criterio);
	}
	public List<Chofer> choferesQueNoLesGusteSuTrabajoSinAccidentes(List<Chofer> lstTodos) { 
		GrupoInclusion criterio = (Chofer c) -> ((c.leGustaSuTrabajo == false) && (c.cantidadAccidentes == 0));
		return filtroGenerico(lstTodos, criterio); 
	}
	public List<Chofer> choferesQueNoLesGusteSuTrabajoConAccidentes(List<Chofer> lstTodos) { 
		GrupoInclusion criterio = (Chofer c) -> ((c.leGustaSuTrabajo == false) && (c.cantidadAccidentes > 0));
		return filtroGenerico(lstTodos, criterio);
	}
}
