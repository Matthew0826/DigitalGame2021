package Blocks;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Block {

	private int x;
	private int y;
	
	public Block( int x, int y ) {
		this.x = x;
		this.y = y;
		
	}
	
	public void draw( Graphics2D g ) {
		ImageIcon icon = new ImageIcon( "images/blocks/grass.png");
		Image image = icon.getImage();
	    g.drawImage(image, x, y, 100, 100, null);

	}
	
}
