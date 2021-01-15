package Entities;

import java.awt.Image;
import java.awt.event.KeyEvent;

public class Player extends Ally{

	public Player( int x, int y, Image i ){
		super( x, y, i );
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
}
