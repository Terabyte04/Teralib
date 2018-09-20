package com.teralib.display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;

public class Bitmap extends Canvas {

	private static final long serialVersionUID = 1L;
	
	public Bitmap(int width, int height) {
		Dimension size = new Dimension(width, height);
		setMinimumSize(size);
		setMaximumSize(size);
		setPreferredSize(size);
	}
	
	public BufferStrategy getDrawBuffer() {
		return this.getBufferStrategy();
	}
	
}
