package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Queue;

import javax.swing.*;

public class StartMenu extends JPanel implements ActionListener{
	// start menu is a navigation menu on the top of this frame
	private JLabel l = new JLabel("Initialize game board 5*9");
	private JButton start = new JButton("Start");
	private JButton b = new JButton("Dig");
	private JLabel l1 = new JLabel("");
	private JLabel l2 = new JLabel("round: ");
	private JLabel round = new JLabel("0");
	private GameBoard gb;
	private ZombiePane z;
	protected int roundNumber;
	private ArrayList<PlantObject> po = new ArrayList<PlantObject>();
	private Hashtable<Integer, Queue<ZombieObject>>zList = new Hashtable<>();
	
	public StartMenu(GameBoard gb, ZombiePane z){
		this.po = gb.po;
		this.zList = z.zList;
		this.z = z;
		this.gb = gb;
		gb.setVisible(false);
		this.add(l);
		this.add(start);
		this.add(new JLabel("current sun: "));
		gb.sunLabel = new JLabel(gb.sun + " ");
		this.add(gb.sunLabel);
		l2.setVisible(false);
		this.add(l2);
		round.setVisible(false);
		this.add(round);
		start.addActionListener(this);
		start.addActionListener(z);
		this.add(b);
		this.add(l1);
		// add actionlistener for dig operation
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				gb.setDigOp(!gb.getDigOp());
				l1.setText(gb.getDigOp() ? "dig" : "");
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(this.round.getText().equals("0")){
			JButton b = (JButton)e.getSource();
			b.setText("next");
			this.l2.setVisible(true);
			this.round.setVisible(true);
			this.gb.setVisible(true);
		}
		// update round number and print it in console
		roundNumber = Integer.parseInt(this.round.getText()) + 1;
		this.round.setText(roundNumber +"");
		z.updateRound(roundNumber);
		System.out.println("current round: " + roundNumber);
		//update plant cd
		gb.updateCD();
		System.out.println("plant list size :" + gb.po.size());
		// update sun value
		gb.sun += 10;
		gb.sunLabel.setText(gb.sun+"");
		for(PlantObject p : gb.po){
			if(p.getName().equals("Sunflower")){
				gb.sun += 5;
				gb.sunLabel.setText(gb.sun+"");
			}
		}
	}

	
	
}
