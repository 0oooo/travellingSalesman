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
	private double overallBest;
	
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
		overallBest = 0;
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
	 * @return the overall best cost between all costs of paths
	 */
	public double getOverallBest() {
		return overallBest;
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
	 * @param overallBest assign the overallBest to this new value
	 * @return the updated Query
	 */
	public Query setOverallBest(double overallBest) {
		this.overallBest = overallBest;
		return this; 
	}
	
	/**
	 * Check if the new best cost is better than the overall best cost between all path
	 * If yes, assign best cost to overall best
	 * @param bestCost is a new cost from a new path discovered
	 */
	public void contestOverallBest(double bestCost){
		if (this.getOverallBest() == 0 || bestCost < this.getOverallBest()) {
			this.setOverallBest(bestCost);
		}
	}

}
