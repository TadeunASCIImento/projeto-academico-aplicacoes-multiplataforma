package br.com.desaparecidos.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DaoConnection {

	private static final String SERVIDOR = "localhost:3306";
	private static final String NOME_BANCO = "db_pessoas_desaparecidas";
	private static final String USUARIO_BANCO = "root";
	private static final String SENHA_BANCO = "Ted43497853@";
	private static final String TIME_ZONE = "?serverTimezone=UTC";
	protected PreparedStatement pstm;
	protected Connection conn;
	protected ResultSet resultado;

	public Connection obterConexao() {

		String url_banco = "jdbc:mysql://" + SERVIDOR + "/" + NOME_BANCO + TIME_ZONE;
	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}	
		try {

			conn = DriverManager.getConnection(url_banco, USUARIO_BANCO, SENHA_BANCO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}

}
