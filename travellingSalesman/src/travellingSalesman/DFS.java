package travellingSalesman;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class DFS {

	private AllPaths allPaths; 
	private int numberOfCities; 
	private int cityPosition;

	public AllPaths getAllPaths() {
		return allPaths;
	}

	public DFS(int numberOfPaths, int numberOfCities) {
		this.numberOfCities = numberOfCities;
		
		// used as an index for the city added to the path. 
		// starts as 1 because the first city of the path is allocated straight as the first city of the list of cities 
		cityPosition = 1; 
		
		allPaths = new AllPaths(numberOfPaths); 
	}

	public Result search(Query query) {
		
		
//					System.out.println("---------------------------------------" );
//					System.out.println("Begining of the function" );
//					System.out.print("Cities = [" );
//					for(City city : query.getCities()) {
//						System.out.print(" " + city.getId() + " ");
//					}
//					System.out.println("]"); 
					
		Set<City> citiesSet = new HashSet<City>(Arrays.asList(query.getCities()));
		Set<City> visitedSet = query.getVisited();
		City[] path = query.getPath();

		if (query.getVisited().isEmpty()) {
			City[] cities = query.getCities(); 
			path[0] = cities[0];
			
			City[] citiesToExplore = Arrays.copyOf(cities, cities.length - 1);
			for(int city = 0; city < citiesToExplore.length; city++) {
				citiesToExplore[city] = cities[city + 1];
			}
			
			query.setCities(citiesToExplore);
			
			citiesSet = new HashSet<City>(Arrays.asList(citiesToExplore));
			visitedSet = new HashSet<City>(query.getVisited());
		}
		
//					System.out.print("Path = [" );
//					for(City city7 : path) {
//						if(city7 == null) {
//							break;
//						}
//						System.out.print(" " + city7.getId() + " ");
//					}
//					System.out.println("]"); 
//		
//		
//					System.out.print("CitiesSet = {" );
//					for(City city : citiesSet) {
//						System.out.print(" " + city.getId() + " ");
//					}
//					System.out.println("}"); 

		Set<City> available = new HashSet<City>();
		available = citiesSet;
		available.removeAll(visitedSet);
		
//					System.out.print("Available = {" );
//					for(City city : available) {
//						System.out.print(" " + city.getId() + " ");
//					}
//					System.out.println("}"); 

		//
		if (available.size() == 0) {
						
			
			City[] finalPath = query.getPath().clone();
			City firstCity  = query.getPath()[0];
			finalPath[numberOfCities -1] = firstCity;
			
			double finalCost = this.calculateCost(finalPath);
			
//						System.out.println("!!!!!!  New Path! !!!!!!!");
//						System.out.print("FinalPath = ["); 
//						for(City city : finalPath) {
//							System.out.print(" " + city.getId() + " ");
//						}
//						System.out.println("]"); 
//						System.out.println("And my cost is " + finalCost);
			
			allPaths.addPath(finalPath);
			allPaths.addCost(finalCost);
						
			return new Result(finalCost, finalPath);
		}

		double bestCost = 0;
		City[] bestPath = new City[numberOfCities];

		for (City city : available) {
			
			visitedSet.add(city);
			path[cityPosition] = city;
			cityPosition++; 
			
//						System.out.println("For each city in available.."); 
//						
//						System.out.println("VisitedSet += " + city.getId()); 
//						System.out.println("Pth +=" + city.getId()); 
//						
//						System.out.print("VisitedSed = {");
//						for(City city1 : visitedSet) {
//							System.out.print(" " + city1.getId() + " ");
//						}
//						System.out.println("}"); 
//						System.out.print("Path = [");
//						for(City city0 : path) {
//							if(city0 == null) {
//								break;
//							}
//							System.out.print(" " + city0.getId() + " ");
//						}
//						System.out.println("]"); 
			
			
			Query copyQuery = new Query(query.getCities(), numberOfCities);
			copyQuery.setOverallBest(0).setPath(path).setVisited(visitedSet);

			Result currentResult = this.search(copyQuery);
			
//						System.out.println("we're back from recursion");
//						System.out.print("Path From result = [");
//						for(City city2 : currentResult.getBestPath()) {
//							System.out.print(" " + city2.getId() + " ");
//						}
//						System.out.println("]");
//						System.out.print("Path where we are = [");
//						for(City city2 : path) {
//							if(city2 == null) {
//								break;
//							}
//							System.out.print(" " + city2.getId() + " ");
//						}
//						System.out.println("]");
//						System.out.print("Available = {");
//						for(City city12 : available) {
//							System.out.print(" " + city12.getId() + " ");
//						}
//						System.out.println("}");
//						System.out.print("Visited = {");
//						for(City city13 : visitedSet) {
//							System.out.print(" " + city13.getId() + " ");
//						}
//						System.out.println("}");

			// if that path is better, keep it
			if (bestCost == 0 || currentResult.getBestCost() < bestCost) {
				bestCost = currentResult.getBestCost();
				bestPath = currentResult.getBestPath();

				if (query.getOverallBest() == 0 || bestCost < query.getOverallBest()) {
					// found a new best complete path
					query.setOverallBest(bestCost);
				}
			}
			
			visitedSet.remove(city);
			
			// remove the last city from the path 
			City[] newPath = Arrays.copyOf(path, path.length);
			for(int visitedCity = 0; visitedCity < path.length - 1; visitedCity++) {
				newPath[visitedCity] = path[visitedCity + 1];
			}
			cityPosition--;
			
//						System.out.println("After the removal");
//						System.out.print("Path = [");
//						for(City city2 : path) {
//							if(city2 == null) {
//								break;
//							}
//							System.out.print(" " + city2.getId() + " ");
//						}
//						System.out.println("]");
//						System.out.print("visitedSed = [");
//						for(City city11 : visitedSet) {
//							System.out.print(" " + city11.getId() + " ");
//						}
//						System.out.println("]");
		}

		return new Result(bestCost, bestPath);
	}

	public double calculateCost(City[] path) {
		double cost = 0;
		for (int city = 1; city < path.length; city++) {
			cost += path[city].calculateDistanceToCity(path[city - 1]);
		}
		return cost;
	}

}
