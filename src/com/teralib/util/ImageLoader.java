package com.teralib.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageLoader {
	
	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ImageIcon loadIconImage(String path) {
		ImageIcon icon = null;
		if (path != null)
			icon = new ImageIcon(path);
		else
			return null;
		return icon;
	}
	
	public static Image loadVanillaImage(String path) {
		ImageIcon imageIcon = null;
		if (path != null)
			imageIcon = new ImageIcon(path);
		else
			return null;
		Image image = imageIcon.getImage();
		return image;
	}

}
