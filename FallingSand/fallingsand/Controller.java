package fallingsand;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Controller implements MouseListener, MouseMotionListener {
	
	boolean mouseHeld;
	View view;
	
	public Controller (View gameView) {
		view = gameView;
	}

	// MouseListener is unused for now
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	// Mouse Motion Listener governs sand creation

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (e.getX() > 0 && e.getY() > 0 && e.getX() < 500 && e.getY() < 500) view.sand[e.getX()/view.particleSize][e.getY()/view.particleSize].isActive = true;
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

}
 