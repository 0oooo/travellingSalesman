package travellingSalesman;

/**
 * This class is a map. 
 * It contains an array of all the cities and an array of all the roads. 
 */

public class Map {
	
	City[] cities; 
	double[][] roadMatrix; 
	int indexOfCity = 0; 
	
	Map(int numberOfCities){
		cities = new City[numberOfCities];
		roadMatrix = new double[numberOfCities][numberOfCities];
	}
	
	public City[] getCities() {
		if(cities.length > 0) {
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
			return false; 
		}
		return true; 
	}
	
	public void addCityToList(City city) {
		cities[indexOfCity] = city; 
		indexOfCity++; 
	}

	
	public double calculateDistanceCities(City city1, City city2) {		
		int x1 = city1.getX(); 
		int y1 = city2.getY(); 
		int x2 = city2.getX(); 
		int y2 = city2.getY();
		double side1, side2, side3; 
		
		side1 = x1 > x2 ? x1 - x2 : x2 - x1; 
		side2 = y1 > y2 ? y1 - y2 : y2 - y1; 
		
		if(x1 == x2) {
			return side2;
		}
		if(y1 == y2) {
			return side1;
		}

		side3 = Math.sqrt( Math.pow(side1, 2) + Math.pow(side2, 2)); 
		return side3; 
	}
	
	public void generateRoadMatrix() {
		for(int city = 0; city < cities.length; city++) {
			for(int nextCity = 0; nextCity < cities.length; nextCity++) {
				City city1 = cities[city];
				City city2 = cities[nextCity];
				double distance = calculateDistanceCities(city1, city2);
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

}
