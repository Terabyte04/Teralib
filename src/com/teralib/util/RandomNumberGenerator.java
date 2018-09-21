package com.teralib.util;

import java.util.Random;

public class RandomNumberGenerator {
	
	private Random random;
	
	public RandomNumberGenerator() {
		random = new Random();
	}
	
	public int generateInt(int min, int max) {
		int generatedNumber = random.nextInt(max) + min;
		return generatedNumber;
	}
	
	public float generateFloat(float min, float max) {
		float generatedFloat = (random.nextFloat() * max) + min;
		return generatedFloat;
	}
	
	public double generateDouble(double min, double max) {
		double generatedDouble = (random.nextDouble() * max) + min;
		return generatedDouble;
	}

}
