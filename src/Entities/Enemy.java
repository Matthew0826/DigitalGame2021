package Entities;

import java.awt.Image;

public abstract class Enemy extends Entity{

	public Enemy( int x, int y, Image image ){
		super( x, y, image );	
	}
	public abstract void trackAlly( Ally ally );
}