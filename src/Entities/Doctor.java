package Entities;

import javax.swing.ImageIcon;

import Entities.Player;

public class Doctor extends Enemy{
	
	public static final String imageString = "images/entites/doctor/doctor0.png";
	public static final ImageIcon startingImage = new ImageIcon( imageString );
	
	public Doctor( int x, int y ){
		super( x, y, startingImage.getImage() );
		setWidth(200);
		setHeight(400);
	}
	
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
	    

	@Override
	public void trackAlly(Ally ally) {
		
	}
	
	public void move() {
		setDy( getDy() + .1 );
		if( getY() + getHeight() - 50 >= 925 && getDy() > 0) {
			setDy( 0 );
		}
		setX( getX() + getDx() );
		setY( getY() + getDy() );
	}
	
	
// Just checking if github works
}
