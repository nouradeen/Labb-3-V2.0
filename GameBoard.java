import java.awt.*;
import java.awt.event.*;
import javax.swing.JComponent;

public class GameBoard extends JComponent {
	private final int FPS = 140; // Ändrade FPS till 140 istället för 40
	private Game game;
	private Keyboard keyboard;
	public GameBoard() {
		keyboard = new Keyboard();
		game = new Game(this);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(1100, 600);// Ändrade storleken till 1100, 600 istället för 800, 600
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		Graphics2D graphics = (Graphics2D)arg0;
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, getWidth(), getHeight());
		game.draw(graphics);
		painLine(arg0);
	}
	private void painLine(Graphics g){
		g.setColor(Color.white);
		g.drawLine(810, 0, 810, 600);
	}
	
	@Override
	protected void processKeyEvent(KeyEvent e) {
		super.processKeyEvent(e);
		if (e.getID() == KeyEvent.KEY_PRESSED)
			keyboard.processKeyEvent(e.getKeyCode(), true);
		else if (e.getID() == KeyEvent.KEY_RELEASED)
			keyboard.processKeyEvent(e.getKeyCode(), false);
	}

	public void start() {
		while(true) { 
			game.update(keyboard);
			try {
				Thread.sleep(1000 / FPS); //Throttle thread
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.repaint();
		}
		
	}
}
