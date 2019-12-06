package travellingSalesman;


public class Road {
	
	private double distance;
	private City startCity; 
	private City nextCity;
	
	public Road(double distance, City startCity, City nextCity) {
		this.distance = distance; 
		this.startCity = startCity; 
		this.nextCity = nextCity; 
	}

	public double getDistance() {
		return distance;
	}

	public City getStartCity() {
		return startCity;
	}

	public City getNextCity() {
		return nextCity;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public void setStartCity(City startCity) {
		this.startCity = startCity;
	}

	public void setNextCity(City nextCity) {
		this.nextCity = nextCity;
	}
	
	
}
