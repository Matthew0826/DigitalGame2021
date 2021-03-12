package Main;

public class CollisionBox{

	  private int x;
	  private int y;
	  private int height;
	  private int width;
	  private double rotation;
	  
	  public CollisionBox( int x, int y, int height, int width, double rotation ){
	    
	    this.x = x; this.y = y; this.height = height; this.width = width; this.rotation = rotation;
	    
	  }
	  
	  //checks if two lines 
	  public boolean linesCollide( int x1, int y1, int length1, double rotation1, int x2, int y2, int length2, double rotation2 ){
	     double slope1 = ( y1 - ( y1 + Math.cos( rotation1 ) * length1 ) ) / ( x1 - ( x1 + Math.sin( rotation1 )*length1 ) );
	     double slope2 = ( y2 - ( y2 + Math.cos( rotation2 ) * length2 ) ) / ( x2 - ( x2 + Math.sin( rotation2 )*length2 ) );
	    
	     double b1 = x1 - slope1 * y1;
	     double b2 = x2 - slope2 * y2;
	    
	     double xIntercept = ( b2 - b1 ) / ( slope1 - slope2 );
	     double yIntercept = slope1 * xIntercept + b1;
	    
	     double minX1 = ( x1 < ( x1 + Math.sin( rotation1 )*length1 ) )? x1 : ( x1 + Math.sin( rotation1 )*length1 );
	     double maxX1 = ( x1 > ( x1 + Math.sin( rotation1 )*length1 ) )? x1 : ( x1 + Math.sin( rotation1 )*length1 );
	     double minX2 = ( x2 < ( x2 + Math.sin( rotation2 )*length2 ) )? x2 : ( x2 + Math.sin( rotation2 )*length2 );
	     double maxX2 = ( x2 > ( x2 + Math.sin( rotation2 )*length2 ) )? x2 : ( x2 + Math.sin( rotation2 )*length2 );
	     
	     double minY1 = ( y1 < ( y1 + Math.cos( rotation1 )*length1 ) )? y1 : ( y1 + Math.cos( rotation1 )*length1 );
	     double maxY1 = ( y1 > ( y1 + Math.cos( rotation1 )*length1 ) )? y1 : ( y1 + Math.cos( rotation1 )*length1 );
	     double minY2 = ( y2 < ( y2 + Math.cos( rotation2 )*length2 ) )? y2 : ( y2 + Math.cos( rotation2 )*length2 );
	     double maxY2 = ( y2 > ( y2 + Math.cos( rotation2 )*length2 ) )? y2 : ( y2 + Math.cos( rotation2 )*length2 );
	    
	     if( xIntercept > minX1 && xIntercept < maxX1 && xIntercept > minX2 && xIntercept < maxX2
	        && yIntercept > minY1 && yIntercept < maxY1 && yIntercept > minY2 && yIntercept < maxY2 ){
	       return true;
	     }else{
	       return false;
	     }
	  }
	  
	  //this is disgusting
	  
	  //Checks each line of this box in left, top, right, bottom
	  public boolean[] checkCollisions( CollisionBox box ){                               
	    boolean[] returnBool = new boolean[4];
	    
	    returnBool[0] = linesCollide( x, y, height, rotation, box.getX(), box.getY(), box.getHeight(), box.getRotation() );
	    returnBool[1] = linesCollide( x, y, width, rotation, box.getX(), box.getY(), box.getWidth(), box.getRotation() );
	    returnBool[2] = linesCollide( (int)(x + Math.sin( rotation )*width), (int)(y + Math.cos( rotation )*width), height, rotation, 
	                                 box.getX() + (int)(Math.sin( box.getRotation() )*box.getWidth()), box.getY() + (int)(Math.cos( box.getRotation() )*box.getWidth()), 
	                                 box.getHeight(), box.getRotation() );
	    returnBool[3] = linesCollide( (int)( x + Math.sin( rotation ) ) * (int)( Math.sqrt( width * width + height * height ) ), 
	                                 (int)( y + Math.cos( rotation ) * Math.sqrt( width * width + height * height ) ), width, rotation,
	                                 (int)( box.getX() + Math.sin( box.getRotation() ) * Math.sqrt( box.getWidth() * box.getWidth() + box.getHeight() * box.getHeight() ) ),
	                                 (int)(box.getY() + Math.cos( box.getRotation() ) * Math.sqrt( box.getWidth() * box.getWidth() + box.getHeight() * box.getHeight() ) ),
	                                 box.getWidth(), box.getRotation() );
	    
	    return returnBool;
	   }
	   public void setX( int x ){ this.x = x; }
	   public void setY( int y ){ this.y = y; }
	   public void setHeight( int height ){ this.height = height; }
	   public void setWidth( int width ){ this.width = width; }
	   public void setRotation( int rotation ){ this.rotation = rotation; }
	                                
	   public int getX(){ return x; }
	   public int getY(){ return y; }
	   public int getWidth(){ return width; }
	   public int getHeight(){ return height; }
	   public double getRotation(){ return rotation; }
	}
