package travellingSalesman;

import java.util.ArrayList;
import java.util.Arrays;

public class NearestNeighbour {
	
	private City[] allCities; 
	private City[] path; 
	private ArrayList<City> remainingCities; 
	int indexOfPath;  
	double totalDistance; 

	
	public NearestNeighbour(Map map, int numberOfCities) {
		allCities = map.getCities();
		path = new City[numberOfCities];
		path[0] = allCities[0]; 
		indexOfPath = 0;
		totalDistance = 0; 
	}
	
	public void search() {
		
		remainingCities = new ArrayList<City> (Arrays.asList(allCities));
		remainingCities.remove(0);
		
		while(remainingCities.size() > 0) {
			City latestCityInPath = path[indexOfPath];
			City nextCityInPath = getClosestCity(latestCityInPath, remainingCities); 
			indexOfPath++;  
			path[indexOfPath] = nextCityInPath; 
			int cityToRemove = remainingCities.indexOf(nextCityInPath);
			remainingCities.remove(cityToRemove);
		}
		addFirstCityToFinalPath(); 	
	}
	
	public City[] getPath() {
		return path;
	}
	
	public String getPathAsString() {
		String stringPath = "";
		for (City city : path) {
			stringPath += city.getId() + " "; 
		}
		return stringPath;
	}

	public double getTotalDistance() {
		return totalDistance;
	}
	
	private City getClosestCity(City originCity, ArrayList<City> remainingCities) {	
		// We are using the matrix of distances in map.
		// Each city in this matrix has for index its id - 1 
		double shortestDistance = 0; 
		City closestCity = new City(); 
		
		for(int city = 0; city < remainingCities.size(); city++) {
			City currCity = remainingCities.get(city); 
			if(originCity.getId() == currCity.getId()) {
				break; 
			}
			double currDistance = originCity.calculateDistanceToCity(currCity);
			if(shortestDistance == 0 || currDistance < shortestDistance) {
				shortestDistance = currDistance; 
				closestCity = currCity;
			}
		}
		totalDistance += shortestDistance; 
		return closestCity; 
	}
	
	private void addFirstCityToFinalPath(){
		City latestCityInPath = path[indexOfPath];
		City backToStart = allCities[0]; 
		double lastDistance = latestCityInPath.calculateDistanceToCity(backToStart);
		totalDistance += lastDistance; 
		path[path.length - 1] = allCities[0]; 
	}
	

}
