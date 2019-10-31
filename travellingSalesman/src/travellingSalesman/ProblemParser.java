package travellingSalesman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * This class takes as an input a text file and parse its info to create: 
 * - a City (one per line) with an id, a X and a Y
 * - a Road (takes 2 cities and calculate the distance between them)
 * - a Map that stores an array of all the cities and of all the possible roads
 * (each city is linked to all the other ones)
 */

public class ProblemParser {
	
	Map map; 
	
	ProblemParser(String path) {
		try {
			// To know how long is our array of city, 
			// we start with counting the number of lines of a problem
			File problemFile = new File(path);
			long lineCount = Files.lines(Paths.get(problemFile.getName())).count();
			int numberOfCities = (int) lineCount;  //pass it as an argument to build the roadgraph
			
			map = new Map (numberOfCities);
			
			// Then we parse each line to become a City with its id, x, y
			BufferedReader br = new BufferedReader(new FileReader(problemFile));
			String line;
			while ((line = br.readLine()) != null)
	        {
				int[] data = getDataFromLine(line);
				int id = data[0]; 
				int x = data[1];
				int y = data[2];
	            
				City city = new City(id, x, y);
				map.addCityToList(city);           
	        }
	        br.close();	
	        
	        // We calculate the distance between each cities and creates an array of arrays
	        map.calculateRoad();        
		}
		catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	private int[] getDataFromLine(String line) {
		int[] cityData = new int[3];
	    
		//anything other than alphanumeric characters, comma, dot or negative sign is skipped
		// source: https://stackoverflow.com/questions/3272575/how-to-get-numbers-out-of-string
		Scanner scanner = new Scanner(line);
		scanner.useDelimiter("[^\\p{Alnum},\\.-]"); 
	    
	    int data = 0;
	    while (scanner.hasNextInt()) {
	    	cityData[data] = scanner.nextInt();
	    	data++;
	    }
	    scanner.close();
		return cityData;
	}
	
	public Map getMap() {
		if(!map.isEmpty()){
			return map; 
		}
		return null; 
	}
	
	public void testParsing() {
		City[] cities = map.getCities(); 
		for(City city : cities) {
			int id = city.getId();
			int x = city.getX();
			int y = city.getY();
			
			System.out.println("City " + id + " - x: " + x + " - y " + y);
		}
		
		Road[] roads = map.getRoads(); 
		for (Road road : roads) {
			System.out.print("Road: ");
			System.out.println("City " + road.getCity1().getId() + " and City " + road.getCity2().getId() + " have a distance of " + road.getDistance());
		}
	}
	

}
