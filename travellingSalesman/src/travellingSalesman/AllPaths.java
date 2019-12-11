package travellingSalesman;

import java.util.ArrayList;

public class AllPaths {
	
	private ArrayList<Double> costs;
	private ArrayList<ArrayList<City>> paths; 
	
	public AllPaths(int numberOfPaths) {
		costs = new ArrayList<Double>();
		paths = new ArrayList<ArrayList<City>>(); 
	}

	public ArrayList<Double> getAllCosts() {
		return costs;
	}

	public ArrayList<ArrayList<City>> getAllPaths() {
		return paths;
	}
	
	public void addPath(ArrayList<City> path) {
		paths.add(path);
	}
	
	public void addCost(double cost) {
		costs.add(cost);
	}
	
	
	public String getAllPathsWithCost() {
		String pathsCostString = ""; 
		
		for (int i = 0; i < paths.size(); i++) {
			pathsCostString += "Path: "; 
			for (City city : paths.get(i)) {
				pathsCostString += city.getId() + " "; 
			}
			pathsCostString += " -> Cost = " + costs.get(i) + "\n";
		}
		
		return pathsCostString; 
	}
	
	public void printAllPath() {
		System.out.println(this.getAllPathsWithCost());
	}

}
