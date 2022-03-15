package agencia.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectionfactory {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agencia_de_viagens";

	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return connection;
	}

	public static void main(String[] Args) throws Exception{
		Connection conn = createConnectionToMySQL();
		if (conn != null) {
			System.out.println("Conexao obtida com sucesso!");
			conn.close();
		}
	}
}