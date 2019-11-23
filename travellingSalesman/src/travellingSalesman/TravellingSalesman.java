package travellingSalesman;

public class TravellingSalesman {
	
	static ProblemParser reader; 
	
	public static void main(String[] args) {
		
		if(args.length > 0) {
			reader = new ProblemParser(args[0]);
			
			Map myMap = reader.getMap();
			
			City[] cities = myMap.getCities();
			int numberOfPaths = myMap.getNumberOfPaths(); 
			int numberOfCities = myMap.getNumberOfCities() + 1; // + 1 because we have to go back to the first city
			
			Query query = new Query(cities, numberOfCities);
			DFS dfs = new DFS(numberOfPaths, numberOfCities);
			Result result = dfs.search(query);
			
			AllPaths allPaths = dfs.getAllPaths();	
			System.out.println(allPaths.getAllPathsWithCost());
			System.out.println("The best path is " + result.getBestPathString());
			System.out.println("The best cost is " + result.getBestCost());
		}
		else {
			System.out.println("There was no test given."); 
		}
	}

}
