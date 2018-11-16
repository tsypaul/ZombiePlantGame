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
	
	private JButton[][] btn = new JButton[9][5];
	private int x, y;
	private boolean isDigOp;
	final int sfcd = 1, pscd = 2, wncd = 2;
	JLabel sunLabel;
	int sun = 50;
	HashMap<String, Integer> priceMap = new HashMap<String, Integer>();
	HashMap<String, Integer> cdMap = new HashMap<String, Integer>();
	HashMap<String, Integer> finalCDMap = new HashMap<String, Integer>();
	ArrayList<PlantObject> po = new ArrayList<PlantObject>();
	

	public GameBoard(){
		this.finalCDMap.put("Sunflower", sfcd);
		this.finalCDMap.put("Peashooter", pscd);
		this.finalCDMap.put("Wallnut", wncd);
		this.cdMap.put("Sunflower", 0);
		this.cdMap.put("Peashooter", 0);
		this.cdMap.put("Wallnut", 0);
		this.priceMap.put("Sunflower", 10);
		this.priceMap.put("Peashooter", 20);
		this.priceMap.put("Wallnut", 20);
		this.isDigOp = false;
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		this.setPreferredSize(new Dimension(810, 450));
		for (x=0; x<9; x++) {
            for (y=0; y<5; y++) {
            	btn[x][y] = new JButton();
            	btn[x][y].setPreferredSize(new Dimension(90, 90));
            	btn[x][y].setLocation(90*x, 90*y);
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton clicked = (JButton)e.getSource();
		if(clicked.getIcon() == null && !isDigOp){
			Menu m = new Menu(x, y, clicked, this);
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
