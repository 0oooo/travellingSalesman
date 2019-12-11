package travellingSalesman;


public class Road {
	
	private double distanceBetweenCities;
	private City startCity; 
	private City nextCity;
	
	public Road(City startCity, City nextCity, double distance) {
		this.distanceBetweenCities = distance; 
		this.startCity = startCity; 
		this.nextCity = nextCity; 
	}

	public double getDistanceBetweenCities() {
		return distanceBetweenCities;
	}

	public City getStartCity() {
		return startCity;
	}

	public City getNextCity() {
		return nextCity;
	}

	public void setDistanceBetweenCities(double distance) {
		this.distanceBetweenCities = distance;
	}

	public void setStartCity(City startCity) {
		this.startCity = startCity;
	}

	public void setNextCity(City nextCity) {
		this.nextCity = nextCity;
	}
	
	
}
