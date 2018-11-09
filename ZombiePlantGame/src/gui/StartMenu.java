package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StartMenu extends JPanel implements ActionListener{

	private JLabel l = new JLabel("Initialize game board 5*9");
	private JButton start = new JButton("Start");
	private JButton b = new JButton("Dig");
	private JLabel l1 = new JLabel("");
	private JLabel l2 = new JLabel("round: ");
	private JLabel round = new JLabel("0");
	
	public StartMenu(GameBoard gb){
		this.add(l);
		this.add(start);
		this.add(l2);
		this.add(round);
		start.addActionListener(this);
		this.add(b);
		this.add(l1);
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
		JButton b = (JButton)e.getSource();
		b.setText("next");
		int roundNumber = Integer.parseInt(this.round.getText()) + 1;
		this.round.setText(roundNumber +"");
	}

	
	
}
