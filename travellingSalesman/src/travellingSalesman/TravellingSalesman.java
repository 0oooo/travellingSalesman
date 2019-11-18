package travellingSalesman;

import java.util.ArrayList;
import java.util.Arrays;

public class TravellingSalesman {
	
	static ProblemParser reader; 
	
	public static void main(String[] args) {
		
		//My Attempt
//		if(args.length > 0) {
//			System.out.println("I have argument"); 
//			String path = args[0];			
//			reader = new ProblemParser(path);
//			
//			Map myMap = reader.getMap();
//			City[] cities = myMap.getCities();
//			int numberOfCities = myMap.getNumberOfCities();
//			int numberOfPaths = myMap.getNumberOfPaths(); 
//			DepthFirstSearch dfs = new DepthFirstSearch(numberOfCities, numberOfPaths);
//			
//			dfs.iterativeSearch(cities, cities[0]); 
//			
//			System.out.println("And the best cost is " + dfs.getBestCost());
//			System.out.println("For " + dfs.getBestPath().toString());
//			
//			reader.test();
//		}
		
		//Attempt with JS programming
		reader = new ProblemParser(args[0]);
		Map myMap = reader.getMap();
		ArrayList<City> cities = new ArrayList<City>(Arrays.asList(myMap.getCities()));
		int numberOfPaths = myMap.getNumberOfPaths(); 
		Query query = new Query( cities);
		DFS dfs = new DFS(numberOfPaths);
		Result result = dfs.search(query);
		
		AllPaths allPaths = dfs.getAllPaths();
		System.out.println(allPaths.getAllPathsWithCost());
		System.out.println("The best path is ");
		for(City city : result.getBestPath()) {
			System.out.print( " " + city.getId() + " "); 
		}
		System.out.println("The best cost is " + result.getBestCost());
		
		System.out.println("Working"); 
	}

}
