package com.teralib.maths;

public class Maths {

	public static float distance(Vector2f pointA, Vector2f pointB) {
		float dist = (float) Math.sqrt(
			Math.pow((float) (pointB.x - pointA.x), 2) +
			Math.pow((float) (pointB.y - pointA.y), 2)
		);
		return dist;
	}
	
	public static float returnAverageFloat(Float... numbers) {
		float total = 0.0f;
		for (int i = 0; i < numbers.length; i++) {
			total += numbers[i];
		}
		float average = total / numbers.length;
		return average;
	}
	
	public static int returnAverageInt(Integer... numbers) {
		int total = 0;
		for (int i = 0; i < numbers.length; i++) {
			total += numbers[i];
		}
		int average = total / numbers.length;
		return average;
	}
	
	public static double returnAverageDouble(Double... numbers) {
		double total = 0.0d;
		for (int i = 0; i < numbers.length; i++) {
			total += numbers[i];
		}
		double average = total / numbers.length;
		return average;
	}
	
	public static long returnAverageLong(Long... numbers) {
		long total = 0L;
		for (int i = 0; i < numbers.length; i++) {
			total += numbers[i];
		}
		long average = total / numbers.length;
		return average;
	}
	
}
