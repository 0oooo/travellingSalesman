package travellingSalesman;

/**
 * This class is a map. 
 * It contains an array of all the cities and an array of all the roads. 
 */

public class Map {
	
	City[] cities; 
	Road[] roads; 
	int numberOfRoads;
	int indexOfRoad = 0; 
	int indexOfCity = 0; 
	
	Map(int numberOfCities){
		numberOfRoads = calculateNunmberOfRoads(numberOfCities);
		roads = new Road[numberOfRoads];
		cities = new City[numberOfCities];
	}
	
	public City[] getCities() {
		if(cities.length > 0) {
			return cities; 
		}
		return null; 
	}
	
	public Road[] getRoads() {
		if(roads.length > 0) {
			return roads;
		}
		return null; 
	}
	
	public boolean isEmpty() {
		if (cities.length > 0 || roads.length > 0) {
			return false; 
		}
		return true; 
	}
	
	public boolean hasCities() {
		if (cities.length > 0) {
			return false; 
		}
		return true; 
	}
	
	public boolean hasRoads() {
		if (roads.length > 0) {
			return false; 
		}
		return true; 
	}
	
	public void addCityToList(City city) {
		cities[indexOfCity] = city; 
		indexOfCity++; 
	}
	
	public void addRoadToGraph(Road road) {
		roads[indexOfRoad] = road; 
		indexOfRoad++; 
	}

	private int calculateNunmberOfRoads(int numberOfCities) {
		int roads = 0; 
		for(int city = numberOfCities; city > 0; city--) {		
			roads += --numberOfCities; 
		}
		return roads; 
	}
	
	public void calculateRoad() {
		int indexOfRoads = 0;
		 
		for (int city = 0; city < cities.length; city++) {
			City city1 = cities[city];
			for (int nextCity = city + 1; nextCity < cities.length; nextCity++) {
				City city2 = cities[nextCity];
				Road road = new Road(city1, city2);
				roads[indexOfRoads] = road; 
				indexOfRoads++; 
			}
		}
	}

}
