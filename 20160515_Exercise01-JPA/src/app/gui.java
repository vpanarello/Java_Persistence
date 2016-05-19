/**
 * 
 */
package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entity.Clientes;

/**
 * 20160515-JPA_Exercice01 / gui.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class gui {
	

	
	static JFrame f;
	static JPanel p;
	static JButton b01;
	static JButton b02;
	static JLabel label;
	
	
	public gui() {
		super();
		
		this.buildFrame();
		
		
		
	}
	
	
	
	private void buildFrame(){
		f = new JFrame("Cadastro de Clientes");
		f.setVisible(true);
		f.setSize(600, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		p = new JPanel(new GridBagLayout());
		p.setBackground(Color.YELLOW);
		
		b01 = new JButton("Botão 1");
		b02 = new JButton("Botão 2");
		
		GridBagConstraints c = new GridBagConstraints();
		
		
		c.insets = new Insets(5, 5, 5, 5); // distancia entre componetes (pixels)
		c.gridx = 1;
		c.gridy = 0;
		p.add(b01, c);
		
		c.gridx = 2;
		c.gridy = 0;
		p.add(b02, c);
		
		label = new JLabel("Nova Label");
		
		c.gridx = 1;
		c.gridy = -1;
		p.add(label,c);
		
		f.add(p, BorderLayout.EAST);
		
//		System.out.println("Opened GUI");
	}
	
	
	
	
	
	
	

}
