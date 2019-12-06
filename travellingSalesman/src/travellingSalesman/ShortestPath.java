package travellingSalesman;

import java.util.Arrays;

public class ShortestPath {
	
	private Map map; 
	private City[] allCities; 
	private City[] path; 
	private City[] remainingCities; 
	int indexOfPath;  
	double totalDistance; 

	
	public ShortestPath(Map map, int numberOfCities) {
		this.map = map; 
		allCities = map.getCities();
		path = new City[numberOfCities + 1];
		path[0] = allCities[0]; 
		indexOfPath = 0;
		totalDistance = 0; 
	}
	
	public void search() {
		
		remainingCities = this.shift(allCities); 
		
		while(remainingCities.length > 0) {
			City latestCityInPath = path[indexOfPath];
			City nextCityInPath = getClosestCity(latestCityInPath, remainingCities); 
			indexOfPath++;  
			path[indexOfPath] = nextCityInPath; 
			remainingCities = shift(remainingCities);
		}		
		path[path.length - 1] = allCities[0]; 
	}
	
	public City[] getPath() {
		return path;
	}
	
	public String getPathAsString() {
		String stringPath = "";
		for (City city : path) {
			stringPath += city + " "; 
		}
		return stringPath;
	}

	public double getTotalDistance() {
		return totalDistance;
	}

	private City[] shift(City[] cities) {
		City[] remainingCities = Arrays.copyOf(cities, cities.length - 1);
		for(int city = 0; city < remainingCities.length; city++) {
			remainingCities[city] = cities[city + 1];
		}
		return remainingCities; 
	}
	
	private City getClosestCity(City originCity, City[] remainingCities) {
		
		
		double[][] distanceMatrix = map.getRoadMatrix();
		
		// We are using the matrix of distances in map.
		// Each city in this matrix has for index its id - 1 
		int cityInMatrix = originCity.getId() - 1; 
		double shortestDistance = 0; 
		City closestCity = new City(); 
		
		for(City nextCity : remainingCities) {
			int nextCityInMatrix = nextCity.getId() - 1; 
			double distance = distanceMatrix[cityInMatrix][nextCityInMatrix];
			if(shortestDistance == 0 || distance < shortestDistance) {
				shortestDistance = distance; 
				closestCity = nextCity;
			}
			
		}
		totalDistance += shortestDistance; 
		return closestCity; 
	}
	

}
