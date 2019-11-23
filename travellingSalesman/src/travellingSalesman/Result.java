package travellingSalesman;

public class Result {
	
	private double bestCost; 
	private City[] bestPath; 
	private int numberOfCityInPath; 
	
	public Result(int numberOfCity) {
		numberOfCityInPath = numberOfCity + 1; 
		bestCost = 0; 
		bestPath = new City[numberOfCityInPath];
	}
	
	public Result(double bestCost, City[] bestPath) {
		this.bestCost = bestCost; 
		this.bestPath = bestPath; 
	}

	public double getBestCost() {
		return bestCost;
	}

	public City[] getBestPath() {
		return bestPath;
	}

	public void setBestCost(double bestCost) {
		this.bestCost = bestCost;
	}

	public void setBestPath(City[] bestPath) {
		this.bestPath = bestPath;
	}
	
	public String getBestPathString() {
		String bestPathString = "Best Path = "; 
		
		for(City city : bestPath) {
			bestPathString += city.getId() + " ";
		}
		
		return bestPathString; 
	}

}
