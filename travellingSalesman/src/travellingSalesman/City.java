package travellingSalesman;


/**
 * @Class City Object is made of an id, a x coordinate and a y coordinate. 
 * Its main method is to calculate the distance between itself and another city
 * @author Camille
 *
 */
public class City {

	private int cityId; 
	private int horizontalCoordinate; 
	private int verticalCoordinate; 
	
	/**
	 * Empty constructor used by Nearest Neighbour
	 */
	public City() {}
	
	/**
	 * Main constructor that takes:
	 * @param cityId: an integer to identify the city
	 * @param xCoordinate: an integer for the x coordinate
	 * @param yCoordinate: an integer for the y coordinate
	 */
	public City(int cityId, int xCoordinate, int yCoordinate){
		this.cityId = cityId;
		this.horizontalCoordinate = xCoordinate; 
		this.verticalCoordinate = yCoordinate;
	}
	
	/**
	 * Getter
	 * @return the x position of the city
	 */
	public int getHorizontalCoordinate() {return horizontalCoordinate;}
	
	/**
	 * Getter
	 * @return the y position of the city
	 */
	public int getVerticalCoordinate() {return verticalCoordinate;}
	
	public double calculateDistanceToCity( City nextCity) {		
		int xCoordinateThisCity = this.getHorizontalCoordinate(); 
		int yCoordinateThisCity = this.getVerticalCoordinate(); 
		int xCoordinateNextCity = nextCity.getHorizontalCoordinate(); 
		int yCoordinateNextCity = nextCity.getVerticalCoordinate();
		
		double horizontalDistance, verticalDistance, distanceBetweenCities; 
		
		horizontalDistance = xCoordinateNextCity - xCoordinateThisCity; 
		verticalDistance = yCoordinateNextCity - yCoordinateThisCity; 
		
		distanceBetweenCities = Math.sqrt( Math.pow(horizontalDistance, 2) + Math.pow(verticalDistance, 2)); 
		
		return distanceBetweenCities; 
	}

	/**
	 * Getter
	 * @return the id of the city (integer)
	 */
	public int getCityId() {
		return cityId;
	}
	
}
