/**
 * 
 */
package application;

import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dao.*;
import entity.*;


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
		
		daoAgenda = new GenericDao<>(Agenda.class);
		daoPaciente = new GenericDao<>(Paciente.class);
		daoProcedimento = new GenericDao<>(Procedimento.class);
		daoMatmed = new GenericDao<>(Matmed.class);
		
		
		
		commandMenu();
		
		
	}
	
	
	public static void commandMenu(){
		
		printHelp();
		
		boolean exit = true;
		do {
			System.out.print("digite comando > ");
			Scanner keyboard = new Scanner(System.in);
			switch(keyboard.nextLine()){
			case "cadastra agenda":
				
				cadastra(tipoCad.AGENDA);
				break;
			case "cadastra paciente":
				cadastra(tipoCad.PACIENTE);
				break;
			case "vincula ap": // vincula agenda-paciente
				
				break;
			case "cadastra procedimento":
				cadastra(tipoCad.PROCEDIMENTO);
				break;
			case "cadastra matmed":
				cadastra(tipoCad.MATMED);
				break;
			case "lista agenda":
				
				break;
			case "lista paciente":
	
				break;
			case "lista procediemento":
				
				
				break;
			case "lista matmed":
				
				
				break;
			case "help":
				printHelp();
				break;
			case "sair":
				exit = false;
			}
		} while (exit);
		
	}
	
	public enum tipoCad {
		AGENDA, PACIENTE, PROCEDIMENTO, MATMED, VINCULA_PACIENTE_AGENDA;
	}
	
	public static void cadastra(tipoCad tipo){
		
		switch(tipo){
		case AGENDA:
			System.out.println("> Agenda");
			{
			String input = JOptionPane.showInputDialog("Insira Agenda: DATA (dd/mm/yy), DESCRIÇÃO, HORA (hh:mm)");
			
			String[] args = input.split(", ");
			String[] strDate = args[0].split("/");
			String[] strHora = args[2].split(":");
			
			int dia = Integer.valueOf(strDate[0]);
			int mes = Integer.valueOf(strDate[1]) - 1;
			int ano = Integer.valueOf(strDate[2]);
			
			int hora = Integer.valueOf(strHora[0]);
			int min = Integer.valueOf(strHora[1]);
				
			Date d = new Date(ano, mes, dia, hora, min);
			
			daoAgenda.adicionar(new Agenda(d, d, args[1]));
			}
			break;
			
		case PACIENTE:
			{
			System.out.println("> Paciente");
			
			String input = JOptionPane.showInputDialog("Insira Paciente: CPF, NOME, DATANASC (dd/mm/yy), TELEFONE");
			
			String[] args = input.split(", ");
			String[] strDate = args[2].split("/");
			
			int dia = Integer.valueOf(strDate[0]);
			int mes = Integer.valueOf(strDate[1]) - 1;
			int ano = Integer.valueOf(strDate[2]);
			
			daoPaciente.adicionar(new Paciente(args[0], args[1], new Date(ano, mes, dia), args[3]));
			}
			break;	
		case PROCEDIMENTO:
			{
			System.out.println("> Procedimento");
			
			List<Paciente> pacientes = daoPaciente.listar();
			
			 JFrame frame = new JFrame();
			 String bigList[] = new String[pacientes.size()];
			 
			 int i = 0;
			 for (Paciente paciente : pacientes) {
				 bigList[i] = paciente.getCPF() + " - " + paciente.getNome();
				 i++;
				}
			 String[] key = JOptionPane.showInputDialog(frame, "Selecione Paciente", "Input", JOptionPane.QUESTION_MESSAGE,null, bigList, "Titan").toString().split(" - ");
			 
	
			String input = JOptionPane.showInputDialog("Insira Procedimento: DESCRIÇÃO, PREÇO");
			String[] args = input.split(", ");
			
			Paciente keyPaciente = null;
			for (Paciente paciente : pacientes) {
	 
				 if(paciente.getCPF().equals(key[0])){
					 keyPaciente = paciente;
					 break;
				 }
				}
			
			daoProcedimento.adicionar(new Procedimento(args[0], Double.valueOf(args[1]),keyPaciente));
			}
			break;
			
		case MATMED:
			{
			System.out.println("> MatMed");
			
			List<Paciente> pacientes = daoPaciente.listar();
			
			 JFrame frame = new JFrame();
			 String bigList[] = new String[pacientes.size()];
			 
			 int i = 0;
			 for (Paciente paciente : pacientes) {
				 bigList[i] = paciente.getCPF() + " - " + paciente.getNome();
				 i++;
				}
			 String[] key = JOptionPane.showInputDialog(frame, "Selecione Paciente", "Input", JOptionPane.QUESTION_MESSAGE,null, bigList, "Titan").toString().split(" - ");
			 
	
			String input = JOptionPane.showInputDialog("Insira MatMed: DESCRIÇÃO, FABRICANTE, PREÇO");
			String[] args = input.split(", ");
			
			Paciente keyPaciente = null;
			for (Paciente paciente : pacientes) {
	 
				 if(paciente.getCPF().equals(key[0])){
					 keyPaciente = paciente;
					 break;
				 }
				}
			daoMatmed.adicionar(new Matmed(args[0], Double.valueOf(args[2]), args[1], keyPaciente));
			
			}
			break;
			
		case VINCULA_PACIENTE_AGENDA:
		{
			
			
			
		}
			break;
	
		}	
		
	}
	
	
	public static void printHelp(){
		
		System.out.println("");
		System.out.printf("Digite:%n"
				+ "cadastra agenda%n"
				+ "vincula ap%n"
				+ "cadastra procedimento%n"
				+ "cadastra matmed%n"
				+ "lista agenda%n"
				+ "lista paciente%n"
				+ "lista procediemento%n"
				+ "lista matmed%n"
				+ "help%n"
				+ "sair%n%n");
		
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


