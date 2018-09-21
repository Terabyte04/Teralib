package com.teralib.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener {

	private static int mouseX;
	private static int mouseY;
	
	private static boolean clicked = false;
	private static boolean offscreen = false;
	private static boolean entered = false;
	private static boolean dragged = false;
	
	@Override
	public void mouseDragged(MouseEvent e) {
		dragged = true;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		entered = true;
		offscreen = false;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		offscreen = true;
		entered = false;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		clicked = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		clicked = false;
	}

	public static int getMouseX() {
		return mouseX;
	}

	public static int getMouseY() {
		return mouseY;
	}

	public static boolean isClicked() {
		return clicked;
	}

	public static boolean isOffscreen() {
		return offscreen;
	}

	public static boolean isEntered() {
		return entered;
	}

	public static boolean isDragged() {
		return dragged;
	}
	
}
