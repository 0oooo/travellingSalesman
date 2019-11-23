package travellingSalesman;

public class AllPaths {
	
	private double[] costs;
	private City[][] paths; 
	private int nextPath; 
	private int nextCost; 
	
	public AllPaths(int numberOfPaths) {
		costs = new double[numberOfPaths];
		paths = new City[numberOfPaths][]; 
		nextPath = 0; 
		nextCost = 0; 
	}

	public double[] getAllCosts() {
		return costs;
	}

	public City[][] getAllPaths() {
		return paths;
	}
	
	public void addPath(City[] path) {
		paths[nextPath] = path;
		nextPath++; 
	}
	
	public void addCost(double cost) {
		costs[nextCost] = cost; 
		nextCost++; 
	}
	
	
	public String getAllPathsWithCost() {
		String pathsCostString = ""; 
		
		for (int i = 0; i < paths.length; i++) {
			pathsCostString += "Path: "; 
			for (City city : paths[i]) {
				pathsCostString += city.getId() + " "; 
			}
			pathsCostString += " -> Cost = " + costs[i] + "\n";
		}
		
		return pathsCostString; 
	}

}
