package gui;

import java.awt.Image;

public class ZombieObject {
	
	private Image z;
	private int x = 810, y, speed;
	private int checkX, health;

	public ZombieObject(Image z, int y, int speed){
		this.z = z;
		this.y = y;
		this.speed = speed;
		this.checkX = 765;
		this.health = 150;
	}

	public Image getZ() {
		return z;
	}

	public void setZ(Image z) {
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}
	
	public int calculateRow(){
		// (y coordinate of the image - height of the menu bar)/height of the component + 1
		return (y - 40)/90 + 1;
	}
	
	public int getCheckX(){
		return this.checkX;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public int getHealth(){
		return this.health;
	}
	
	public void updateHealth(int health){
		// peashooter deals damage to zombie
		this.health -= health;
	}
	
	public boolean checkDead(){
		// check if a plant is dead, if dead, remove it.
		if(this.health < 0){
			this.z = null;
			return true;
		}
		return false;
	}
	
	public void updateCheckX(){
		// check if a block has plant
		if(this.x < this.checkX){
			this.checkX -= 90;
		}
	}

	public int getNextCheckCol(){
		// check next possible position for plant
		return this.checkX/90;
	}
}
