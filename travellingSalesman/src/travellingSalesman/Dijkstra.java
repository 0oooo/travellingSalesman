package travellingSalesman;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Implementation of the famous Dijkstra algorithm. 
 * Creates a queue of paths sorted by their cost (distance between all cities) 
 * Grab the first path from the queue and extend it 
 * (add a city it doesn't have it, calculate the new distance, and add it back to the queue)
 * Stops when the first element in the queue is a full path 
 * @author Dijkstra + implementation by Camille
 *
 */

public class Dijkstra {
	
	private Path bestPath; 
	private PriorityQueue<Path> queueOfPaths; 
	private City[] allCities; 
	private Set<City> allCitiesSet; 
	
	/**
	 * Constructor. 
	 * Initialise the best path and a city set that is used to compare what cities are left to explore
	 * Create a queue with its own comparator that uses the distance from first city for each path. 
	 * @param allCities is an array of all cities
	 */
	public Dijkstra (City[] allCities) {
		this.allCities = allCities; 
		bestPath = new Path(); 
		allCitiesSet = new HashSet<>(Arrays.asList(allCities));
		queueOfPaths = new PriorityQueue<>(new PathComparator());
	}
	
	/**
	 * Once a path is full, we add the first city at the end, calculate the distance with its last city, 
	 * set it to completed and add it back to the queue. 
	 * @param existingPath is the path we are adding the city to
	 */
	private void addBackToFirstCity(Path existingPath) {
		City lastCityInPath = existingPath.getLastCityInPath(); 
		City firstCityInPath = existingPath.getFirstCityInPath(); 
		
		Path completePath = existingPath; 
		completePath.addCityInPath(firstCityInPath);
		double distanceBetweenLastCities = lastCityInPath.calculateDistanceToCity(firstCityInPath);
		completePath.addToGlobalDistance(distanceBetweenLastCities);
		completePath.setCompletedPath(true);
		queueOfPaths.add(completePath);
	}
	
	/**
	 * Takes a path, check all the cities that are not in it and creates new path, one per city we are adding to it
	 * (for example, Path 1 - 2 does not have City 3 and City 4, it will create Path 1 - 2 - 3 and Path 1 - 2 - 4 
	 * @param existingPath is the path to update
	 * All paths are added back to the queue. 
	 */
	private void extendPath(Path existingPath){
		City lastCityInPath = existingPath.getLastCityInPath(); 
		
		
		Set<City> visitedCityFromPath = new HashSet<>(existingPath.getVisitedCities()); 
			
		Set<City> availableCities = new HashSet<>(allCitiesSet); 
		availableCities.removeAll(visitedCityFromPath); 
			
		for(City nonVisitedCity : availableCities) {
//			System.out.println("Non visited city: " + nonVisitedCity.getCityId());
			Path newPath = new Path(existingPath); 
			
			newPath.addCityInPath(nonVisitedCity);
			newPath.addCityInVisitedSet(nonVisitedCity);
			
			double distanceBetweenLastCities = lastCityInPath.calculateDistanceToCity(nonVisitedCity); 
			newPath.addToGlobalDistance(distanceBetweenLastCities);
			queueOfPaths.add(newPath);
		}
	}
	
	/**
	 * Initialisation: We create a first path with the first city and we extend it with all the other cities in the list 
	 */
	private void initQueueOfPath() {
		Path firstPath = new Path(allCities[0]);
		extendPath(firstPath);
	}
	
	/**
	 * Check if the path has visited all the cities by comparing sets
	 * @param pathToTest is the path to test
	 * @return true if all the cities are visited, false otherwise
	 */
	private boolean areAllCitiesIn(Path pathToTest) {
		Set<City> visited = new HashSet<>(pathToTest.getVisitedCities()); 
		Set<City> allCities = new HashSet<>(allCitiesSet);
		allCities.removeAll(visited); 
		return allCities.isEmpty();
	}
	
	/**
	 * Core method.
	 * Start the first paths to be added in the queue
	 * While a path is grabbed from the top of the queue and marked as complete, it extends the path
	 * When a path is marked as complete, it is the best path. 
	 */
	public void computeShortestPath() {
		//We create the first paths from the first city in the array and put them in the queue
		initQueueOfPath(); 
		
		Path pathToCheck = new Path(); 
		
		while(!pathToCheck.isCompletedPath()) {
			if(pathToCheck.getPath() != null && !pathToCheck.getPath().isEmpty()) {
				
				// As we are using sets to check if a path is complete, we need to add the first city back after doing a check 
				if(areAllCitiesIn(pathToCheck)) {
					addBackToFirstCity(pathToCheck); 
				}else {
					extendPath(pathToCheck); 
				}
			}
			pathToCheck = new Path(queueOfPaths.poll());
		}
		
		bestPath = pathToCheck;  
	}
	
	/**
	 * Getter
	 * @return the best path
	 */
	public Path getBestPath() {
		return bestPath; 
	}
	
	/**
	 * Getter for the best path as string
	 * @param path 
	 * @return a string representing the path
	 */
	private String getPathAsString(Path path) {
		String bestPathString = ""; 
		for(City city : path.getPath()) {
			bestPathString += city.getCityId() + " ";
		}
		return bestPathString; 
	}
	
	/**
	 * print the best path
	 */
	public void printBestPath() {
		System.out.println("The best path is " + getPathAsString(bestPath));
		System.out.println("Its cost is " + bestPath.getDistanceFromFirstCity());
	}
	
	/**
	 * @Class used by the priority queue to know what value to use 
	 * to compare the path inside the queue
	 * @author Camille
	 *
	 */
	class PathComparator implements Comparator<Path> {
		public int compare(Path path1, Path path2) {
			if(path1.getDistanceFromFirstCity() < path2.getDistanceFromFirstCity())
				return -1; 
			else if(path1.getDistanceFromFirstCity() > path2.getDistanceFromFirstCity())
				return 1; 
					return 0; 
		}
	}

}
