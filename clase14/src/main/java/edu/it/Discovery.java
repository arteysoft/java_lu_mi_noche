package edu.it;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Discovery {
	private void agregarNumeroPrimo(Connection conn, int num) throws SQLException {
		System.out.println("Agregando ..." + num);
		var st = conn.prepareStatement("insert into numeros_primos values (?)");
		st.setInt(1, num);
		st.execute();
		st.close();
	}
	private Boolean testearSiTieneRaiz(ResultSet rs, int numero_a_testear) throws Exception {
		for (; rs.next() ;) {
			var divisor = rs.getInt("numero");
			if (numero_a_testear % divisor == 0) {
				return false;
			}
		}
		return true;
	}
	private void probarConLosNumerosDeLaTabla(int numero_a_testear) {
		java.sql.Connection conn = null; 
		
		try {
			var connCreator = new ConnectionCreatorMariaDB();
			
			conn = connCreator.crearConexion();
			
			var st = conn.prepareStatement("select numero from numeros_primos");
			var resultset = st.executeQuery();
		
			if (testearSiTieneRaiz(resultset, numero_a_testear)) {
				agregarNumeroPrimo(conn, numero_a_testear);
			}
			
			resultset.close();			
			conn.close();
			Thread.sleep(50);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void run() {
		int numerador = 3;
		for (;;) {
			probarConLosNumerosDeLaTabla(numerador);
			numerador++;
		}
	}
}
