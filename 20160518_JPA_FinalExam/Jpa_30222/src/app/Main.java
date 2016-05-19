package app;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dao.GenericDao;
import entity.Cinemas;
import entity.Filmes;
import entity.Locais;

public class Main {
	
	static GenericDao<Cinemas> cines;
	static GenericDao<Filmes> filmes;
	static GenericDao<Locais> locais;
	
	public static void main(String[] args) {
		
		cines = new GenericDao<>(Cinemas.class);
		filmes = new GenericDao<>(Filmes.class);
		locais = new GenericDao<>(Locais.class);
		
		String selecao = JOptionPane.showInputDialog("Cadastrar 1, Listar 2");
		
		switch(Integer.valueOf(selecao)){
		case 1:
			cadastro();
			break;
		case 2:
			listar();
			break;
		default:
			JOptionPane.showInputDialog("Numero Inválido");
		}
	}
	
	
	public static void listar(){
		
		
String selecao = JOptionPane.showInputDialog("Listar (Cinema 1, Filmes 2, Local 3)");
		
		String outputStr = "";
		
		switch(Integer.valueOf(selecao)){
		case 1:
			outputStr = "";
			for (Cinemas string : cines.listar()) {
				outputStr += String.format("%s%n", string);
			}
			JOptionPane.showMessageDialog(null, outputStr);	
			break;
		case 2:
			outputStr = "";
			for (Filmes string : filmes.listar()) {
				outputStr += String.format("%s%n", string);
			}
			JOptionPane.showMessageDialog(null, outputStr);	
			break;
		case 3:
			outputStr = "";
			for (Locais string : locais.listar()) {
				outputStr += String.format("%s%n", string);
			}
			JOptionPane.showMessageDialog(null, outputStr);	
			break;
		default:
			JOptionPane.showInputDialog("Numero Inválido");
		}

	}
	
	
	
	public static void cadastro(){
		
		String selecao = JOptionPane.showInputDialog("Cadastrar (Cinema 1, Filmes 2, Local 3)");
		
		String msg = "";
		String[] arguments;
		
		switch(Integer.valueOf(selecao)){
		case 1:
			msg = JOptionPane.showInputDialog("Cadastrar Cinema (descricao, contato)");
			arguments = msg.split(",");
			Cinemas c01 = new Cinemas();
			c01.setDescricao(arguments[0]);
			c01.setContato(arguments[1]);
			cines.adicionar(c01);
			break;
		case 2:
			msg = JOptionPane.showInputDialog("Cadastrar filme (Duração, NumeroSala)");
			arguments = msg.split(",");
			Filmes f01 = new Filmes();
			f01.setDuracao(Double.valueOf(arguments[0]));
			f01.setNumeroSala(Integer.valueOf(arguments[1]));
			filmes.adicionar(f01);
			break;
		case 3:
			msg = JOptionPane.showInputDialog("Cadastrar local (Local, NumeroDeSalas)");
			arguments = msg.split(",");
			Locais l01 = new Locais();
			l01.setLocal(arguments[0]);
			l01.setNumSalas(Integer.valueOf(arguments[1]));
			locais.adicionar(l01);
			break;
		default:
			JOptionPane.showInputDialog("Numero Inválido");
		}
	}
	
	
	
	
	public static void testing(){
		
		Cinemas c01 = new Cinemas();
		
		c01.setDescricao("Cinemark");
		c01.setContato("cine@mark.com");
		
		Locais l01 = new Locais();
		
		l01.setLocal("São Paulo");
		l01.setNumSalas(10);
		
		Filmes f01 = new Filmes();
		
		f01.setNumeroSala(2);
		f01.setDuracao(20);
		
		cines.adicionar(c01);
		locais.adicionar(l01);
		filmes.adicionar(f01);
		
	}

}
