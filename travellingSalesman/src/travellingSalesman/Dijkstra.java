package travellingSalesman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Implementation of the famous Dijkstra algorithm. 
 * @author Dijkstra
 *
 */
public class Dijkstra {
	
	public void computeShortestPaths(City firstCity){
		 
		firstCity.setDistance(0);
		PriorityQueue<City> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(firstCity);
		firstCity.setVisited(true);
 
		while( !priorityQueue.isEmpty() ){
            // Getting the minimum distance city from priority queue
			City currentCity = priorityQueue.poll();
 
			for(Road road : currentCity.getNearbyRoads()){
 
				City v = road.getNextCity();
				if(!v.isVisited())
				{
					double newDistance = currentCity.getDistance() + road.getDistance();
 
					if( newDistance < v.getDistance() ){
						priorityQueue.remove(v);
						v.setDistance(newDistance);
						v.setLastCity(currentCity);
						priorityQueue.add(v);
					}
				}
			}
			currentCity.setVisited(true);
		}
	}
 
	public ArrayList<City> getShortestPathTo(City targetVertex){
		ArrayList<City> path = new ArrayList<>();
 
		for(City city=targetVertex;city!=null;city=city.getLastCity()){
			path.add(city);
		}
 
		Collections.reverse(path);
		return path;
	}

}
