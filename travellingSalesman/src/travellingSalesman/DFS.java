package travellingSalesman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class DFS {

	private int numberOfPaths;
	private AllPaths allPaths; 

	public AllPaths getAllPaths() {
		return allPaths;
	}

	public DFS(int numberOfPaths) {
		this.numberOfPaths = numberOfPaths;
		allPaths = new AllPaths(); 
	}

	public Result search(Query query) {
		
		
//					System.out.println("---------------------------------------" );
//					System.out.println("Begining of the function" );
//					System.out.print("Points = [" );
//					for(City city : query.getPoints()) {
//						System.out.print(" " + city.getId() + " ");
//					}
//					System.out.println("]"); 
					
		Set<City> pointsSet = new HashSet<City>(query.getPoints());
		Set<City> visitedSet = query.getVisited();
		ArrayList<City> path = query.getPath();

		if (query.getVisited().isEmpty()) {
			path.add(query.getPoints().get(0));
			query.getPoints().remove(0);
			pointsSet = new HashSet<City>(query.getPoints());
			visitedSet = new HashSet<City>(query.getVisited());
		}
		
//					System.out.print("Path = [" );
//					for(City city7 : path) {
//						System.out.print(" " + city7.getId() + " ");
//					}
//					System.out.println("]"); 
//		
//		
//					System.out.print("PointSet = {" );
//					for(City city : pointsSet) {
//						System.out.print(" " + city.getId() + " ");
//					}
//					System.out.println("}"); 

		Set<City> available = new HashSet<City>();
		available = pointsSet;
		available.removeAll(visitedSet);
//					System.out.print("Available = {" );
//					for(City city : available) {
//						System.out.print(" " + city.getId() + " ");
//					}
//					System.out.println("}"); 

		//
		if (available.size() == 0) {
						
			ArrayList<City> finalPath = (ArrayList<City>) query.getPath().clone();
			City firstCity  = query.getPath().get(0);
			finalPath.add(firstCity);
			
			double finalCost = this.calculateCost(finalPath);
			
//						System.out.println("!!!!!!  New Path! !!!!!!!");
//						System.out.print("FinalPath = ["); 
//						for(City city : finalPath) {
//							System.out.print(" " + city.getId() + " ");
//						}
//						System.out.println("]"); 
//						System.out.print(">>>>>>>>>>>>>>>>>Old path2 = ["); 
//						for(City city111 : query.getPath()) {
//							System.out.print(" " + city111.getId() + " ");
//						}
//						System.out.println("]"); 
//						System.out.println("And my cost is " + finalCost);
			
			allPaths.addPath(finalPath);
			allPaths.addScore(finalCost);
						
			return new Result(finalCost, finalPath);
		}

		double bestCost = 0;
		ArrayList<City> bestPath = new ArrayList<City>();

		for (City city : available) {
			
			visitedSet.add(city);
			path.add(city);		
			
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
//							System.out.print(" " + city0.getId() + " ");
//						}
//						System.out.println("]"); 
			
			
			Query copyQuery = new Query(query.getPoints());
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
			path.remove(path.size() - 1);
			
//			System.out.println("After the removal");
//			System.out.print("Path = [");
//			for(City city2 : path) {
//				System.out.print(" " + city2.getId() + " ");
//			}
//			System.out.println("]");
//			System.out.print("visitedSed = [");
//			for(City city11 : visitedSet) {
//				System.out.print(" " + city11.getId() + " ");
//			}
//			System.out.println("]");
		}

		return new Result(bestCost, bestPath);
	}

	public double calculateCost(ArrayList<City> path) {
		double cost = 0;
		for (int city = 1; city < path.size(); city++) {
			cost += path.get(city).calculateDistanceToCity(path.get(city - 1));
		}
		return cost;
	}

}
