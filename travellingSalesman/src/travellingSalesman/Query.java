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
	 * Constructor
	 * @param cities 
	 */
	public Query(City[] cities) {
		this.cities = cities;
		path = new ArrayList<>();
		visited = new HashSet<City>();
		overallBest = 0;
	}

	public City[] getCities() {
		return cities;
	}

	public ArrayList<City> getPath() {
		return path;
	}

	public Set<City> getVisited() {
		return visited;
	}

	public double getOverallBest() {
		return overallBest;
	}

	public Query setCities(City[] points) {
		this.cities = points;
		return this; 
	}

	public Query setPath(ArrayList<City> path) {
		this.path = path;
		return this; 
	}

	public Query setVisited(Set<City> visited) {
		this.visited = visited;
		return this; 
	}

	public Query setOverallBest(double overallBest) {
		this.overallBest = overallBest;
		return this; 
	}
	
	public void contestOverallBest(double bestCost){
		if (this.getOverallBest() == 0 || bestCost < this.getOverallBest()) {
			// found a new best complete path
			this.setOverallBest(bestCost);
		}
	}

}
