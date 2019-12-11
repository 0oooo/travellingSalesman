package travellingSalesman;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Query {
	
	private City[] cities; 
	private ArrayList<City> path; 
	private Set<City> visited; 
	private double overallBest;
	
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
	
	

}
