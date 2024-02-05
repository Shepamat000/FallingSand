package fallingsand;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Settings implements ChangeListener, ActionListener {
	
	/**
	 * 
	 */
	static boolean open = true;
	
	JFrame frame;
	JPanel panel;
	JLabel label;
	JButton button;
	JSlider sizeSlider;
	
	static final int minSize = 1;
	static final int maxSize = 20;
	static final int initialSize = 3;   
	
	public Settings () {
		
		frame = new JFrame("Settings");
		panel = new JPanel();
		label = new JLabel();
		sizeSlider = new JSlider(minSize, maxSize, initialSize);
		
		// Slider swing settings
		sizeSlider.setPreferredSize(new Dimension(400, 100));
		sizeSlider.setPaintTicks(true);
		sizeSlider.setMinorTickSpacing(1);
		sizeSlider.setMajorTickSpacing(2);
		sizeSlider.setPaintLabels(true);
		sizeSlider.addChangeListener(this);
		
		// Label swing settings
		label.setText("Sand Particle Size = " + sizeSlider.getValue());
		label.setPreferredSize(new Dimension(300, 50));
		
		// Button swing settings
		button = new JButton();
		button.setBounds(100, 100, 250, 100);
		button.addActionListener(this);
		button.setText("Save and Exit");
		
		button.setFocusable(false);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setFont(new Font("Serif", Font.BOLD,25));
		button.setIconTextGap(-15);
		button.setForeground(Color.cyan);
		button.setBackground(Color.lightGray);
		button.setBorder(BorderFactory.createEtchedBorder());
		
		// Add to panel
		panel.add(sizeSlider);
		panel.add(label);
		panel.add(button);
		
		// Add to frame
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 300);
		frame.setVisible(true);
	}
	
	public static void main (String[] args) {
		Settings settings = new Settings();
		
		// Buffered thread to prevent program from continue until button is pressed
		while (open) {
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} 
		
		settings.frame.dispose();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		label.setText("Sand Particle Size = " + sizeSlider.getValue());
		Main.particleSizeSetting = sizeSlider.getValue();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==button) {
			open = false;
		}
		
	}

}
