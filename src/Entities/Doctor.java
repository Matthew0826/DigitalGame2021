package Entities;

import javax.swing.ImageIcon;

import Blocks.Block;
import Main.Application;

public class Doctor extends Enemy{
	
	public static final String imageString = "images/entites/doctor/doctor0.png";
	public static final ImageIcon startingImage = new ImageIcon( imageString );
	private boolean onBlock = false;
	private boolean jumping = false;
	private boolean terminateX = false;
	private int collectedMoney;
	
	public Doctor( int x, int y ){
		super( x, y, startingImage.getImage() );
		setWidth(160);
		setHeight(380);
	}
	
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
	
	public void collidesWithBlock( Block[] blocks ) {
		onBlock = false;
		for( Block block : blocks ) {
			if( this.getCBox().collides( block.getCBox() )) {
				onBlock = true;
			}
		}
	}
	
	public void move() {
		if( !onBlock) {
			setDy( getDy() + .4 );
		}
		if( terminateX && onBlock ) { setDx( 0 ); }
		if ( onBlock && !jumping ) { setDy( 0 ); } 
		setX( getX() + getDx() );
		setY( getY() + getDy() );
	}
	
	
}