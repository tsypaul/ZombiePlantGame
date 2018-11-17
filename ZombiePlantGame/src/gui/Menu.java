package gui;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Menu extends JPanel implements ActionListener{
	// this menu create a new instance every time you click to plant a plant
	private JLabel label = new JLabel("Add a plant");
	private String[] choices = {"Sunflower", "Peashooter", "Wallnut"};
	private JComboBox<String> jcb = new JComboBox<String>(choices);
	private JButton b = new JButton("Add");
	private int x, y;
	private JButton bt;
	private GameBoard gb;
	
	public Menu(int x, int y, JButton bt, GameBoard gb){
		this.gb = gb;
		this.add(label);
		this.add(jcb);
		this.add(b);
		this.x = x;
		this.y = y;
		this.bt = bt;
		b.addActionListener(this);
	}
	
	public void setPlant(String plant){
		if(String.valueOf(this.jcb.getSelectedItem()).equals(plant)){
			if(gb.sun >= gb.priceMap.get(plant)){
				if(gb.cdMap.get(plant) == 0){
					try{
						Image i = ImageIO.read(getClass().getResource(plant + ".png")).getScaledInstance(70, 70, Image.SCALE_DEFAULT);
						this.bt.setIcon(new ImageIcon(i));
						// after the plant is set, put this type of plant in cd use the final value for this type
						gb.cdMap.put(plant, gb.finalCDMap.get(plant));
						// update the number of suns after purchasing a plant
						gb.sun -= gb.priceMap.get(plant);
						gb.sunLabel.setText(gb.sun + "");
					}catch(IOException e){
						e.printStackTrace();
					}
					this.setVisible(false);
					//add plant model, if the plant is a peashooter, increment the number of peashooter in this row by 1
					System.out.println(x +" "+y);
					gb.po.add(new PlantObject(plant, x, y));
					if(plant.equals("Peashooter")){
						gb.peashooters[x]++;
					}
					
				}else{
					JOptionPane.showMessageDialog(null, plant+"is on cd");
				}
			}else{
				JOptionPane.showMessageDialog(null, "Cannot afford " + plant);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setPlant("Peashooter");
		setPlant("Sunflower");
		setPlant("Wallnut");
	}
	
}
