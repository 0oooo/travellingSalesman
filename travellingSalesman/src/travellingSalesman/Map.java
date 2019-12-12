package travellingSalesman;

/**
 * This is a Map of the cities and roads generated from the file.  
 * It contains: 
 * - an array of all the cities, 
 * - the number of cities 
 * - the number of possible paths
 */

public class Map {
	
	private City[] cities; 
	private double[][] pathsMatrix; 
	private int indexOfCity = 0; 
	private int numberOfCities; 
	private int numberOfPaths; 
	
	/**
	 * Constructor of the Map
	 * @param numberOfCities originally comes from the number of lines in the file
	 * Is used to generates the array of cities, and the 2 dimensional array (matrix of path)
	 */
	public Map(int numberOfCities){
		cities = new City[numberOfCities];
		this.numberOfCities = numberOfCities; 
		pathsMatrix = new double[numberOfCities][numberOfCities];
		numberOfPaths = calculateNumberOfPaths(this.numberOfCities); 
	}
	
	/**
	 * Getter of the cities
	 * @return the array of cities only if its not empty, returns null otherwise
	 */
	public City[] getCities() {
		if(!isEmpty()) {
			return cities; 
		}
		return null; 
	}
	
	/**
	 * Check the array of cities
	 * @return true if the array of cities is not empty, false otherwise
	 */
	public boolean isEmpty() {
		if (cities.length > 0) {
			return false; 
		}
		return true; 
	}
	
	/**
	 * Add a city to the array of cities. Keep track of the index of the array of cities 
	 * @param city: instance of an object City
	 */
	public void addCityToList(City city) {
		cities[indexOfCity] = city; 
		indexOfCity++; 
	}
	
	/**
	 * Getter 
	 * @return the total number of cities
	 */
	public int getNumberOfCities() {
		return numberOfCities; 
	}
	
	/**
	 * Calculate the number of paths thanks to the number of city
	 * Can be used by algorithms, especially when using arrays
	 * as the capacity needs to be set at creation time 
	 * @param numberOfCity integer of number of city
	 * @return an integer of number of roads
	 */
	public int calculateNumberOfPaths(int numberOfCity) {
		int roads = 0; 
		int copyNumberOfCities = numberOfCity;
		for(int city = copyNumberOfCities; city > 0; city--) {		
			roads += --copyNumberOfCities; 
		}
		return roads; 
	}
	
	/**
	 * Getter of number of paths
	 * @return how many possible paths can be generated 
	 */
	public int getNumberOfPaths() {
		return numberOfPaths; 
	}
	
	
	/**
	 * Generate a matrix of paths. Can be used by an algorithm or just for debug purposes: 
	 * 
	 * 		1		2	 	3		4
	 * 1	x		7.1 	6.2  	2.1
	 * 2	7.1		x		9.0		5.2
	 * 3	6.2		9.0		x		4.4
	 * 4	2.1		5.2		4.4		x
	 * 
	 */
	public void generatePathsMatrix() {
		for(int city = 0; city < cities.length; city++) {
			for(int nextCity = 0; nextCity < cities.length; nextCity++) {
				City city1 = cities[city];
				City city2 = cities[nextCity];
				double distance = city1.calculateDistanceToCity(city2);
				pathsMatrix[city][nextCity] = distance; 
			}
		}
	}
	
	/**
	 * Print the matrix for debug purposes
	 */
	public void printPathsMatrix() {
		for(double[] road : pathsMatrix ) {
			System.out.print("[");
			for(double distance : road) {
				System.out.print(distance + "  ");
			}
			System.out.println("]");
		}
	}

	/**
	 * Getter
	 * @return the paths matrix (an array of array of double)
	 */
	public double[][] getPathsMatrix(){
		return pathsMatrix;
	}
}
