package fallingsand;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class View extends JPanel {
	private static final long serialVersionUID = 7360421696522757931L;
	public sandParticle sand [][];
	public int particleSize = 3;
	
	public View () {
		sand = new sandParticle[500/particleSize][500/particleSize];
		
		for (int i = 0; i < 500/particleSize; i++) {
			for (int j = 0; j < 500/particleSize; j++) {
				sand[i][j] = new sandParticle(i, j, this);
			}
		}
		
		for (int i = 0; i < 500/particleSize; i++) {
				sand[i][0].isActive=true;
		}
	}

	public void paint (Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 500, 500);
		
		for (int i = 0; i < 500/particleSize; i++) {
			for (int j = 0; j < 500/particleSize; j++) {
				sand[i][j].paint(g);;
			}
		}
	}
	
	public void update () {
		for (int i = 0; i < 500/particleSize; i++) {
			for (int j = 0; j < 500/particleSize; j++) {
				if (sand[i][j].isActive && j < 500/particleSize - 38/particleSize) {
					// This is horrific TODO switch to a switch
					if (!sand[i][j + 1].isActive && !sand[i][j].recentMove) {
						sand[i][j].isActive = false;
						sand[i][j+1].isActive = true;
						sand[i][j+1].recentMove = true;
					} else if (i < 500/particleSize - 1 && !sand[i+1][j+1].isActive && !sand[i][j].recentMove) {
						sand[i][j].isActive = false;
						sand[i+1][j].isActive = true;
						sand[i+1][j].recentMove = true;
					} else if (i > 0 && !sand[i-1][j+1].isActive && !sand[i][j].recentMove) {
						sand[i][j].isActive = false;
						sand[i-1][j].isActive = true;
						sand[i-1][j].recentMove = true;
					} else {
						sand[i][j].recentMove = false;
					}
				}
			}
		}
	}

}

class sandParticle {
	
	public boolean isActive = false;
	public boolean recentMove = false;
	View view;
	int x, y;
	
	public sandParticle (int xPos, int yPos, View parent) {
		x = xPos;
		y = yPos;
		view = parent;
	}
	
	public void paint (Graphics g) {
		if (isActive) {
			Color sandColor = new Color ((int)(255 * ((y * view.particleSize)/500.0)), (int)(255 * ((x * view.particleSize)/500.0)), (int)(255 - (255 * (((y+x)/2 * view.particleSize)/500.0))));
			g.setColor(sandColor);
			g.fillRect(x * view.particleSize, y * view.particleSize, view.particleSize, view.particleSize);
		}
	}
	
}