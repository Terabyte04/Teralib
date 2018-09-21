package com.teralib.maths;

public class Vector2f {

	public float x;
	public float y;
	
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2f() {
		this.x = 0;
		this.y = 0;
	}
	
	public Vector2f addVector2f(Vector2f a, Vector2f b) {
		Vector2f result = new Vector2f(a.x + b.x, a.y + b.y);
		return result;
	}
	
	public Vector2f subVector2f(Vector2f a, Vector2f b) {
		Vector2f result = new Vector2f(a.x - b.x, a.y - b.y);
		return result;
	}
	
}
