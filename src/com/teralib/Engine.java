package com.teralib;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import com.teralib.display.Bitmap;
import com.teralib.display.Display;
import com.teralib.input.Keyboard;
import com.teralib.input.Mouse;

@SuppressWarnings("static-access")
public abstract class Engine implements Runnable {

	protected Display display;
	public static Bitmap bitmap;
	
	public static int WIDTH;
	public static int HEIGHT;
	
	private Thread thread;
	private boolean running = false;
	
	protected Keyboard keyboard;
	protected Mouse mouse;
	
	public Engine(String title, int width, int height, boolean resizable, Bitmap bitmap) {
		this.bitmap = bitmap;
		this.WIDTH = width;
		this.HEIGHT = height;
		display = new Display(title, width, height, resizable, true, bitmap);
		
		keyboard = new Keyboard();
		display.getMainContainer().addKeyListener(keyboard);
		
		mouse = new Mouse();
		bitmap.addMouseListener(mouse);
		bitmap.addMouseMotionListener(mouse);
		
		bitmap.setFocusable(false);
	}
	
	public void run() {
		init();
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;
			if (delta >= 1) {
				tick(delta);
				render();
				delta--;
			}
		}
		stop();
	}
	
	public void render() {
		BufferStrategy bs = bitmap.getDrawBuffer();
		if (bs == null) {
			bitmap.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		draw(g);
		
		bs.show();
		g.dispose();
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	public abstract void init();
	public abstract void tick(double deltaTime);
	public abstract void draw(Graphics g);
	
	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
