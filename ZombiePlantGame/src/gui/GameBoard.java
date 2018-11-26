package gui;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

public class GameBoard extends JPanel implements ActionListener{
	// gameboard is where the plants are planted implemented as buttons
	JButton[][] btn = new JButton[5][9];
	private int x, y;
	private boolean isDigOp;
	final int sfcd = 1, pscd = 2, wncd = 2;
	int[] peashooters;
	JLabel sunLabel;
	int sun = 50;
	HashMap<String, Integer> priceMap = new HashMap<String, Integer>();
	HashMap<String, Integer> cdMap = new HashMap<String, Integer>();
	HashMap<String, Integer> finalCDMap = new HashMap<String, Integer>();
	ArrayList<PlantObject> po = new ArrayList<PlantObject>();
	

	public GameBoard(){
		// initialize all the hashmaps
		this.finalCDMap.put("Sunflower", sfcd);
		this.finalCDMap.put("Peashooter", pscd);
		this.finalCDMap.put("Wallnut", wncd);
		this.cdMap.put("Sunflower", 0);
		this.cdMap.put("Peashooter", 0);
		this.cdMap.put("Wallnut", 0);
		this.priceMap.put("Sunflower", 10);
		this.priceMap.put("Peashooter", 30);
		this.priceMap.put("Wallnut", 30);
		this.isDigOp = false;
		this.peashooters = new int[]{0, 0 ,0, 0, 0};
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		this.setPreferredSize(new Dimension(810, 450));
		for (x=0; x<5; x++) {
            for (y=0; y<9; y++) {
            	// initalize button array for plants
            	btn[x][y] = new JButton();
            	btn[x][y].setPreferredSize(new Dimension(90, 90));
            	btn[x][y].setLocation(90*x, 90*y);
            	btn[x][y].setIcon(null);
            	this.add(btn[x][y]);
            	btn[x][y].addActionListener(this);
            }
        }
	}
	
	public void updateCD(){
		for(String s : cdMap.keySet()){
			if(cdMap.get(s) != 0){
				// if cd has not reached 0 yet, increment by 1
				cdMap.put(s, cdMap.get(s) - 1);
			}
		}
	}
	
	public boolean getDigOp(){
		return this.isDigOp;
	}
	
	public void setDigOp(boolean dig){
		this.isDigOp = dig;
	}
	
	public int getPeashooterNumber(int row){
		return this.peashooters[row - 1];
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton clicked = (JButton)e.getSource();
		int a = 0, b = 0;
		for(x=0; x<5; x++){
			for(y=0; y<9; y++){
				if(clicked.equals(btn[x][y])){
					a = x;
					b = y;
				}
			}
		}
		if(clicked.getIcon() == null && !isDigOp){
			// add new menu to add plant while is not in dig option
			Menu m = new Menu(a, b, clicked, this);
			m.setVisible(true);
			this.add(m);
			for(Component c : this.getComponents()){
				if(c.getClass().equals(m.getClass())){
					this.remove(c);
					this.add(m);
					if(this.getComponentCount() > 46){
						return;
					}
				}
			}
			this.revalidate();
			this.repaint();
		}else if(clicked.getIcon() != null && isDigOp){
			clicked.setIcon(null);
		}else{
			return;
		}
	}

}
