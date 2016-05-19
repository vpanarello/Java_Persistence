/**
 * 
 */
package app;

import javax.persistence.*;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

import entity.*;

/**
 * 20160515-JPA_Exercice01 / FrontEnd.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class FrontEnd {

	static Clientes c;
	static daoHelper dao;
	
	
	private static void initializeJPA(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaEx01");
		EntityManager em = emf.createEntityManager();
		dao = new daoHelper(em);
	}

	
	public static void main(String[] args) throws IOException {
		
		initializeJPA();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int keyValue;
		String[] arguments = null;

		
		do {
			do {
				System.out.printf("%n%n%n");
				System.out.print("Selecione inserir> 1: Cliente, 2: Pedido ");
				keyValue = Integer.valueOf(br.readLine());	
				
			} while (keyValue < 1 || keyValue > 2);
			

			if (keyValue == 1) {
				System.out.printf("%n");
				System.out.println("Cliente: Nome, E-Mail");
				arguments = br.readLine().split(",");

				Clientes c = new Clientes(0, arguments[0], arguments[1]);

				try {
					dao.putIntoDB(c);
					System.out.println("Cliente inserido!");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				//			for (String arg : arguments) {
				//				System.out.println(arg);
				//			}

			} else if (keyValue == 2) {
				System.out.printf("%n");
				System.out.println("Pedido: ClienteID, Descricao, Valor");
				arguments = br.readLine().split(",");

				Calendar cal = Calendar.getInstance();
				Date data = new Date(cal.getTimeInMillis());

				Pedidos p = new Pedidos(0, data, arguments[1], Double.valueOf(arguments[2]));

				try {
					dao.putIntoDB(p, Integer.valueOf(arguments[0]));
					System.out.println("Pedido inserido!");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} 
			System.out.println("Inserir outro registro? (s/n)");
			arguments[0] = br.readLine();
		} while (arguments[0].equals("s"));
	}	
}
