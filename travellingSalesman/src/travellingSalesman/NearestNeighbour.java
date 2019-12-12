package travellingSalesman;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Class Deprecated search. Implementation of the nearest neighbour: 
 * For each city, calculate distance to all the other cities and choose the closest
 * @author Camille
 *
 */
public class NearestNeighbour {
	
	private City[] allCities; 
	private City[] path; 
	private ArrayList<City> remainingCities; 
	int indexOfPath;  
	double totalDistance; 

	
	/**
	 * Constructor
	 * @param map: Map Object used to get the cities 
	 * and number of cities to initialise the path (array of cities)  
	 * Start by putting the first city of all the cities in the path. 
	 * Keeps track of the index of the last city added in the path 
	 * Initialise the totalDistance to 0 to start. 
	 */
	public NearestNeighbour(Map map) {
		allCities = map.getCities();
		path = new City[map.getNumberOfCities() + 1];
		path[0] = allCities[0]; 
		indexOfPath = 0;
		totalDistance = 0; 
	}
	
	/**
	 * Core of the algorithm. Create an array list from all the cities
	 * While this list is not empty, get the last city in the list, get the closest city from it
	 * and add that city to the path. Then removes the same city from the list of cities to go to. 
	 * The final step is to add the first city at the end of the array.  
	 */
	public void search() {
		
		remainingCities = new ArrayList<City> (Arrays.asList(allCities));
		
		remainingCities.remove(0); // remove the first element as we added the first city in the path in the constructor
		
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
	
	/**
	 * Getter 
	 * @return a string representing the path
	 */
	public String getPathAsString() {
		
		String stringPath = "";
		
		for (City city : path) {
			stringPath += city.getCityId() + " "; 
		}
		
		return stringPath;
	}

	/**
	 * Getter
	 * @return the total distance between all cities in the path
	 */
	public double getTotalDistance() {
		return totalDistance;
	}
	
	/**
	 * Looks for the closest city from the given origin city
	 * @param originCity
	 * @param remainingCities is the list of all the cities that are not visited to look for the closest
	 * @return the city that is the closest from the origin one
	 * On the side it also update the total distance in the path, once found the closest city. 
	 */
	private City getClosestCity(City originCity, ArrayList<City> remainingCities) {	

		double shortestDistance = 0; 
		
		City closestCity = new City(); 
		
		for(int city = 0; city < remainingCities.size(); city++) {
			
			City currCity = remainingCities.get(city); 
			
			if(originCity.getCityId() == currCity.getCityId()) {
				break; 
			}
			
			double currDistance = originCity.calculateDistanceToCity(currCity);
			
			// if shortestDistance == 0 means it's the first time we're running this method. 
			if(shortestDistance == 0 || currDistance < shortestDistance) {
				shortestDistance = currDistance; 
				closestCity = currCity;
			}
		}
		
		totalDistance += shortestDistance; 
		
		return closestCity; 
	}
	
	/**
	 * Add the first city of the list of all city at the end of the final path
	 * Update the final distance  
	 */
	private void addFirstCityToFinalPath(){
		
		City latestCityInPath = path[indexOfPath];
		
		City backToStart = allCities[0]; 
		
		double lastDistance = latestCityInPath.calculateDistanceToCity(backToStart);
		
		totalDistance += lastDistance; 
		path[path.length - 1] = allCities[0]; 
	}
	

}
