package edu.it.didi;

import java.util.ArrayList;
import java.util.List;

public class FiltrosFase1 implements FiltrosChofer {
	public List<Chofer> choferesQueLesGusteSuTrabajoSinAccidentes(List<Chofer> lstTodos) { 
		var lstChoferesRet = new ArrayList<Chofer>();
		
		for (var c : lstTodos) {
			if (c.leGustaSuTrabajo) {
				if (c.cantidadAccidentes == 0) {
					lstChoferesRet.add(c);
				}
			}
		}
		
		return lstChoferesRet;
	}
	public List<Chofer> choferesQueLesGusteSuTrabajoConAccidentes(List<Chofer> lstTodos) { 
		var lstChoferesRet = new ArrayList<Chofer>();
		
		for (var c : lstTodos) {
			if (c.leGustaSuTrabajo) {
				if (c.cantidadAccidentes > 0) {
					lstChoferesRet.add(c);
				}
			}
		}
		
		return lstChoferesRet;
	}
	public List<Chofer> choferesQueNoLesGusteSuTrabajoSinAccidentes(List<Chofer> lstTodos) { 
		var lstChoferesRet = new ArrayList<Chofer>();
		
		for (var c : lstTodos) {
			if (c.leGustaSuTrabajo == false) {
				if (c.cantidadAccidentes == 0) {
					lstChoferesRet.add(c);
				}
			}
		}
		
		return lstChoferesRet; 
	}
	public List<Chofer> choferesQueNoLesGusteSuTrabajoConAccidentes(List<Chofer> lstTodos) { 
		var lstChoferesRet = new ArrayList<Chofer>();
		
		for (var c : lstTodos) {
			if (c.leGustaSuTrabajo == false) {
				if (c.cantidadAccidentes > 0) {
					lstChoferesRet.add(c);
				}
			}
		}
		
		return lstChoferesRet;
	}
}
