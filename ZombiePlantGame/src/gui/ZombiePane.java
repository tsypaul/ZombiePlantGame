package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ZombiePane extends JPanel implements ActionListener{
	
	private Image zombie;
	private int row1;
	private int round = 0;
	private ArrayList<ZombieObject> zList = new ArrayList<ZombieObject>();
	
	public ZombiePane(){
		this.setOpaque(false);
		try {
			zombie = ImageIO.read(getClass().getResource("Zombie.png")).getScaledInstance(50, 90, Image.SCALE_DEFAULT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void updateRound(int round){
		this.round = round;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(ZombieObject z : this.zList){
			// for all the zombie icon in zList, draw the icon on the pane
			z.checkStatus();
			g.drawImage(z.getZ(), z.getX(), z.getY(), null);
		}
	}
	
	public void actionPerformed(ActionEvent e){
		// release zombie every 5 rounds in a random row
		if(this.round % 5 == 0 && this.round != 0){
			Random r = new Random();
			// for loop randomly generate number of zombies
			for(int i=0; i < r.nextInt(4) + 1; i++){
				// choose a random row number to deploy the current zombie
				this.row1 = r.nextInt(5);
				ZombieObject zo = new ZombieObject(zombie, 40+row1*90, 50);
				System.out.println("added zombie");
				zList.add(zo);
			}
		}
		for(ZombieObject z : this.zList){
			z.setX(z.getX() - z.getSpeed());
			z.updateHealth(20);
		}
		this.paintComponent(this.getGraphics());
		this.setVisible(true);
		this.repaint();
	}
	
}
