package Entities;

import javax.swing.ImageIcon;

public class Doctor extends Enemy{
	
	public static final String imageString = "images/entites/doctor/doctor0.png";
	public static final ImageIcon startingImage = new ImageIcon( imageString );
	
	private int collectedMoney;
	
	public int getCollectedMoney() {
		return collectedMoney;
	}
	
	public void setCollectedMoney(int c) {
		collectedMoney = collectedMoney + c;
	}
	
	public void trackHarmedEnemy(Enemy enemy) {
		//I think?
	}
	    
	public Doctor( int x, int y ){
		super( x, y, startingImage.getImage() );
	}

	@Override
	public void trackAlly(Ally ally) {
		
	}
// Just checking if github works
}
