package Entities;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import Blocks.Block;
<<<<<<< HEAD
import Main.CollisionBox;
=======
import Main.Application;
>>>>>>> branch 'master' of https://github.com/Matthew0826/DigitalGame2021.git

public class Player extends Ally{

	private static int image = 0;
	public static String imageString = "images/entites/player/image" + image + ".png";
	public static ImageIcon startingImage = new ImageIcon( imageString );
	private static CollisionBox whipBox;
	private boolean onBlock = false;
	private boolean jumping = false;
	private boolean terminateX = false;
	
	private int whipValue = 100;
	private int whipWaitCounter = 0;
	
	private boolean attack = false;
	
	public Player( int x, int y ){
		super( x, y, startingImage.getImage() );
<<<<<<< HEAD
		setWidth( 160 );
		setHeight( 380 );
		whipBox = new CollisionBox( x + 160, y, 100, 380 );
=======
		setWidth( 200 );
		setHeight( 400 );
>>>>>>> branch 'master' of https://github.com/Matthew0826/DigitalGame2021.git
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
		if( !onBlock) {
			setDy( getDy() + .4 );
		}
		if( terminateX && onBlock ) { setDx( 0 ); }
		if ( onBlock && !jumping ) { setDy( 0 ); } 
		setX( getX() + getDx() );
		setY( getY() + getDy() );
		if( getDx() != 0 || getDy() != 0 ) {
			image = 1;
		}else {
			image = 0;
		}
		
		if( !attack || whipWaitCounter != 0  ) {
			if( whipValue < 100 ) { whipValue++; }
			imageString = "images/entites/player/image" + image + ".png";
			startingImage = new ImageIcon( imageString );
			setImage( startingImage.getImage() );		
		}else if( whipValue > 0) {
			whipValue --;
        	ImageIcon i = new ImageIcon("images/entites/player/whip0.png");
        	setImage( i.getImage() );
        	
        	whipBox = new CollisionBox( getX() - 160, getY(), 100, 380 );
		}else {
			attack = false;
			whipWaitCounter = 100;
		}
		
		if( whipWaitCounter != 0 ) { whipWaitCounter--; }
		
        System.out.println( whipValue );

		
	}
	
	public CollisionBox getWhipBox() {
		if( attack ) {
			return whipBox;
		}else {
			return new CollisionBox( 0, 0, 0, 0 );
		}
	}
	
	
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
        
        if (key == KeyEvent.VK_A ) {
        	if( whipValue > 0 ) {
            	attack = true;
        	}else {
        	attack = false;
        	}
        }
        
        if( key == KeyEvent.VK_D ) {

        	attack = false;
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