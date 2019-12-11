package travellingSalesman;

/**
 * This is a map generated from the read file.  
 * It contains: 
 * - an array of all the cities, 
 * - the number of cities 
 * - the number of possible paths
 */

public class Map {
	
	private City[] cities; 
	private double[][] roadMatrix; 
	private int indexOfCity = 0; 
	private int numberOfCities; 
	private int numberOfPaths; 
	
	public Map(int numberOfCities){
		cities = new City[numberOfCities];
		this.numberOfCities = numberOfCities; 
		roadMatrix = new double[numberOfCities][numberOfCities];
		numberOfPaths = calculateNumberOfPaths(this.numberOfCities); 
	}
	
	public City[] getCities() {
		if(hasCities()) {
			return cities; 
		}
		return null; 
	}
	
	public boolean isEmpty() {
		if (cities.length > 0) {
			return false; 
		}
		return true; 
	}
	
	public boolean hasCities() {
		if (cities.length > 0) {
			return true; 
		}
		return false; 
	}
	
	public void addCityToList(City city) {
		cities[indexOfCity] = city; 
		indexOfCity++; 
	}
	
	public int getNumberOfCities() {
		return numberOfCities; 
	}
	
	public int calculateNumberOfPaths(int numberOfCity) {
		int roads = 0; 
		int copyNumberOfCities = numberOfCity;
		for(int city = copyNumberOfCities; city > 0; city--) {		
			roads += --copyNumberOfCities; 
		}
		return roads; 
	}
	
	public int getNumberOfPaths() {
		return numberOfPaths; 
	}
	
	public void generateRoadMatrix() {
		for(int city = 0; city < cities.length; city++) {
			for(int nextCity = 0; nextCity < cities.length; nextCity++) {
				City city1 = cities[city];
				City city2 = cities[nextCity];
				double distance = city1.calculateDistanceToCity(city2);
				roadMatrix[city][nextCity] = distance; 
			}
		}
	}
	
	public void printRoadMatrix() {
		for(double[] road : roadMatrix ) {
			System.out.print("[");
			for(double distance : road) {
				System.out.print(distance + "  ");
			}
			System.out.println("]");
		}
	}

	public double[][] getRoadMatrix(){
		return roadMatrix;
	}
}
