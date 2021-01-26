package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import Entities.Player;

public class Board extends JPanel implements ActionListener{
	
	private Player player = new Player( 100, 20 );
    private Timer timer;
    private final int DELAY = 10;
	
	public Board() {
		
		addKeyListener( new TAdapter() );
		setBackground(Color.black);
		setFocusable(true);
		
        timer = new Timer(DELAY, this);
        timer.start();
		
	}
	
	@Override
    public void actionPerformed(ActionEvent e) { 
    	player.move();
    	repaint( );
    }
	@Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		player.draw( g2d );
		
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
