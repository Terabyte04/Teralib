package com.teralib.graphics;

import java.awt.image.BufferedImage;

import com.teralib.maths.Vector2f;
import com.teralib.util.ImageLoader;

public class Sprite {

	private Vector2f position;
	
	private BufferedImage texture;
	
	public Sprite(String texturePath, float x, float y, float width, float height) {
		this.position = new Vector2f(x, y);
		this.texture = ImageLoader.loadImage(texturePath);
	}
	
	public void move(float dx, float dy) {
		position.x += dx;
		position.y += dy;
	}
	
	public BufferedImage getTexture() {
		return texture;
	}
	
	public void setTexture(String texturePath) {
		this.texture = ImageLoader.loadImage(texturePath);
	}
	
	public Vector2f getPosition() {
		return new Vector2f(position.x, position.y);
	}
	
}
