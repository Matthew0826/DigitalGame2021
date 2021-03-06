package Main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import Blocks.Block;
import Entities.Player;
import Entities.Surgeon;
import Entities.Doctor;
import Main.Application;

public class Board extends JPanel implements ActionListener{
	
	private Player player = new Player( 100, 20 );
	private Doctor doctor = new Doctor(400, 20);
	private Surgeon surgeon = new Surgeon(100, 20);
	private Block[] blocks = new Block[20];
	
    private Timer timer;
    private final int DELAY = 10;
    
    private boolean SurgeonAlive = false;
    private boolean playerAlive = true;
    
	public Board() {
		
		for( int i = 0; i < blocks.length; i++ ) {
			blocks[i] = new Block( 100 * i, 925 );
		}
		addKeyListener( new TAdapter() );
		setBackground(Color.black);
		setFocusable(true);
		
        timer = new Timer(DELAY, this);
        timer.start();
		
	}
	
	@Override
    public void actionPerformed(ActionEvent e) { 
		
		player.collidesWithBlock(blocks);
		doctor.collidesWithBlock(blocks);
		surgeon.collidesWithBlock(blocks);
		playercollidesWithDoctor();
		
    	if (playerAlive) {player.move();}
    	DoctorMoveSet();
    	doctor.move();
    	surgeon.move();
    	
    	repaint();
    }
	
	
	@Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		ImageIcon lyr0 = new ImageIcon( "images/background/layer0.png" );
		ImageIcon lyr1 = new ImageIcon( "images/background/layer1.png" );
		Image layer0 = lyr0.getImage();
		Image layer1 = lyr1.getImage();
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage( layer0, 0, 0, Application.scaleX(2000), Application.scaleY(1000), null );
		g2d.drawImage( layer1, 0, 0, Application.scaleX(2000), Application.scaleY(1000), null );
		
		for( int i = 0; i < blocks.length; i++ ) { blocks[i].draw( g2d ); }
		if (playerAlive) {player.draw( g2d );}
		doctor.draw(g2d);
		surgeon.draw(g2d);
		
    }
	
	private void DoctorMoveSet() {
		
		if ((player.getX() >= (doctor.getX() - 300)) && (player.getX() <= (doctor.getX() + 300))) {
			
			if (player.getX() == doctor.getX()) {
	    		doctor.setDx(0);
	    	} 
			
			if (player.getX() < doctor.getX()) {
	    		doctor.setDx(-2.5);
	    	}
			
	    	if (player.getX() > doctor.getX()) {
	    		doctor.setDx(2.5);
	    	}
	    		
	    	if ((player.getX() <= (doctor.getX() - 300)) || (player.getX() >= (doctor.getX() + 300))) {
	    		doctor.setDx(0);
	    	}

	    	if (!playerAlive) {
	    		doctor.setDx(0);
	    	}
		}
	}
	
	private void SurgeonMove() {
		
		while (SurgeonAlive) {
			surgeon.setDx(3);	
		}	
	}
	
	private void playercollidesWithDoctor() {
		if( player.getCBox().collides(doctor.getCBox() )) {
			player.setDx(0);
			player.setDy(0);
			playerAlive = false;
		}
		if( player.getWhipBox().collides(doctor.getCBox() )) {
			doctor.setX( 10000 );
			doctor.getCBox().setX( 10000 );
		}
	}
	
	private class TAdapter extends KeyAdapter{
		@Override
        public void keyReleased(KeyEvent e) {
			player.keyReleased( e );
        }

        @Override
        public void keyPressed(KeyEvent e) {
        	player.keyPressed( e );
        }
	}
	
}
