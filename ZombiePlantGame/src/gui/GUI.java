package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI extends JFrame{
	
	public GUI(String title){
		super(title);
		setLayout(new BorderLayout());
	}

	public static void main(String[] args){
		JFrame game = new GUI("Zombie Plant Game");
		GameBoard gb = new GameBoard();
		game.add(new StartMenu(gb), BorderLayout.NORTH);
		game.add(gb, BorderLayout.CENTER);
		
		
		
		game.setDefaultCloseOperation(game.EXIT_ON_CLOSE);
		game.setSize(810, 800);
		game.setVisible(true);
	}
	
}
