package Main;

public class CollisionBox{

	  private double x;
	  private double y;
	  private int height;
	  private int width;
	  
	  public CollisionBox( double x, double y, int height, int width ){
	    
	    this.x = x; this.y = y; this.height = height; this.width = width;
	    
	  }
	  
	  public boolean collides( CollisionBox otherBox ) {
		  boolean xIntersects = ( ( otherBox.getX() + otherBox.getWidth() >= x && otherBox.getX() <= x ) 
				  || ( otherBox.getX() + otherBox.getWidth() >= x + width && otherBox.getX() <= x + width ) );
		  boolean yIntersects = ( ( otherBox.getY() + otherBox.getHeight() >= y && otherBox.getY() <= y ) 
				  || ( otherBox.getY() + otherBox.getHeight() >= y + height && otherBox.getY() <= y + height ) );
		  
		  return ( xIntersects && yIntersects );
		  
	  }
	  //test
	   public void setX( double x ){ this.x = x; }
	   public void setY( double y ){ this.y = y; }
	   public void setHeight( int height ){ this.height = height; }
	   public void setWidth( int width ){ this.width = width; }
	                                
	   public double getX(){ return x; }
	   public double getY(){ return y; }
	   public int getWidth(){ return width; }
	   public int getHeight(){ return height; }
	}
