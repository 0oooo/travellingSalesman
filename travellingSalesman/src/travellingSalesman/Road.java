//package travellingSalesman;
//
///**
// * This class is road
// * It contains two cities and the distance between those 2 cities.  
// */
//
//public class Road {
//	
//	Object[] road;
//	
//	Road(City city1, City city2){
//		road = new Object[3];
//		double distance = city1.calculateDistanceCities(city2);
//		road[0] = city1; 
//		road[1] = city2;
//		road[2] = distance; 
//	}
//	
//	public City getCity1() {
//		return (City)road[0];
//	}
//	
//	public City getCity2() {
//		return (City)road[1];
//	}
//	
//	public double getDistance() {
//		return (double)road[2];
//	}
//}
