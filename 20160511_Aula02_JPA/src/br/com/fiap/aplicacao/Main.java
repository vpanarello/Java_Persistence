package br.com.fiap.aplicacao;

import javax.swing.JOptionPane;

import br.com.fiap.dao.ClientesDao;
import br.com.fiap.java.Clientes;

public class Main {

	public static void main(String[] args) {
		
		String nome = JOptionPane.showInputDialog("Inserir nome");
		String email = JOptionPane.showInputDialog("Inserir email");
		
		
		Clientes cliente = new Clientes();
		cliente.setNome(nome);
		cliente.setEmail(email);
		
		ClientesDao dao = new ClientesDao();
		
		
		try {
			dao.incluirCliente(cliente);
			JOptionPane.showMessageDialog(null,"Feito !");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

}
