package com.utility;

public class FareCalculator {
	// Base rates per kilometer for different classes
	private static final double BASE_RATE_GENERAL = 1.0;
	private static final double BASE_RATE_SLEEPER = 1.5;
	private static final double BASE_RATE_AC = 2.5;

	public static double calculateFare(String coach, int age, int numPassengers, int km) {

		double baseRate = fareForKm(coach);
		double fare = baseRate * km;

		if (age < 12) {
			 fare *= 0.5; // 50% discount for children
		} else if (age > 60) {
			 fare *= 0.8; // 80% discount for seniors
		}

		return fare * numPassengers;
	}

	private static double fareForKm(String coach) {
		switch (coach) {
		case "Ac":
			return BASE_RATE_AC;
		case "Sleeper":
			return BASE_RATE_SLEEPER;
		default:
			return BASE_RATE_GENERAL;

		}
	}
}
