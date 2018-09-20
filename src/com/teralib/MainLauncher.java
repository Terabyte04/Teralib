package com.teralib;

import com.teralib.display.Bitmap;
import com.teralib.display.Display;
import com.teralib.input.Keyboard;
import com.teralib.input.Mouse;

@SuppressWarnings("static-access")
public abstract class MainLauncher implements Runnable {

	protected Display display;
	protected Bitmap bitmap;
	
	protected static int WIDTH;
	protected static int HEIGHT;
	
	private Thread thread;
	private boolean running = false;
	
	protected Keyboard keyboard;
	protected Mouse mouse;
	
	public MainLauncher(String title, int width, int height, boolean resizable, Bitmap bitmap) {
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
				tick();
				render();
				delta--;
			}
		}
		stop();
	}
	
	public abstract void init();
	public abstract void tick();
	public abstract void render();
	
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
