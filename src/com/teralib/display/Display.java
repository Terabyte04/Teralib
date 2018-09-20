package com.teralib.display;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {

	private JFrame frame;
	private Bitmap bitmap;
	
	public Display(String title, int width, int height, boolean resizable, boolean middleOfScreen, Bitmap bitmap) {
		this.bitmap = bitmap;
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension size = new Dimension(width, height);
		frame.setMinimumSize(size);
		frame.setPreferredSize(size);
		frame.setMaximumSize(size);
		if (middleOfScreen)
			frame.setLocationRelativeTo(null);
		frame.setResizable(resizable);
		frame.setVisible(true);
		frame.add(bitmap);
		frame.pack();
	}
	
	public JFrame getMainContainer() {
		return frame;
	}
	
	public Bitmap getRenderTexture() {
		return bitmap;
	}
	
}
