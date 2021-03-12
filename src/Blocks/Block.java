package Blocks;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import Main.CollisionBox;

public class Block {

	private int x;
	private int y;
	
	private CollisionBox cBox;
	
	public Block( int x, int y ) {
		this.x = x;
		this.y = y;
		
		cBox = new CollisionBox( x, y, 100, 100 );
		
	}
	
	public void draw( Graphics2D g ) {
		ImageIcon icon = new ImageIcon( "images/blocks/grass.png");
		Image image = icon.getImage();
	    g.drawImage(image, x, y, 100, 100, null);

	}
	
	public CollisionBox getCBox() {
		return cBox;
	}
	
}
