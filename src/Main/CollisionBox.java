package Main;

public class CollisionBox{

	  private int x;
	  private int y;
	  private int height;
	  private int width;
	  
	  public CollisionBox( int x, int y, int height, int width ){
	    
	    this.x = x; this.y = y; this.height = height; this.width = width;
	    
	  }
	  
	  public boolean collides( CollisionBox otherBox ) {
		  
		  boolean xIntersects = ( otherBox.getX() + otherBox.getWidth() > x && x + width > otherBox.getX() );
		  boolean yIntersects = ( otherBox.getY() + otherBox.getHeight() > y && y + height > otherBox.getY() );
		  
		  return ( xIntersects && yIntersects );
		  
	  }
	  //test
	   public void setX( int x ){ this.x = x; }
	   public void setY( int y ){ this.y = y; }
	   public void setHeight( int height ){ this.height = height; }
	   public void setWidth( int width ){ this.width = width; }
	                                
	   public int getX(){ return x; }
	   public int getY(){ return y; }
	   public int getWidth(){ return width; }
	   public int getHeight(){ return height; }
	}
