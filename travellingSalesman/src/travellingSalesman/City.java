package travellingSalesman;

public class City {

	private int cityId; 
	private int horizontalCoordinate; 
	private int verticalCoordinate; 
	
	private boolean visited; 
	
	
	public City() {}
	
	public City(int cityId, int xCoordinate, int yCoordinate){
		this.cityId = cityId;
		this.horizontalCoordinate = xCoordinate; 
		this.verticalCoordinate = yCoordinate;
	}
	
	public int getId() {return cityId;}
	
	public int getHorizontalCoordinate() {return horizontalCoordinate;}
	
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

	public int getCityId() {
		return cityId;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public void setHorizontalCoordinate(int horizontalCoordinate) {
		this.horizontalCoordinate = horizontalCoordinate;
	}

	public void setVerticalCoordinate(int verticalCoordinate) {
		this.verticalCoordinate = verticalCoordinate;
	}
	
}
