package travellingSalesman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

/**
 * Implementation of the depth first search with recursion
 * Go through a full path, when it has found one, go backward to explore other path
 * Keeps track of the state of the exploration with Query Object
 * Keeps track of the best path and its best distance 
 * Also keeps track of all paths for debug purposes
 * @author Camille
 *
 */
public class DFS {

	private AllPaths allPaths; 

	/**
	 * Constructor
	 * initiate the all path that will keep track of all the paths discovered by DFS (for debug)
	 */
	public DFS() {
		allPaths = new AllPaths(); 
	}
	
	/**
	 * Takes a full path and add the first city back to it. 
	 * @param query: takes the current Query (state of the search) to get the path
	 * @return a Result with a full path and the full distance associated
	 */
	private Result finalisePath(Query query) {
		ArrayList<City> finalPath = new ArrayList<City>(query.getPath());
		City firstCity  = query.getPath().get(0);
		
		if(finalPath.get(finalPath.size() - 1) != finalPath.get(0))
			finalPath.add(firstCity); 
		
		double finalDistance = this.calculateDistance(finalPath);
		
		allPaths.addPath(finalPath);
		allPaths.addDistance(finalDistance);
					
		return new Result(finalDistance, finalPath);
	}
	
	
	/**
	 * Calculate all the distance between each cities in a path
	 * @param path is a list of cities
	 * @return the total distance 
	 */
	private double calculateDistance(ArrayList<City> path) {
		double distance = 0;
		for (int city = 1; city < path.size(); city++) {
			distance += path.get(city).calculateDistanceToCity(path.get(city - 1));
		}
		return distance;
	}
	
	/**
	 * At each iteration, it will take the state of the full cities and remove one from the list
	 * while adding it to the city to explore
	 * @param cities is a list of all cities
	 * @return a list of cities to explore
	 */
	private City[] findCitiesToExplore(City[] cities) {
		City[] citiesToExplore = Arrays.copyOf(cities, cities.length - 1);
		for(int city = 0; city < citiesToExplore.length; city++) {
			citiesToExplore[city] = cities[city + 1];
		}
		return citiesToExplore;
	}

	/**
	 * Core method based on recursion
	 * Creates a path and 2 sets (visited cities and cities yet to explore). 
	 * While there is still cities to explore, add them to the path and calculate the distance.   
	 * @param query contains the state of the current exploration (the path, cities to explore and cities left)
	 * @return a Result object (that associate the path and its distance). 
	 * Once a full path has been explore, cities are removed from the visited set, 
	 * while the recursion has made the cities available again.   
	 */
	public Result search(Query query) {
		
		double bestDistance = 0;
		ArrayList<City> path = query.getPath();
		Set<City> visitedSet = query.getVisited();
		Set<City> available = new HashSet<City>();
		ArrayList<City> bestPath = new ArrayList<City>();
		Set<City> citiesSet = new HashSet<City>(Arrays.asList(query.getCities()));

		// First iteration of the recursion. There are no city visited yet so we get all the cities
		// Add the first city to the path and generate our sets used to compare visited cities and cities to explore
		if (query.getVisited().isEmpty()) {
			City[] cities = query.getCities(); 
			path.add(cities[0]);
			
			citiesSet = new HashSet<City>(Arrays.asList(findCitiesToExplore(cities)));
			visitedSet = new HashSet<City>(query.getVisited());
		}
		
		available = citiesSet;
		available.removeAll(visitedSet);
		
		if (available.size() == 0) {
			return finalisePath(query);
		}

		for (City city : available) {
			
			visitedSet.add(city);
			path.add(city);
			
			// Recursively call the search with a copy of the query 
			Query copyQuery = new Query(query.getCities());
			copyQuery.setOverallBestDistance(0).setPath(path).setVisited(visitedSet);
			Result currentResult = search(copyQuery); 

			// if the current path is better update the current best and compare to the overall
			if (bestDistance == 0 || currentResult.getBestDistance() < bestDistance) {
				bestDistance = currentResult.getBestDistance();
				bestPath = currentResult.getBestPath();

				query.contestOverallBestDistance(bestDistance);
			}
			
			// We then go upward the exploratory tree by removing the last cities in path 
			// That allows to create a new path and compare it to the ones we already explored
			visitedSet.remove(city);
			path.remove(path.size() - 1);
		}
		return new Result(bestDistance, bestPath);
	}
	
	/**
	 * For testing purposes, we can print all the paths generated by the dfs
	 * @return AllPaths, a class with: 
	 * - a array of path (arrays of cities)
	 * - an array of distances 
	 */
	public AllPaths getAllPaths() {
		return allPaths;
	}

}
