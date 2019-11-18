package oldVersion;

import java.util.Stack;

import travellingSalesman.City;

public class DepthFirstSearch {
	
	private Stack<City> treeExplorerStack;
	private City[][] allPaths;
	private double bestCost;
	private double currentBestCost; 
	private City[] bestPath; 
	private int numberOfCities;  
	
	
	public DepthFirstSearch(int numberOfCities, int numberOfPath){
		this.numberOfCities = numberOfCities + 1; 
		treeExplorerStack = new Stack<City>();
		bestCost = 0; 
		currentBestCost = -1; 
		allPaths = new City[numberOfPath][numberOfCities];
		bestPath = new City[this.numberOfCities];
	}

//	public void iterativeSearchHelper(City[] cities){
//		City[] tempBestPath = new City[numberOfCities];
//		for(City[] path : allPaths) {
//			// a side effect of iterativeSearch is to change the tempBestCost
//			tempBestPath = iterativeSearch(path, cities[0]); 
//			
//			 if(bestCost == 0 || currentBestCost <= bestCost) {
//				bestPath = tempBestPath;
//				bestCost = currentBestCost; 
//			}
//		}
//	}
//	
//	private void generateAllPath(City[] cities) {
//		City[] firstPath = new City[numberOfCities];
//		City[] oldPath = firstPath; 
//		for(int path = 1; path < allPaths.length; path++) {
//			City[] newPath = permutePaths(oldPath, 0);
//			oldPath = newPath; 
//			allPaths[path] = newPath; 
//		}
//	}
//	
//	private void swap(City[] path, int a, int b) {
//		City tmp = path[a];
//		path[a] = path[b];
//		path[b] = tmp;
//	}
//	
//	private void permutePaths(City[] path, int k) {
//		
//		for(int i = k; i < path.length; i++){
//            swap(path, i, k);
//            permutePaths(path, k+1);
//            swap(path, k, i);
//        }
//        if (k == path.length -1){
//            return;
//        }
//		
//	}
	
	public City[] iterativeSearch(City[] cities, City currentCity) {
		
		City firstCity = currentCity; 
		City lastCity = currentCity; 		
		City[] path = new City[numberOfCities];
		int cityIndex = 0; 
		treeExplorerStack.push(currentCity);
		
		while (!treeExplorerStack.isEmpty()) {
			currentCity = treeExplorerStack.pop();
			
			if(!currentCity.isVisited()) {
				double distance = lastCity.calculateDistanceToCity(currentCity);
				currentBestCost += distance; 
				
				path[cityIndex] = currentCity; 
				cityIndex++;
				
				currentCity.setVisited(true);
				for(City city : cities) {
					treeExplorerStack.push(city);
				}
			}
		}
		path[cityIndex] = firstCity;
		return path;
	}

	public double getBestCost() {
		return bestCost;
	}

	public City[] getBestPath() {
		return bestPath;
	}

	
	

}
