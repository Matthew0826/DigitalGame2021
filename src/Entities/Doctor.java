package Entities;

import javax.swing.ImageIcon;

public class Doctor extends Enemy{
	
	public static final String imageString = "images/entites/doctor/doctor0.png";
	public static final ImageIcon startingImage = new ImageIcon( imageString );
	    
	public Doctor( int x, int y ){
		super( x, y, startingImage.getImage() );
	}

	@Override
	public void trackAlly(Ally ally) {
		
	}

}
