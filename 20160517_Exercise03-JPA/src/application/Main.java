/**
 * 
 */
package application;

import java.util.Date;
import java.util.Scanner;

import javax.persistence.EntityManager;

import dao.Dao;
import dao.GenericDao;
import dao.JpaUtil;
import entity.Agenda;
import entity.Matmed;
import entity.Paciente;
import entity.Procedimento;

/**
 * 20160518-Exercise03-JPA / Main.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class Main {
	
	static GenericDao<Agenda> daoAgenda;
	static GenericDao<Paciente> daoPaciente;
	static GenericDao<Procedimento> daoProcedimento;
	static GenericDao<Matmed> daoMatmed;
	static Scanner scan;
	static int selectedEntity;

	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		selectedEntity = 1;
		
		daoAgenda = new GenericDao<>(Agenda.class);
		daoPaciente = new GenericDao<>(Paciente.class);
		daoProcedimento = new GenericDao<>(Procedimento.class);
		daoMatmed = new GenericDao<>(Matmed.class);
		
		Date d = new Date(2016, 05, 17, 18, 10);
		Agenda agenda = new Agenda(d, d,  "Adição de teste do JPA");
		
		daoAgenda.adicionar(agenda);
		
		
		menu01();
		
		
		
	}
	
	public static void menu01(){	
		System.out.println("1: adicionar, 2: listar");	
		String text = scan.nextLine();
		switch(text.toLowerCase()){
		case "1":
			qualEntidade();
			adicionarRegistro(selectedEntity);


			
			break;
		case "2": // listar
			qualEntidade();
			listar(selectedEntity);
			
			break;
		default:
		}	
	}
	
	public static void qualEntidade(){
		System.out.println("Qual Entidade? (1-Agenda, 2-Paciente, 3-Procedimento,4-Matmet )");
		String text = scan.nextLine();
		selectedEntity = Integer.valueOf(text);	
	}
	
	public static void adicionarRegistro(int item){
		
		switch(item){
		case 1:
			System.out.println("Adicionar registro em Agenda");
			System.out.println("Digite: ");
			String text = scan.nextLine();
			
			
			daoPaciente.adicionar(new Paciente(cPF, nome, dataNascimento, telefone, agendas));
				
			break;
		case 2:
			for(Paciente pa : daoPaciente.listar()){
				System.out.println(pa.toString());
			}
			break;
		case 3:
			for(Procedimento pr : daoProcedimento.listar()){
				System.out.println(pr.toString());
			}
			break;
		case 4:
			for(Matmed mm : daoMatmed.listar()){
				System.out.println(mm.toString());
			}
			break;
		}
	}
	
	
	
	public static void listar(int item){
		
		switch(item){
		case 1:
			for(Agenda a : daoAgenda.listar()){
				System.out.println(a.toString());
			}	
			break;
		case 2:
			for(Paciente pa : daoPaciente.listar()){
				System.out.println(pa.toString());
			}
			break;
		case 3:
			for(Procedimento pr : daoProcedimento.listar()){
				System.out.println(pr.toString());
			}
			break;
		case 4:
			for(Matmed mm : daoMatmed.listar()){
				System.out.println(mm.toString());
			}
			break;
		}
				
	}

}
