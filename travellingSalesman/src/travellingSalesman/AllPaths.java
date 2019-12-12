package travellingSalesman;

import java.util.ArrayList;

/**
 * @Class Used by the Depth First Search to store all the paths generated
 * and then print them. Used for debug purposed (check the number of paths generated, if all the paths are explored, it the distances match..)
 * @author Camille
 *
 */

public class AllPaths {
	
	private ArrayList<Double> costs;
	private ArrayList<ArrayList<City>> paths; 
	
	/**
	 * Constructor that initialises an array of cost and an array of array of cities
	 * They should be parallel. For ex the first array of city (or path) 
	 * has its total cost (or distance) in the cost array at the same index
	 * paths[0] = {1, 2, 3}
	 * costs[0] = 8 
	 * => path {1, 2, 3} has a cost of 8.  
	 */
	public AllPaths() {
		costs = new ArrayList<Double>();
		paths = new ArrayList<ArrayList<City>>(); 
	}

	/**
	 * Getter of the costs
	 * @return an array list of double, the costs (or total distance) for a path
	 */
	public ArrayList<Double> getAllCosts() {
		return costs;
	}
	
	/**
	 * Getter of all the paths
	 * @return an array list paths (here represented by another array list of cities).
	 */
	public ArrayList<ArrayList<City>> getAllPaths() {
		return paths;
	}
	
	/**
	 * Add a path to the list of paths (or array list of cities)
	 * @param path which is an array list of cities. 
	 */
	public void addPath(ArrayList<City> path) {
		paths.add(path);
	}
	
	/**
	 * Add a cost to the list of cost
	 * @param cost is a double. It is the total distance between all the cities of a finished path
	 */
	public void addCost(double cost) {
		costs.add(cost);
	}
	
	
	/**
	 * Constructs a string that will link each path from the list of paths (or lists of cities) to their costs
	 * @return a string of ALL the paths and associated costs
	 */
	public String getAllPathsWithCost() {
		String pathsCostString = ""; 
		
		for (int i = 0; i < paths.size(); i++) {
			pathsCostString += "Path: "; 
			for (City city : paths.get(i)) {
				pathsCostString += city.getCityId() + " "; 
			}
			pathsCostString += " -> Cost = " + costs.get(i) + "\n";
		}
		
		return pathsCostString; 
	}
	
	/**
	 * Print the string of paths with their associated cost. 
	 */
	public void printAllPath() {
		System.out.println(this.getAllPathsWithCost());
	}

}
