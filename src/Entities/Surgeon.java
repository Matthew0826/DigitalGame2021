package Entities;

import javax.swing.ImageIcon;

public class Surgeon extends Enemy{

	public static final String imageString = "images/entites/surgeon/surgeon0.png";
	public static final ImageIcon startingImage = new ImageIcon( imageString );
	    
	public Surgeon( int x, int y ){
		super( x, y, startingImage.getImage() );
		setWidth(200);
		setHeight(400);
	}

	@Override
	public void trackAlly(Ally ally) {
		
	}
	  
}
