package travellingSalesman;

import java.util.ArrayList;

/**
 * @Class Result Object to hold the best path its associated best distance 
 * while we're using recursion in Depth First Search.  
 * @author Camille
 *
 */
public class Result {
	
	private double bestDistance; 
	private ArrayList<City> bestPath; 
	
	/**
	 * Constructor that initialise the best distance to 0 and the best path to be a new array list of cities. 
	 */
	public Result() {
		bestDistance = 0; 
		bestPath = new ArrayList<City>();
	}
	
	/**
	 * Constructor that takes an existing distance and existing path
	 * @param bestDistance
	 * @param bestPath
	 */
	public Result(double bestDistance, ArrayList<City> bestPath) {
		this.bestDistance = bestDistance; 
		this.bestPath = bestPath; 
	}

	/**
	 * Getter
	 * @return the best distance
	 */
	public double getBestDistance() {
		return bestDistance;
	}

	/**
	 * Getter
	 * @return the best path as an array list
	 */
	public ArrayList<City> getBestPath() {
		return bestPath;
	}


	/**
	 * Getter for the best path
	 * @return a string representing the best path
	 */
	public String getBestPathString() {
		String bestPathString = ""; 
		
		for(City city : bestPath) {
			bestPathString += city.getCityId() + " ";
		}
		
		return bestPathString; 
	}
	
	/**
	 * Print the best path and its associated distance
	 */
	public void printResult() {
		System.out.println("The best path is " + this.getBestPathString());
		System.out.println("The best distance is " + this.getBestDistance());
	}

}
