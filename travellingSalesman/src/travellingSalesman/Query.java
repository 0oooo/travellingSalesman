package travellingSalesman;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @Class Query Object used by the Depth First Search 
 * to keep track of the states of the cities and paths 
 * while going recursively through the different paths
 * @author Camille
 *
 */
public class Query {
	
	private City[] cities; 
	private ArrayList<City> path; 
	private Set<City> visited; 
	private double overallBestDistance;
	
	/**
	 * Constructor that initialise the cities to be explored 
	 * the path (list of cities in the order they are visited)
	 * the set of visited cities and the best result of any path so far
	 * @param cities takes an array of cities
	 */
	public Query(City[] cities) {
		this.cities = cities;
		path = new ArrayList<>();
		visited = new HashSet<City>();
		overallBestDistance = 0;
	}

	/**
	 * Getter
	 * @return the list of cities (to know which ones to explore still)
	 */
	public City[] getCities() {
		return cities;
	}

	/**
	 * Getter
	 * @return the array list that represents the path
	 */
	public ArrayList<City> getPath() {
		return path;
	}

	/**
	 * Getter
	 * @return the set of visited cities
	 */
	public Set<City> getVisited() {
		return visited;
	}

	/**
	 * Getter
	 * @return the overall best distance between all distances of paths
	 */
	public double getOverallBestDistance() {
		return overallBestDistance;
	}

	/**
	 * Setter
	 * @param path takes a path and set the path of this query to it
	 * @return the updated Query
	 */
	public Query setPath(ArrayList<City> path) {
		this.path = path;
		return this; 
	}

	/**
	 * Setter
	 * @param visited takes a set of visited cities and 
	 * set the set of this query to it
	 * @return the updated Query
	 */
	public Query setVisited(Set<City> visited) {
		this.visited = visited;
		return this; 
	}

	/**
	 * Setter
	 * @param overallBestDistance assign the overallBestDistance to this new value
	 * @return the updated Query
	 */
	public Query setOverallBestDistance(double overallBestDistance) {
		this.overallBestDistance = overallBestDistance;
		return this; 
	}
	
	/**
	 * Check if the new best distance is better than the overall best distance between all path
	 * If yes, assign best distance to overall best distance
	 * @param bestDistance is a new distance from a new path discovered
	 */
	public void contestOverallBestDistance(double bestDistance){
		if (this.getOverallBestDistance() == 0 || bestDistance < this.getOverallBestDistance()) {
			this.setOverallBestDistance(bestDistance);
		}
	}

}
