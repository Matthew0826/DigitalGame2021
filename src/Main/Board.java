package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import Blocks.Block;
import Entities.Player;
import Entities.Doctor;

public class Board extends JPanel implements ActionListener{
	
	private Player player = new Player( 100, 20 );
	private Doctor doctor = new Doctor(400, 20);
	private Block[] blocks = new Block[20];
    private Timer timer;
    private final int DELAY = 10;
	
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
    	player.move();
    	repaint();
    	if (player.getX() > doctor.getX()) {
			doctor.setDx(2.5);
			if (player.getCBox().getX() + 200 == doctor.getCBox().getX() + 200) {
				doctor.setDx(0);
			}
			doctor.move();
			repaint();
		}
    	
		if (player.getX() < doctor.getX()) {
			doctor.setDx(-2.5);
			if (player.getCBox().getX() + 200 == doctor.getCBox().getX() + 200) {
				doctor.setDx(0);
			doctor.move();
			repaint();
		}
    }
	
	
	@Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon lyr0 = new ImageIcon( "images/background/layer0.png" );
		ImageIcon lyr1 = new ImageIcon( "images/background/layer1.png" );
		Image layer0 = lyr0.getImage();
		Image layer1 = lyr1.getImage();
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage( layer0, 0, 0, 2000, 1000, null );
		g2d.drawImage( layer1, 0, 0, 2000, 1000,null );
		for( int i = 0; i < blocks.length; i++ ) { blocks[i].draw( g2d ); }
		player.draw( g2d );
		doctor.draw(g2d);
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
