package travellingSalesman;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Implementation of the famous Dijkstra algorithm. 
 * @author Dijkstra + implementation by Camille
 *
 */

public class Dijkstra {
	
	private Path bestPath; 
	private PriorityQueue<Path> queueOfPaths; 
	private City[] allCities; 
	private Set<City> allCitiesSet; 
	
	public Dijkstra (City[] allCities) {
		this.allCities = allCities; 
		bestPath = new Path(); 
		queueOfPaths = new PriorityQueue<>(new PathComparator());
		allCitiesSet = new HashSet<>(Arrays.asList(allCities));
	}
	
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
	
	private void extendPath(Path existingPath){
		City lastCityInPath = existingPath.getLastCityInPath(); 
		
		
		Set<City> visitedCityFromPath = new HashSet<>(existingPath.getVisitedCities()); 
//		
//		
//			System.out.println("Visited cities set: "); 
//			for(City city : visitedCityFromPath) {
//				System.out.print( city.getCityId() + " "); 
//			}
//			System.out.println("");
//			
		Set<City> availableCities = new HashSet<>(allCitiesSet); 
		availableCities.removeAll(visitedCityFromPath); 
//			
//			System.out.println("Available cities set: "); 
//			for(City city : availableCities) {
//				System.out.print( city.getCityId() + " "); 
//			}
//			System.out.println("");
			
		for(City nonVisitedCity : availableCities) {
//			System.out.println("Non visited city: " + nonVisitedCity.getCityId());
			Path newPath = new Path(existingPath); 
			
			newPath.addCityInPath(nonVisitedCity);
			newPath.addCityInVisitedSet(nonVisitedCity);
			
//					System.out.println("New Path : "); 
//					for(City city : newPath.getPath()) {
//						System.out.print( city.getCityId() + " "); 
//					}
//					System.out.println("");
			
			double distanceBetweenLastCities = lastCityInPath.calculateDistanceToCity(nonVisitedCity); 
			newPath.addToGlobalDistance(distanceBetweenLastCities);
			queueOfPaths.add(newPath);
		}
	}
	
	private void initQueueOfPath() {
		Path firstPath = new Path(allCities[0]);
		extendPath(firstPath);
	}
	
	private boolean areAllCitiesIn(Path pathToTest) {
		Set<City> visited = new HashSet<>(pathToTest.getVisitedCities()); 
		Set<City> allCities = new HashSet<>(allCitiesSet);
		allCities.removeAll(visited); 
		return allCities.isEmpty();
	}
	
	public void computeShortestPath() {
		//We create the first paths from the first city in the array and put them in the queue
		initQueueOfPath(); 
		
		Path pathToCheck = new Path(); 
		
		while(!pathToCheck.isCompletedPath()) {
			if(areAllCitiesIn(pathToCheck)) {
				System.out.println("Completed path: " + getPathAsString(pathToCheck) + " -> " + pathToCheck.getDistanceFromFirstCity());
				addBackToFirstCity(pathToCheck); 
			}else {
				extendPath(pathToCheck); 
			}
			pathToCheck = new Path(queueOfPaths.poll());
		}
		
//		//
//		do {
//			pathToCheck = new Path(queueOfPaths.poll());
//			
//			
////				System.out.println("Path to check: ");
////				for(City city : pathToCheck.getPath()) {
////					System.out.print(city.getCityId() + " ");
////				}
////				System.out.println("Is completed? " + pathToCheck.isCompletedPath());
////				System.out.println("");
//
//	
//			// The TSP needs to go back to its origin city so if all cities are in the path, 
//			// we need to add back the first city 
//			if(areAllCitiesIn(pathToCheck)) {
//				System.out.println("Completed path: " + getPathAsString(pathToCheck) + " -> " + pathToCheck.getDistanceFromFirstCity());
//				addBackToFirstCity(pathToCheck); 
//			}else{
//				extendPath(pathToCheck); 
//			}
//			
//		} while(!pathToCheck.isCompletedPath());
		
		bestPath = pathToCheck;  
	}
	
	private void printAllPathsInQueue() {
		for(Path path : queueOfPaths) {
			System.out.print("Path: " + getPathAsString(path));
			System.out.println(" ---> " + path.getDistanceFromFirstCity());
		}
	}
	
	private void printAllCompletedPathsInQueue() {
		for(Path path : queueOfPaths) {
			if(path.isCompletedPath()) {
				System.out.print("Path: " + getPathAsString(path));
				System.out.println(" ---> " + path.getDistanceFromFirstCity());
			}
		}
	}
	
	public Path getBestPath() {
		return bestPath; 
	}
	
	private String getPathAsString(Path path) {
		String bestPathString = ""; 
		for(City city : path.getPath()) {
			bestPathString += city.getCityId() + " ";
		}
		return bestPathString; 
	}
	
	public void printBestPath() {
		System.out.println("The best path is " + getPathAsString(bestPath));
		System.out.println("Its cost is " + bestPath.getDistanceFromFirstCity());
	}

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
