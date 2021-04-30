package Main;

import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.math.*;

import javax.swing.JFrame;

public class Application extends JFrame {
    
	private static double cWidth;
	private static double cHeight;
	private static final int dWIDTH = 1600; //1644
	private static final int dHEIGHT = 900; //925
	
    public Application() {

    	  add(new Board());
    	  
    	  
    	 
          setSize(800, 800);
    	  setResizable(true);
          setTitle("Digital Game 2021");
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setLocationRelativeTo(null);
         
          addComponentListener(new ComponentAdapter() {
              public void componentResized(ComponentEvent evt) {
                  Component c = (Component)evt.getSource();
                  
                  cWidth = c.getWidth();
                  cHeight = c.getHeight();
                  
                  if(c.getWidth() > 800 || c.getWidth() < 800) 
                  {
                  System.out.println("width = " + c.getWidth());
                  }
                  
                  if(c.getHeight() > 800 || c.getHeight() < 800) 
                  {
                  System.out.println("height = " + c.getHeight());
                  }
              }
          });
    }
    
    public static double getWindowWidth() {
    	return cWidth;
    }
    
    public static double getWindowHeight() {
    	return cHeight;
    }
    
    public static int scaleX(int x) {
    	double scale = 1;
    	scale = (x/dWIDTH) * getWindowWidth();
    	return (int) scale;
    }
    
    public static int scaleY(int y) {
    	double scale = 1;
    	scale = (y/dHEIGHT) * getWindowHeight();
    	return (int) scale;
    }

    public static void main(String[] args) {
        
    	Application ex = new Application();
        ex.setVisible(true);
    }
}
//if(dWIDTH > x) {
//	scale = getWindowWidth() / (dWIDTH / x);
//}else if (dWIDTH < x) {
//	scale = (x/dWIDTH) * getWindowWidth();
//}