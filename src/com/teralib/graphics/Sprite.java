package com.teralib.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.teralib.maths.Vector2f;

public class Sprite {

	private Vector2f position;
	
	private float x;
	private float y;
	private float width;
	private float height;
	
	private BufferedImage texture;
	
	public Sprite(BufferedImage texture, float x, float y, float width, float height) {
		this.position = new Vector2f(x, y);
		this.texture = texture;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void move(float dx, float dy) {
		position.x += dx;
		position.y += dy;
	}
	
	public BufferedImage getTexture() {
		return texture;
	}
	
	public Vector2f getPosition() {
		return new Vector2f(position.x, position.y);
	}
	
}
