package travellingSalesman;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @class Path object used by Dijkstra algorithm 
 * It's a list of cities (a path). 
 * Keeps track of the visited cities in a set (to compare with the total cities) 
 * and distance from first city (which is the equivalent of overall cost with the DFS)
 * Keeps track if its a complete path (all cities + back to the begining) 
 * @author Camille
 *
 */
public class Path {
	
	private ArrayList<City> path; 
	private Set<City> visitedCities; 
	private double distanceFromFirstCity; 
	private boolean completedPath; 
	
	/**
	 * Empty constructor, only used to set best path and first path to check 
	 * Both are meant to be overwritten in Dijkstra 
	 */
	public Path() {
		completedPath = false; 
	}
	
	/**
	 * Constructor for the initialisation of Dijkstra 
	 * @param firstCity takes the first city and initialise everything
	 */
	public Path(City firstCity){
		path = new ArrayList<City>();
		visitedCities = new HashSet<City>(); 
		distanceFromFirstCity = 0;
		path.add(firstCity);
		visitedCities.add(firstCity);
		completedPath = false; 
	}
	
	/**
	 * Constructor to copy an existing path to a new path
	 * Used when getting the path from the queue to modify (extend) it
	 * @param existingPath
	 */
	public Path(Path existingPath) {
		path = new ArrayList<City>(existingPath.getPath());
		visitedCities = new HashSet<City>(existingPath.getVisitedCities());
		distanceFromFirstCity = existingPath.getDistanceFromFirstCity(); 
		completedPath = existingPath.isCompletedPath(); 
	}

	/**
	 * Getter
	 * @return a list of city (a path)
	 */
	public ArrayList<City> getPath() {
		return path;
	}

	/**
	 * Getter
	 * @return the set of visited cities
	 */
	public Set<City> getVisitedCities() {
		return visitedCities;
	}

	/**
	 * Getter
	 * @return the overall cost (distance from first city)
	 */
	public double getDistanceFromFirstCity() {
		return distanceFromFirstCity;
	}

	/**
	 * Getter
	 * @return the first city in path to put it back at the end
	 */
	public City getFirstCityInPath() {
		return path.get(0);
	}
	
	/**
	 * Getter
	 * @return last city in path to calculate its distance to the next city to be added
	 */
	public City getLastCityInPath() {
		return path.get(path.size() - 1);
	}

	/**
	 * Add a new city in the path
	 * @param newCity is a City Object
	 */
	public void addCityInPath(City newCity) {
		path.add(newCity); 
	}
	
	/**
	 * Add the new city in the visited set to avoid visiting twice
	 * @param city
	 */
	public void addCityInVisitedSet(City city) {
		visitedCities.add(city);
	}
	
	/**
	 * Increase the overall distance, of distance from first city
	 * @param newDistance is the distance between the last city in path 
	 * and the new city to be added in the path
	 */
	public void addToGlobalDistance(double newDistance) {
		distanceFromFirstCity += newDistance; 
	}
	
	/**
	 * Getter
	 * @return a boolean that checks if the path has all cities + back to the first city
	 */
	public boolean isCompletedPath() {
		return completedPath;
	}

	/**
	 * Setter
	 * @param completedPath: say the path has all cities and is back to the first city 
	 */
	public void setCompletedPath(boolean completedPath) {
		this.completedPath = completedPath;
	}
}
