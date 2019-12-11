package travellingSalesman;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Path {
	
	private ArrayList<City> path; 
	private Set<City> visitedCities; 
	private double distanceFromFirstCity; 
	private boolean completedPath; 
	
	public Path() {
		completedPath = false; 
	}
	
	public Path(City firstCity){
		path = new ArrayList<City>();
		visitedCities = new HashSet<City>(); 
		distanceFromFirstCity = 0;
		path.add(firstCity);
		visitedCities.add(firstCity);
		completedPath = false; 
	}
	
	public Path(Path existingPath) {
		path = new ArrayList<City>(existingPath.getPath());
		visitedCities = new HashSet<City>(existingPath.getVisitedCities());
		distanceFromFirstCity = existingPath.getDistanceFromFirstCity(); 
		completedPath = false; 
	}

	public ArrayList<City> getPath() {
		return path;
	}

	public Set<City> getVisitedCities() {
		return visitedCities;
	}

	public double getDistanceFromFirstCity() {
		return distanceFromFirstCity;
	}

	public void setPath(ArrayList<City> path) {
		this.path = path;
	}

	public void setVisitedCities(Set<City> visitedCities) {
		this.visitedCities = visitedCities;
	}

	public void setDistanceFromFirstCity(double distanceFromFirstCity) {
		this.distanceFromFirstCity = distanceFromFirstCity;
	}
	
	public City getFirstCityInPath() {
		return path.get(0);
	}
	
	public City getLastCityInPath() {
		return path.get(path.size() - 1);
	}

	public void addCityInPath(City newCity) {
		path.add(newCity); 
	}
	
	public void addCityInVisitedSet(City city) {
		visitedCities.add(city);
	}
	
	public void addToGlobalDistance(double newDistance) {
		distanceFromFirstCity += newDistance; 
	}
	
	public boolean isCompletedPath() {
		return completedPath;
	}

	public void setCompletedPath(boolean completedPath) {
		this.completedPath = completedPath;
	}
}
