package Entities;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import Main.CollisionBox;
//Dan's Github works!!!
//Tickity tackity
//egg
public abstract class Entity {
	
	private double x;
	private double y;
	
	private double dx;
	private double dy;
	
	private int width;
	private int height;
	
	private Image image;
	
	private CollisionBox cBox;
	
	public Entity( int x, int y, Image image ){
		this.x = x;
		this.y = y;
		this.image = image;
		cBox = new CollisionBox( x, y, height, width );
	}

	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	
	//test
	
	public void setX( double x ) {
		this.x = x;
	}
	public void setY( double y ) {
		this.y = y;
	}
	
	public CollisionBox getCBox() {
		return cBox;
	}
	
	
	public double getDx() {
		return dx;
	}
	public double getDy() {
		return dy;
	}
	
	public void setDx( double dx ) {
		this.dx = dx;
		cBox.setX( x );
	}
	public void setDy( double dy ) {
		this.dy = dy;
		cBox.setY( y );
	}
	
	public void setWidth( int width ) { this.width = width; cBox.setWidth(width); }
	public void setHeight( int height ) { this.height = height; cBox.setHeight(height); }
	
	public int getHeight() { return height; }
	
	public void move() {
		x += dx;
		y += dy;
		cBox.setX( x );
		cBox.setY( y );
	}
	
	
	public Image getImage() {
		return image;
	}
	
	public void setImage( Image i ) {
		image = i;
	}
	
	public void draw( Graphics g ) {
		g.drawImage( image, (int)x, (int)y, width, height, null );
	}
	
}
