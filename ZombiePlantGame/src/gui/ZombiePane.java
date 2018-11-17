package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ZombiePane extends JPanel implements ActionListener{
	// this jpanel paint zombie on glasspane which is on top of gameboard
	private Image zombie;
	private int row1;
	private int round = 0;
	private GameBoard gb;
	// map row number with a queue of zombies
	Hashtable<Integer, Queue<ZombieObject>>zList = new Hashtable<>();
	
	public ZombiePane(GameBoard gb){
		this.gb = gb;
		for(int i = 1; i < 6; i++){
			//initialize zombie list
			zList.put(i, new LinkedList<ZombieObject>());
		}
		this.setOpaque(false);
		try {
			// set zombie image
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
		// paint zombie list
			for(int i : this.zList.keySet()){
				Queue<ZombieObject> q = this.zList.get(i);
				if(!q.isEmpty()){
					for(ZombieObject z : q){
						g.drawImage(z.getZ(), z.getX(), z.getY(), null);
					}
				}
			}

	}
	
	public void actionPerformed(ActionEvent e){
		// release zombie every 5 rounds in a random row
		if(this.round % 5 == 0 && this.round != 0){
			Random r = new Random();
			// for loop randomly generate number of zombies
			for(int i=0; i < r.nextInt(4) + 1; i++){
				// choose a random row number to deploy the current zombie
				// there might be multiple zombies generated on the same row
				this.row1 = r.nextInt(5) + 1;
				ZombieObject zo = new ZombieObject(zombie, row1*90 - 50, 45);
				System.out.println("added zombie at row " + row1);
				zList.get(row1).add(zo);
			}
		}
		for(int i : this.zList.keySet()){
			Queue<ZombieObject> q = this.zList.get(i);
			// iterate through zombie list
			if(!q.isEmpty()){
				// damage to zombie
				q.peek().updateHealth(30*gb.getPeashooterNumber(i));
				if(q.peek().checkDead()){
					// if the first zombie in a queue is dead, remove this zombie from the queue
					q.remove();
				}
				for(ZombieObject z : q){
					System.out.println("Zombie health: "+z.getHealth()+" current row peashooter: "+gb.getPeashooterNumber(i) + " current row:" + z.calculateRow());
					System.out.println("Next check position: "+ i +" " +z.getNextCheckCol());
					// move zombie in the pane
					z.setX(z.getX() - z.getSpeed());
					JButton nextCheckBtn = gb.btn[i - 1][z.getNextCheckCol()];
					if(nextCheckBtn.getIcon() != null){
						// if next check position contains icon, zombie starts to eat plant
						for(PlantObject p : gb.po){
							if(p.getX() == (i - 1) && p.getY() == z.getNextCheckCol()){
								p.damage();
								System.out.println("plant health: "+p.getHealth());
							}
							if(p.checkDead()){
								// if a plant is dead, remove its icon and Object model, update peashooters array
								if(p.getName().equals("Peashooter")){
									gb.peashooters[i - 1] --;
								}
								gb.po.remove(p);
								nextCheckBtn.setIcon(null);
							}else{
								z.setX(z.getCheckX());
							}
						}
					}
					// update next position to check if there is a plant
					z.updateCheckX();
					if(z.getX() < 0){
						// if a zombie reaches 0 position, game is over
						JOptionPane.showMessageDialog(null, "game over, you lost");
						System.exit(0);
					}
				}
			}
		}
		// paint zombies
		this.paintComponent(this.getGraphics());
		this.setVisible(true);
		this.repaint();
	}
	
}
