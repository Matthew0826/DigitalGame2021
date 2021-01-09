package Main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener{

	public Board() {
		
		addKeyListener( new TAdapter() );
		
	}
	
	@Override
    public void actionPerformed(ActionEvent e) { 
        
    }
	@Override
    public void paintComponent(Graphics g) {

    }
	
	private class TAdapter extends KeyAdapter{
		
	}
	
}
