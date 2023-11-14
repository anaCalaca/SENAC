package com.empresa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.empresa.factory.ConnectionFactory;
import com.empresa.model.Contato;

public class ContatoDAO {

	public void saveAgenda(Contato contato) {
		// 1 2 3
		String sqlQuery = "INSERT INTO contatos (nome, idade, dataCadastro) VALUES (?, ?, ?);";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// Cria conexão com o MySQL
			conn = ConnectionFactory.createConnectionToMySql();
			pstm = conn.prepareStatement(sqlQuery);

			// Adcionar os valores na Query SQL
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new java.sql.Date(contato.getDataCadastro().getTime()));

			// Executar a Query SQL
			pstm.execute();
			System.out.println("Novo Contato Criado com Sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao tentar criar o Contato na Agenda! ");
			System.out.println(e);
		} finally {

			// Fecha conexão
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				System.out.println("Erro ao fechar a Conexão com o Banco de Dados! ");
				System.out.println(e);
			}
		}
	}
}
