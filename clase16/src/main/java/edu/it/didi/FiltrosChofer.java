package edu.it.didi;

import java.util.List;

public interface FiltrosChofer {
	public List<Chofer> choferesQueLesGusteSuTrabajoSinAccidentes(List<Chofer> lstTodos);
	public List<Chofer> choferesQueLesGusteSuTrabajoConAccidentes(List<Chofer> lstTodos);
	public List<Chofer> choferesQueNoLesGusteSuTrabajoSinAccidentes(List<Chofer> lstTodos);
	public List<Chofer> choferesQueNoLesGusteSuTrabajoConAccidentes(List<Chofer> lstTodos);
}
