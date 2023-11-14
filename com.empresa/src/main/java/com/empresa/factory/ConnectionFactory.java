package com.empresa.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static final String USERNAME = "root";

	private static final String PASSWORD = "candanguinho";

	//caminho (path) do MySql 
	private static final String DATABASE_URL =  "jdbc:mysql://localhost:3306/agenda";

	// conexão com o mySql
	public static Connection createConnectionToMySql() throws Exception {

		// Criarconexão com o banco de dados MySql
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		return connection;
	}

}
