package Entities;

import javax.swing.ImageIcon;

public class Surgeon extends Enemy{

	public static final String imageString = "";
	public static final ImageIcon startingImage = new ImageIcon( imageString );
	    
	public Surgeon( int x, int y ){
		super( x, y, startingImage.getImage() );
	}

	@Override
	public void trackAlly(Ally ally) {
		
	}
	  
}
