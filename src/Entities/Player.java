package Entities;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import Blocks.Block;

public class Player extends Ally{

	private static int image = 0;
	public static String imageString = "images/entites/player/image" + image + ".png";
	public static ImageIcon startingImage = new ImageIcon( imageString );
	private boolean onBlock = false;
	private boolean jumping = false;
	private boolean terminateX = false;
	
	public Player( int x, int y ){
		super( x, y, startingImage.getImage() );
		setWidth( 200 );
		setHeight( 400 );
    }
	
	public void collidesWithBlock( Block[] blocks ) {
		onBlock = false;
		for( Block block : blocks ) {
			if( this.getCBox().collides( block.getCBox() )) {
				onBlock = true;
			}
		}
	}
	
	@Override
	public void move() {
		if( terminateX && onBlock ) { setDx( 0 ); }
		setDy( getDy() + .4 );
		if ( onBlock && !jumping ) { setDy( 0 ); } 
		setDy( getDy() + .3 );
		if( getY() + getHeight() - 50 >= 925 && getDy() > 0) {
			setDy( 0 );
		}
		setX( getX() + getDx() );
		setY( getY() + getDy() );
		if( getDx() != 0 || getDy() != 0 ) {
			image = 1;
		}else {
			image = 0;
		}
		imageString = "images/entites/player/image" + image + ".png";
		startingImage = new ImageIcon( imageString );
		setImage( startingImage.getImage() );
	}
	
	//Test Comment
	
	public void keyPressed( KeyEvent e ) {
		
		int key = e.getKeyCode();
       	jumping = false;

        if (key == KeyEvent.VK_LEFT && onBlock) {
        	setDx( -5 );
        	terminateX = false;
        }else if (key == KeyEvent.VK_RIGHT && onBlock) {
        	 setDx( 5 );
        	 terminateX = false;
        }

        if (key == KeyEvent.VK_UP && onBlock) {
        	setDy( -10 );
        	jumping = true;
        }
	}
	
	public void keyReleased( KeyEvent e ) {
		int key = e.getKeyCode();
       	jumping = false;
       	if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT ) {
       		terminateX = true;
       	}
       

	}
}