package travellingSalesman;

import java.util.ArrayList;

public class AllPaths {
	
	private ArrayList<Double> costs;
	private ArrayList<ArrayList<City>> paths; 
	
	public AllPaths() {
		costs = new ArrayList<Double>();
		paths = new ArrayList<ArrayList<City>>(); 
	}

	public ArrayList<Double> getAllScores() {
		return costs;
	}

	public ArrayList<ArrayList<City>> getAllPaths() {
		return paths;
	}
	
	public void addPath(ArrayList<City> path) {
		paths.add(path);
	}
	
	public void addScore(double score) {
		costs.add(score);
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

}
