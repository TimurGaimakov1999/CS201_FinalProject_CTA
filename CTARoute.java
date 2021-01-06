package project;

import java.util.ArrayList;
import java.util.Scanner;

public class CTARoute
{
	private String name;
	private ArrayList<CTAStation> stops;
	private Scanner input, input1;
	
	public CTARoute(String name, ArrayList<CTAStation> stops)
	{
		this.name = name;
		this.stops = stops;
	}
	
	public void addStation(CTAStation station)
	{
		stops.add(new CTAStation(station.getName(), station.getLat(), station.getLng(), station.getLocation(), station.getWheelchair(), station.getRed(), station.getGreen(),
					station.getBlue(), station.getBrown(), station.getPurple(), station.getPink(), station.getOrange(), station.getYellow()));
	}
	
	public void modifyStation(CTAStation station)
	{
		for(int i = 0; i < stops.size(); i++)
		{
			if(stops.get(i).equals(station))
			{
				input = new Scanner(System.in);
				input1 = new Scanner(System.in);
				System.out.print("Enter new name: ");
				String currentName = station.getName();
				currentName = input.nextLine();
				
				System.out.print("Enter new latitiude: ");
				double currentLat = station.getLat();
				currentLat = input.nextDouble();
				
				System.out.print("Enter new longitude: ");
				double currentLong = station.getLng();
				currentLong = input.nextDouble();
				
				System.out.print("Enter new location: ");
				String currentLoc = station.getLocation();
				currentLoc = input1.nextLine();
				
				System.out.print("Enter wheelchair access: ");
				boolean currentAcc = station.getWheelchair();
				currentAcc = input.nextBoolean();
					
				System.out.print("Enter red line station (-1 for station with no access to this line): ");
				int currentRed = station.getRed();
				currentRed = input.nextInt();
				
				System.out.print("Enter green line station (-1 for station with no access to this line): ");
				int currentGreen = station.getGreen();
				currentGreen = input.nextInt();
				
				System.out.print("Enter blue line station (-1 for station with no access to this line): ");
				int currentBlue = station.getBlue();
				currentBlue = input.nextInt();
				
				System.out.print("Enter brown line station (-1 for station with no access to this line): ");
				int currentBrown = station.getBrown();
				currentBrown = input.nextInt();
				
				System.out.print("Enter purple line station (-1 for station with no access to this line): ");
				int currentPurple = station.getPurple();
				currentPurple = input.nextInt();
				
				System.out.print("Enter pink line station (-1 for station with no access to this line): ");
				int currentPink = station.getPink();
				currentPink = input.nextInt();
				
				System.out.print("Enter orange line station (-1 for station with no access to this line): ");
				int currentOrange = station.getOrange();
				currentOrange = input.nextInt();
				
				System.out.print("Enter yellow line station (-1 for station with no access to this line): ");
				int currentYellow = station.getYellow();
				currentYellow = input.nextInt();
				
				stops.set(i, new CTAStation(currentName, currentLat, currentLong, currentLoc, currentAcc, currentRed, currentGreen,
					currentBlue, currentBrown, currentPurple, currentPink, currentOrange, currentYellow));
			}
		}
	}
	
	public void removeStation(CTAStation station)
	{
		stops.remove(station);
	}
	
	public void insertStation(int position, CTAStation station)
	{
		stops.add(position, new CTAStation(station.getName(), station.getLat(), station.getLng(), station.getLocation(), station.getWheelchair(), station.getRed(), station.getGreen(),
					station.getBlue(), station.getBrown(), station.getPurple(), station.getPink(), station.getOrange(), station.getYellow()));
	}
	
	public void SearchStation(String name)
	{
		ArrayList<CTAStation> arr = new ArrayList<CTAStation>();		
		CTAStation desiredStation = stops.get(0);
		
		for(int i = 0; i < stops.size(); i++)
		{
			if((stops.get(i).getName()).equals(name))
			{
				desiredStation = stops.get(i);
				arr.add(desiredStation);
			}
		}
		
		for(int j = 0; j < arr.size(); j++)
		{
			System.out.println("Name: " + arr.get(j).getName() + 
								"\tLatitude: " + arr.get(j).getLat() + 
								"\tLongitude: " + arr.get(j).getLng() + 
								"\tLocation: " + arr.get(j).getLocation() + 
								"\tWheelchair: " + arr.get(j).getWheelchair() + 
								"\tRed line: " + arr.get(j).getRed() + 
								"\tGreen line: " + arr.get(j).getGreen() + 
								"\tBlue line: " + arr.get(j).getBlue() + 
								"\tBrown line: " + arr.get(j).getBrown() + 
								"\tPurple line: " + arr.get(j).getPurple() + 
								"\tPink line: " + arr.get(j).getPink() + 
								"\tOrange line: " + arr.get(j).getOrange() + 
								"\tYellow line: " + arr.get(j).getYellow());
		}
	}
	
	public CTAStation lookupStation(String name)
	{
		CTAStation desiredStation = stops.get(0);
		
		for(int i = 0; i < stops.size(); i++)
		{
			if((stops.get(i).getName()).equals(name))
			{
				desiredStation = stops.get(i);
			}
		}
		return desiredStation;
	}
	
	public CTAStation nearestStation(double latitude, double longitude)
	{
		CTAStation closestStation = stops.get(0);
		double minimum = 10000000.0,
				distance;
		
		for(int i = 0; i < stops.size(); i++)
		{
			distance = closestStation.calcDistance(latitude, longitude);
			if(distance < minimum)
			{
				minimum = distance;
				closestStation = stops.get(i);
			}
		}
		return closestStation;
	}
	
	public CTAStation nearestStation(GeoLocation location)
	{
		CTAStation closestStation = stops.get(0);
		double minimum = 10000000.0,
				distance;
		
		for(int i = 0; i < stops.size(); i++)
		{
			distance = closestStation.calcDistance(location.getLat(), location.getLng());
			if(distance < minimum)
			{
				minimum = distance;
				closestStation = stops.get(i);
			}
		}
		return closestStation;
	}
	
	
}
