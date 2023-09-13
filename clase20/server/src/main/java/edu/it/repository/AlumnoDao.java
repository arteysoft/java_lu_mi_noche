package edu.it.repository;

import edu.it.model.Alumno;

public class AlumnoDao {
	public void insertar(Alumno alumno) {
		var conn = new edu.it.components.ConectorJPA();
		var entityManager = conn.getEntityManager();
		var tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(alumno);
		tx.commit();
		entityManager.close();
	}
}
