package Entities;

import javax.swing.ImageIcon;

public class Doctor extends Enemy{
	
	public static final String imageString = "images/entites/doctor/doctor0.png";
	public static final ImageIcon startingImage = new ImageIcon( imageString );
	
	private int collectedMoney;
	
	public int getCollectedMoney() {
		return collectedMoney;
	}
	
	public int setCollectedMoney(int c) {
		return collectedMoney + c;
	}
	// Dan made a comment
	
	public void trackHarmedEnemy(Eneny enemy) {
		//I think?
	}
	    
	public Doctor( int x, int y ){
		super( x, y, startingImage.getImage() );
	}

	@Override
	public void trackAlly(Ally ally) {
		
	}

}
