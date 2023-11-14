package com.empresa.application;

import java.util.Date;
import com.empresa.dao.ContatoDAO;
import com.empresa.model.Contato;

public class MainAgenda {
	public static void main(String[] args) {
		Contato novoContato = new Contato();
		ContatoDAO conn = new ContatoDAO();

// Criando um novo contato
		novoContato.setNome("Ricardo Kratz");
		novoContato.setIdade(48);
		novoContato.setDataCadastro(new Date());

// Salvando no MySQL
		conn.saveAgenda(novoContato);
	}
}
