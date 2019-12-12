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
	public static void doDFS(City[] cities) {
		Query query = new Query(cities);
		DFS dfs = new DFS();
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
	
	public static void doRandom(City[] cities) {
		RandomPathGenerator random = new RandomPathGenerator(cities); 
		random.printPathAndDistance();
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
			System.out.println("It took " + timeAfterReading + " nanoseconds to read the file, ");
			
			if (numberOfCities < 12) {
				
				doDFS(cities);
				long timeAfterDFS = System.nanoTime() - timeAfterReading; 
				System.out.println("It took " + timeAfterDFS + " nanoseconds to calculate the path with DFS.");
			
				doDijkstra(cities);
				long timeAfterDijkstra = System.nanoTime() - timeAfterDFS;
				System.out.println("It took " + timeAfterDijkstra + " nanoseconds to calculate the path with Dijkstra.");
			}
			else if(numberOfCities < 20) {
				doDijkstra(cities);
				long timeAfterDijkstra = System.nanoTime() - timeAfterReading;
				System.out.println("It took " + timeAfterDijkstra + " nanoseconds to calculate the path with Dijkstra.");
			}
			else {
				doRandom(cities);
				long timeAfterRandom = System.nanoTime() - timeAfterReading; 
				System.out.println("It took " + timeAfterRandom + " nanoseconds to generate this path.");
			}
			
		} else {
			System.out.println("There was no test given.");
		}
	}

}
