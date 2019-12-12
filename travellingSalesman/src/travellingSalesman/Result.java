package travellingSalesman;

import java.util.ArrayList;

/**
 * @Class Result Object to hold the best path its associated best cost 
 * while we're using recursion in Depth First Search.  
 * @author Camille
 *
 */
public class Result {
	
	private double bestCost; 
	private ArrayList<City> bestPath; 
	
	/**
	 * Constructor that initialise the best cost to 0 and the best path to be a new array list of cities. 
	 */
	public Result() {
		bestCost = 0; 
		bestPath = new ArrayList<City>();
	}
	
	/**
	 * Constructor that takes an existing cost and existing path
	 * @param bestCost
	 * @param bestPath
	 */
	public Result(double bestCost, ArrayList<City> bestPath) {
		this.bestCost = bestCost; 
		this.bestPath = bestPath; 
	}

	/**
	 * Getter
	 * @return the best cost
	 */
	public double getBestCost() {
		return bestCost;
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
		String bestPathString = "Best Path = "; 
		
		for(City city : bestPath) {
			bestPathString += city.getCityId() + " ";
		}
		
		return bestPathString; 
	}
	
	/**
	 * Print the best path and its associated cost
	 */
	public void printResult() {
		System.out.println("The best path is " + this.getBestPathString());
		System.out.println("The best cost is " + this.getBestCost());
	}

}
