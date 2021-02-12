package Main;

import javax.swing.JFrame;

public class Application extends JFrame {
    
    public Application() {

    	  add(new Board());

    	  //test
          setSize(800, 800);

          setTitle("Digital Game 2021");
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        
    	Application ex = new Application();
        ex.setVisible(true);
    }
}
