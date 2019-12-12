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
	
	public double calculateDistanceToCity( City city2) {		
		int x1 = this.getHorizontalCoordinate(); 
		int y1 = this.getVerticalCoordinate(); 
		int x2 = city2.getHorizontalCoordinate(); 
		int y2 = city2.getVerticalCoordinate();
		double side1, side2, side3; 
		
		side1 = x2 - x1; 
		side2 = y2 - y1; 
		
		side3 = Math.sqrt( Math.pow(side1, 2) + Math.pow(side2, 2)); 
		return side3; 
	}

	/**
	 * Getter
	 * @return the id of the city (integer)
	 */
	public int getCityId() {
		return cityId;
	}
	
}
