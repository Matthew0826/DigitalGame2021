package Entities;

import javax.swing.ImageIcon;

import Blocks.Block;
import Main.Application;

public class Surgeon extends Enemy{

	public static final String imageString = "images/entites/surgeon/surgeon0.png";
	public static final ImageIcon startingImage = new ImageIcon( imageString );
	private Boolean onBlock = false;  
	private boolean jumping = false;
	private boolean terminateX = false;
	
	public Surgeon( int x, int y ){
		super( x, y, startingImage.getImage() );
		setWidth(250);
		setHeight(550);
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
