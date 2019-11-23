package travellingSalesman;

import java.util.HashSet;
import java.util.Set;

public class Query {
	
	private City[] cities; 
	private City[] path; 
	private Set<City> visited; 
	private double overallBest;
	
	public Query(City[] cities, int numberOfCities) {
		this.cities = cities;
		path = new City[numberOfCities];
		visited = new HashSet<City>();
		overallBest = 0;
	}

	public City[] getCities() {
		return cities;
	}

	public City[] getPath() {
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

	public Query setPath(City[] path) {
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
	
	

}
