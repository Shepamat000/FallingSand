package fallingsand;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main extends JFrame {
	private static final long serialVersionUID = -1701188282740503775L;
	
	View view;
	public static int particleSizeSetting = 3;
	Controller controller;

	public Main () {
		view = new View(particleSizeSetting);
		controller = new Controller(view);
		
		this.setTitle("A Falling Sand Simulation");
		this.setVisible(true);
		this.setFocusable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().add(view);
		view.addMouseListener(controller);
		view.addMouseMotionListener(controller);
		this.setSize(500, 500);
	}
	
	public static void main (String[] args) {
		Settings.main(args);
		Main main = new Main();
		main.run();
	}
	
	// Thread
	public void run () {
		while (true) {
			try {
				view.repaint();
				view.update();
				Toolkit.getDefaultToolkit().sync(); // Updates screen
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
