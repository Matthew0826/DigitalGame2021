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
            setDx( -2 );
        }

        if (key == KeyEvent.VK_RIGHT) {
            setDx( 2 );
        }

        if (key == KeyEvent.VK_UP) {
            setDy( -2 );
        }

        if (key == KeyEvent.VK_DOWN) {
            setDy( 2 );
        }
	}
	
	public void keyReleased( KeyEvent e ) {
		int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            setDx( 0 );
        }

        if (key == KeyEvent.VK_RIGHT) {
            setDx( 0 );
        }

        if (key == KeyEvent.VK_UP) {
           setDy( 0 );
        }

        if (key == KeyEvent.VK_DOWN) {
            setDy( 0 );
        }
	}
}
