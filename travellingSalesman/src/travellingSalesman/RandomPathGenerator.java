package travellingSalesman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * This @class was meant to explore the minimum spanning tree. 
 * As the time is missing, it has been turned into a generator of random path
 * @author Camille
 *
 */

public class RandomPathGenerator {
	
	private City[] initialPath;
	private double initialDistance; 
	
	/**
	 * Constructor 
	 * Generate an initial path and calculate its distance
	 * @param cities is the array of all cities
	 */
	public RandomPathGenerator(City[] cities) { 
		initialPath = generateRandomPath(cities); 
		initialDistance = calculateAllDistances();
	}
	
	/**
	 * Takes the array of cities, shuffle them and return an initial path
	 * @param allCities
	 * @return
	 */
	private City[] generateRandomPath(City[] allCities) {
		City[] randomPath = new City[allCities.length + 1]; 
		
		ArrayList<City> shuffledCities = new ArrayList<City> (Arrays.asList(allCities));
		Collections.shuffle(shuffledCities);
		
		int cityIndex = 0; 
		for(City city : shuffledCities) {
			randomPath[cityIndex] = city; 
			cityIndex++;
		}
		randomPath[randomPath.length - 1] = randomPath[0];
		
		return randomPath; 
	}
	
	/**
	 * Calculate the distance between each city
	 * @return the overall distance for the full path
	 */
	private double calculateAllDistances() {
		double distance = 0;
		for (int city = 0; city < initialPath.length - 1; city++) {
			distance += initialPath[city].calculateDistanceToCity(initialPath[city + 1]);
		}
		return distance;
	}
	
	/**
	 * If there is no path given, print the initial path and its distance
	 */
	public void printPathAndDistance() {
		printPathAndDistance(initialPath, initialDistance);
	}
	
	/**
	 * Print a path and the distance
	 * @param path: an array of all cities
	 * @param distance: the overall distance
	 */
	public void printPathAndDistance(City[] path, double distance) {
		String bestPathString = ""; 
		for(City city : path) {
			bestPathString += city.getCityId() + " ";
		}
		System.out.println("The best path is " + bestPathString);
		System.out.println("Its cost is " + distance);
	}

}
