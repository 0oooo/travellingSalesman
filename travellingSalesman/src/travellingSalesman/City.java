package travellingSalesman;

public class City {

	private int[] coordinates = new int[2];
	private int cityId; 
	private int x; 
	private int y; 
	
	
	
	City(int cityId, int x, int y){
		this.cityId = cityId;
		this.x = x; 
		this.y = y;
		coordinates[0] = x; 
		coordinates[1] = y;
	}
	
	public int[] getCoordinates() {return coordinates;} 
	
	public int getId() {return cityId;}
	
	public int getX() {return x;}
	
	public int getY() {return y;}
	
	
	public double calculateDistanceCities(City city2) {
			
		int x1 = this.getX(); 
		int y1 = this.getY(); 
		int x2 = city2.getX(); 
		int y2 = city2.getX();
		double side1, side2, side3; 
		
		side1 = x1 > x2 ? x1 - x2 : x2 - x1; 
		side2 = y1 > y2 ? y1 - y2 : y2 - y1; 
		
		if(x1 == x2) {
			return side2;
		}
		if(y1 == y2) {
			return side1;
		}

		side3 = Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2)); 
		return side3; 
	}
}