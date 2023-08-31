package edu.it.didi;

import java.util.ArrayList;
import java.util.List;

public class FiltrosFase2 implements FiltrosChofer {	
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
		GrupoInclusion criterio = (Chofer c) -> {
			if (c.leGustaSuTrabajo) {
				if (c.cantidadAccidentes == 0) {
					return true;
				}
			}
			return false;
		};
		
		return filtroGenerico(lstTodos, criterio);
	}
	public List<Chofer> choferesQueLesGusteSuTrabajoConAccidentes(List<Chofer> lstTodos) { 
		GrupoInclusion criterio = (Chofer c) -> {
			if (c.leGustaSuTrabajo) {
				if (c.cantidadAccidentes > 0) {
					return true;
				}
			}
			return false;
		};
		
		return filtroGenerico(lstTodos, criterio);
	}
	public List<Chofer> choferesQueNoLesGusteSuTrabajoSinAccidentes(List<Chofer> lstTodos) { 
		GrupoInclusion criterio = (Chofer c) -> {
			if (c.leGustaSuTrabajo == false) {
				if (c.cantidadAccidentes == 0) {
					return true;
				}
			}
			return false;
		};
		
		return filtroGenerico(lstTodos, criterio); 
	}
	public List<Chofer> choferesQueNoLesGusteSuTrabajoConAccidentes(List<Chofer> lstTodos) { 
		GrupoInclusion criterio = (Chofer c) -> {
			if (c.leGustaSuTrabajo == false) {
				if (c.cantidadAccidentes > 0) {
					return true;
				}
			}
			return false;
		};
		
		return filtroGenerico(lstTodos, criterio);
	}
}
