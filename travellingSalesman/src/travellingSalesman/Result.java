package travellingSalesman;

import java.util.ArrayList;

public class Result {
	
	private double bestCost; 
	private ArrayList<City> bestPath; 
	
	public Result() {
		bestCost = 0; 
		bestPath = new ArrayList<City>();
	}
	
	public Result(double bestCost, ArrayList<City> bestPath) {
		this.bestCost = bestCost; 
		this.bestPath = bestPath; 
	}

	public double getBestCost() {
		return bestCost;
	}

	public ArrayList<City> getBestPath() {
		return bestPath;
	}

	public void setBestCost(double bestCost) {
		this.bestCost = bestCost;
	}

	public void setBestPath(ArrayList<City> bestPath) {
		this.bestPath = bestPath;
	}
	
	

}
