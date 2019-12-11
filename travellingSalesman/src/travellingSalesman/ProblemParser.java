package travellingSalesman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class takes as an input a text file and parse its info to create: 
 * - a City (one per line) with an id, a X and a Y
 * - a Road (takes 2 cities and calculate the distance between them)
 * - a Map that stores an array of all the cities and of all the possible roads
 * (each city is linked to all the other ones)
 */

public class ProblemParser {
	
	private Map map;
	
	public ProblemParser(String path) {
		try {
			// To know how long is our array of city, 
			// we start with counting the number of lines of a problem
			File problemFile = new File(path);
			long lineCount = Files.lines(Paths.get(problemFile.getName())).count();
			int numberOfCities = (int) lineCount;  //pass it as an argument to build the roadgraph
			
			map = new Map (numberOfCities);
			
			// Then we parse each line to become a City with its id, x, y
			BufferedReader reader = new BufferedReader(new FileReader(problemFile));
			String line;
			while ((line = reader.readLine()) != null)
	        {
				int[] data = getDataFromLine(line);
				int cityId = data[0]; 
				int horizontal = data[1];
				int vertical = data[2];
	            
				City city = new City(cityId, horizontal, vertical);
				map.addCityToList(city);           
	        }
	        reader.close();	
	        
		}
		catch (FileNotFoundException fileNotFoundException) {
	        fileNotFoundException.printStackTrace();
	    } catch (IOException exceptionIO) {
	        exceptionIO.printStackTrace();
	    }
	}
	
	private int[] getDataFromLine(String line) {
		int[] cityData = new int[3];
	    
		Pattern pattern = Pattern.compile("-?\\d+");
		Matcher matcher = pattern.matcher(line);
		
		int data = 0; 
		while(matcher.find()) {
			cityData[data] = Integer.parseInt(matcher.group()); 
			data++;
		}
	    
		return cityData;
	}
	
	public Map getMap() {
		if(!map.isEmpty()){
			return map; 
		}
		return null; 
	}
	
	public void test() {
		City[] cities = map.getCities(); 
		for(City city : cities) {
			int id = city.getId();
			int x = city.getHorizontalCoordinate();
			int y = city.getVerticalCoordinate();
			
			System.out.println("City " + id + " - x: " + x + " - y " + y);
		}
	}
	

}
