package edu.it;

public class Transacciones {
	public void run() {
		/*
		 * Cual es el problema.
		 * 
		 * El problema es cuando tengo dos o mas acciones que todas 
		 * representan un mismo movimiento ya sea contable, 
		 */
		
		var connCreator = new ConnectionCreatorMariaDB();
		int importe = -10;
		
		java.sql.Connection conn = null; 
		
		try {
			conn = connCreator.crearConexion();
			conn.setAutoCommit(false);
			
			var st = conn.prepareStatement("insert movimientos values (?)");
			st.setInt(1, importe);
			st.execute();
			st.close();
			
			if (importe != 10) {
				throw new RuntimeException("Error en algun calculo");
			}
			
			var st2 = conn.prepareStatement("update saldos set saldo = saldo + ?");
			st2.setInt(1, importe);
			st2.execute();
			st2.close();
			
			conn.commit();
			
			conn.close();
		}
		catch (Exception ex) {
			try {
				conn.rollback();
			}
			catch (Exception ezzz) {
				
			}
			ex.printStackTrace();
		}
	}
}
