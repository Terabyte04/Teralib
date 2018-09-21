package com.teralib.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Sprite {

	private float x;
	private float y;
	private float width;
	private float height;
	
	private BufferedImage texture;
	
	public Sprite(BufferedImage texture, float x, float y, float width, float height) {
		this.texture = texture;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void draw(Graphics g) {
		if (texture != null)
			g.drawImage(texture, (int) x, (int) y, (int) width, (int) height, null);
		else {
			g.setColor(Color.magenta);
			g.fillRect((int) x, (int) y, (int) width, (int) height);
		}
	}
	
}
