package travellingSalesman;

import java.util.ArrayList;

/**
 * @Class Used by the Depth First Search to store all the paths generated
 * and then print them. Used for debug purposed (check the number of paths generated, if all the paths are explored, it the distances match..)
 * @author Camille
 *
 */

public class AllPaths {
	
	private ArrayList<Double> distances;
	private ArrayList<ArrayList<City>> paths; 
	
	/**
	 * Constructor that initialises an array of distances and an array of array of cities
	 * They should be parallel. For ex the first array of city (or path) 
	 * has its total distance in the distance array at the same index
	 * paths[0] = {1, 2, 3}
	 * distances[0] = 8 
	 * => path {1, 2, 3} has a distance of 8.  
	 */
	public AllPaths() {
		distances = new ArrayList<Double>();
		paths = new ArrayList<ArrayList<City>>(); 
	}

	/**
	 * Getter of the distances
	 * @return an array list of double, the distances for a path
	 */
	public ArrayList<Double> getAllDistances() {
		return distances;
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
	 * Add a distance to the list of distances
	 * @param distance is a double. It is the total distance between all the cities of a finished path
	 */
	public void addDistance(double distance) {
		distances.add(distance);
	}
	
	
	/**
	 * Constructs a string that will link each path from the list of paths (or lists of cities) to their distances
	 * @return a string of ALL the paths and associated distances
	 */
	public String getAllPathsWithDistances() {
		String pathsAndDistancesString = ""; 
		
		for (int i = 0; i < paths.size(); i++) {
			pathsAndDistancesString += "Path: "; 
			for (City city : paths.get(i)) {
				pathsAndDistancesString += city.getCityId() + " "; 
			}
			pathsAndDistancesString += " -> Distance = " + distances.get(i) + "\n";
		}
		
		return pathsAndDistancesString; 
	}
	
	/**
	 * Print the string of paths with their associated distance. 
	 */
	public void printAllPath() {
		System.out.println(this.getAllPathsWithDistances());
	}

}
