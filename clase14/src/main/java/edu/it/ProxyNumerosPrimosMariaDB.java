package edu.it;

public class ProxyNumerosPrimosMariaDB implements ProxyNumerosPrimos {
	java.sql.Connection conn = null;
	java.sql.ResultSet resultset = null;
	
	public ProxyNumerosPrimosMariaDB() {
		try {
			var connCreator = new ConnectionCreatorMariaDB();
			conn = connCreator.crearConexion();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void fetchNumerosPrimos() {
		try {
			var st = conn.prepareStatement("select numero from numeros_primos");
			resultset = st.executeQuery();
		}
		catch (Exception ex) {
			throw new RuntimeException();
		}
	}
	
	@Override
	public Boolean haySiguiente() {
		try {
			return resultset.next();
		}
		catch (Exception ex) {
			throw new RuntimeException();
		}
	}

	@Override
	public int obtenerSiguiente() {
		try {
			return resultset.getInt("numero");
		}
		catch (Exception ex) {
			throw new RuntimeException();
		}
	}

	@Override
	public void insertarNuvoNumero(int n) {
		System.out.println("Agregando ..." + n);
		try {
			var st = conn.prepareStatement("insert into numeros_primos values (?)");
			st.setInt(1, n);
			st.execute();
			st.close();
		}
		catch (Exception ex) {
			throw new RuntimeException();
		}
	}
	
}
