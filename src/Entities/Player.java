package Entities;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player extends Ally{

	private static int image = 0;
	public static String imageString = "images/entites/player/image" + image + ".png";
	public static ImageIcon startingImage = new ImageIcon( imageString );
	
	public Player( int x, int y ){
		super( x, y, startingImage.getImage() );
		setWidth( 200 );
		setHeight( 400 );
    }
	
	@Override
	public void move() {
		setDy( getDy() + .1 );
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
	
	public void keyPressed( KeyEvent e ) {
		
		int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
        	if( getY() + getHeight() - 50 >= 925 ) {
                setDx( -5 );
        	}
        }

        if (key == KeyEvent.VK_RIGHT) {
        	if( getY() + getHeight() - 50 >= 925 ) {
                setDx( 5 );
        	}
        }

        if (key == KeyEvent.VK_UP) {
        	if( getY() + getHeight() - 50 >= 925 ) {
                setDy( -10 );
        	}

        }

	}
	
	public void keyReleased( KeyEvent e ) {
		int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
        	if( getY() + getHeight() - 50 >= 925 ) {
                setDx( 0 );
        	}
        }

        if (key == KeyEvent.VK_RIGHT) {
        	if( getY() + getHeight() - 50 >= 925 ) {
                setDx( 0 );
        	}
        }
	}
}
