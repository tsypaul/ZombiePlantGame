package gui;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Menu extends JPanel implements ActionListener{

	private JLabel label = new JLabel("Add a plant");
	private String[] choices = {"Sunflower", "Peashooter", "Wallnut"};
	private JComboBox<String> jcb = new JComboBox<String>(choices);
	private JButton b = new JButton("Add");
	private int x, y;
	private JButton bt;
	
	public Menu(int x, int y, JButton bt){
		this.add(label);
		this.add(jcb);
		this.add(b);
		this.x = x;
		this.y = y;
		this.bt = bt;
		b.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(String.valueOf(this.jcb.getSelectedItem()).equals("Peashooter")){
			try {
				Image peashooter = ImageIO.read(getClass().getResource("Peashooter.png")).getScaledInstance(70, 70, Image.SCALE_DEFAULT);
				this.bt.setIcon(new ImageIcon(peashooter));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.setVisible(false);
			//add plant
		}
		if(String.valueOf(this.jcb.getSelectedItem()).equals("Sunflower")){
			try {
				Image sunflower = ImageIO.read(getClass().getResource("Sunflower.png")).getScaledInstance(70, 70, Image.SCALE_DEFAULT);
				this.bt.setIcon(new ImageIcon(sunflower));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.setVisible(false);
			// add plant
		}
		if(String.valueOf(this.jcb.getSelectedItem()).equals("Wallnut")){
			try {
				Image wallnut = ImageIO.read(getClass().getResource("Wallnut.png")).getScaledInstance(60, 70, Image.SCALE_DEFAULT);
				this.bt.setIcon(new ImageIcon(wallnut));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.setVisible(false);
			//add plant
		}
	}
	
}
