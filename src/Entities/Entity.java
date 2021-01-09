package Entities;

import java.awt.Image;

public abstract class Entity {
	
	private int x;
	private int y;
	
	private int dx;
	private int dy;
	
	private Image image;
	
	public Entity( int x, int y, Image image ){
		this.x = x;
		this.y = y;
		this.image = image;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	//test
	
	public void setX( int x ) {
		this.x = x;
	}
	public void setY( int y ) {
		this.y = y;
	}
	
	
	
	public int getDx() {
		return dx;
	}
	public int getDy() {
		return dy;
	}
	
	public void setDx( int dx ) {
		this.dx = dx;
	}
	public void setDy( int dy ) {
		this.dy = dy;
	}
	
	public void move() {
		x += dx;
		y += dy;
	}
	
	
	public Image getImage() {
		return image;
	}
	
	public void setImage( Image i ) {
		image = i;
	}
	
}
