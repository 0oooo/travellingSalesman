package travellingSalesman;

/**
 * Implementation of the Travelling Salesman Problem
 * This is the main class (with main method)
 * It reads the problem passed through the argument list: 
 * In eclipse, run configuration, in arguments add the path of the problem to be read
 * Example: "/Users/CC/Documents/CS/travellingSalesman/travellingSalesman/test1tsp.txt"
 * 
 * The class reads the file first and parse it into a "Map" class that contains: 
 * - all the cities
 * - the number of cities
 * - the number of possible paths
 * 
 * @author Camille
 *
 */

public class TravellingSalesman {

	static ProblemParser reader;
	static City[] cities; 
	static int numberOfPaths;
	static int numberOfCities;
	
	
	/**
	 * Read the file and parse it to a Map object (made for this project)
	 * The map is used to store information about the cities in one place  
	 * (array of cities, number of cities, number of path, a matrix of the paths (distance between 2 cities) that can be generated and used for debug purposes. 
	 * @param fileToRead is the argument passed through the main method.
	 */
	public static void readFile(String fileToRead) {
	
		reader = new ProblemParser(fileToRead);

		Map myMap = reader.getMap();
		cities = myMap.getCities();
		numberOfPaths = myMap.getNumberOfPaths();
		numberOfCities = myMap.getNumberOfCities() + 1; // + 1 because we have to go back to the first city

	}
	
	/**
	 *   Implementation of the DFS. Creates a Query object, initiate the the DFS, 
	 *   run the search with the Query object and print the result
	 *   The DFS also has a "printAllPath" method that can be used for debug purposes
	 */
	public static void doDFS(City[] cities, int numberOfPaths) {
		Query query = new Query(cities);
		DFS dfs = new DFS(numberOfPaths);
		Result result = dfs.search(query);
		result.printResult();
	}
	
	/**
	 *  Implementation of Dijkstra 
	 *  Initialise the problem reading, compute the shortest path and print it
	 */
	public static void doDijkstra(City[] cities) {
		
		System.out.println("Dijkstra");
		Dijkstra dijkstra = new Dijkstra(cities);
		dijkstra.computeShortestPath();
		dijkstra.printBestPath();
	}
	
	/**
	 * print the times to read the file, calculate the path with Depth First Search and calculate the path with Dijkstra algorithm
	 * @param timeToRead
	 * @param timeToDFS
	 * @param timeToDijsktra
	 */
	public static void printTime(long timeToRead, long timeToDFS, long timeToDijsktra) {
		System.out.println("It took " + timeToRead + " to read the file, " +
										timeToDFS + " to calcultate the path with Depth First Search and " + 
										timeToDijsktra + " to calculate the path with Dijkstra.");
	}
	
	/**
	 * Main method. 
	 * @param args to pass the test file, use the configuration (arrow next to run button)
	 */
	public static void main(String[] args) {

		long startTime = System.nanoTime();
		
		if (args.length > 0) {

			readFile(args[0]);
			long timeAfterReading = System.nanoTime() - startTime; 

			doDFS(cities, numberOfPaths);
			long timeAfterDFS = System.nanoTime() - timeAfterReading; 
		
			doDijkstra(cities);
			long timeAfterDijkstra = System.nanoTime() - timeAfterDFS; 
			
			printTime(timeAfterReading, timeAfterDFS, timeAfterDijkstra);
			
			
		} else {
			System.out.println("There was no test given.");
		}
	}

}
