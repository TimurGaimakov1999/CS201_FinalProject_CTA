package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CTAStopApp
{
	private static Scanner inputStationName;
	private static Scanner inputLatitude;
	private static Scanner inputLocation;
	private static Scanner inputLongitude;
	private static Scanner inputPinkLine;
	private static Scanner inputGreenLine;
	private static Scanner inputWheelchair;
	private static Scanner inputRedLine;
	private static Scanner inputBrownLine;
	private static Scanner inputBlueLine;
	private static Scanner inputPurpleLine;
	private static Scanner inputOrangeLine;
	private static Scanner inputYellowLine;
	private static Scanner inputPosition;

	public static void displayStationNames() throws IOException 
	{
		File file = new File("src/Final_Exam/CTAStops.cvs");
		Scanner input = new Scanner(file);
		
		while(input.hasNextLine())
		{
			String[] val = input.next().split(",");
			String str = val[0];
			System.out.print(str + ", ");
		}
	}
	
	public static void displayNearest() throws IOException 
	{
		FileReader file = new FileReader("src/Final_Exam/CTAStops.cvs");
		String[][] RowAndCol = new String[140][13];
		
		Scanner	input2 = new Scanner(file);
		
		Scanner lat = new Scanner(System.in),
				lng = new Scanner(System.in);		
		System.out.print("Enter latitude: ");
		double latitude = lat.nextDouble();
		System.out.print("Enter longitude: ");
		double longitude = lng.nextDouble();
		
		GeoLocation station = new GeoLocation(latitude, longitude);
		
		int i = 0;
		double minimum = 100000.0;
		double distance;
		String closestStationName = "";
		while(input2.hasNextLine() && i < RowAndCol[0].length)
		{
			String[] val = input2.next().split(",");
			String lat1 = val[1],
					lng1 = val[2],
					name = val[0];
			
			double lat2 = Double.parseDouble(lat1),
					lng2 = Double.parseDouble(lng1);
			
			distance = station.calcDistance(lat2, lng2);
			
			if(distance < minimum)
			{
				minimum = distance;	
				closestStationName = name;
			}
			i++;
		}			
		System.out.print("The nearest station is: " + closestStationName);
	}
	
	public static void displayInformationForSpecificStation() throws IOException
	{
		FileReader file = new FileReader("src/Final_Exam/CTAStops.cvs");
		String[][] RowAndCol = new String[140][13];
		
		Scanner input1 = new Scanner(file),
				input2 = new Scanner(System.in);
		
		System.out.print("Enter station name: ");
		
		String enteredName = input2.nextLine();
		int i = 0;
		while(input1.hasNextLine() && i < RowAndCol[0].length)
		{
			String[] val = input1.next().split(",");
			String stationName = val[0];
			if(enteredName.equals(stationName))
			{
				RowAndCol[i][0] = val[0];
				RowAndCol[i][1] = val[1];
				RowAndCol[i][2] = val[2];
				RowAndCol[i][3] = val[3];
				RowAndCol[i][4] = val[4];
				RowAndCol[i][5] = val[5];
				RowAndCol[i][6] = val[6];
				RowAndCol[i][7] = val[7];
				RowAndCol[i][8] = val[8];
				RowAndCol[i][9] = val[9];
				RowAndCol[i][10] = val[10];
				RowAndCol[i][11] = val[11];
				RowAndCol[i][12] = val[12];
				System.out.println("Name: " + RowAndCol[i][0] +
									"\nLatitude: " + RowAndCol[i][1] +
									"\nLongitude: " + RowAndCol[i][2] +
									"\nLocation: " + RowAndCol[i][3] +
									"\nWheelchair: " + RowAndCol[i][4] +
									"\nRed Line: " + RowAndCol[i][5] +
									"\nGreen Line: " + RowAndCol[i][6] +
									"\nBlue Line: " + RowAndCol[i][7] +
									"\nBrown Line: " + RowAndCol[i][8] +
									"\nPurple Line: " + RowAndCol[i][9] +
									"\nPink Line: " + RowAndCol[i][10] +
									"\nOrange Line: " + RowAndCol[i][11] +
									"\nYellow Line: " + RowAndCol[i][12]);
			}
			i++;
		}
		System.out.println("A station with name " + enteredName + " is not found.");
	}
	
	public static void displayInformationForAllStations() throws IOException
	{
		FileReader file = new FileReader("src/Final_Exam/CTAStops.cvs");		
		Scanner input1 = new Scanner(file);

		while(input1.hasNextLine())
		{
			String[] val = input1.next().split(",");
			String name = val[0],
					latitude = val[1],
					longitude = val[2],
					location = val[3],
					wheelchair = val[4],
					redLine = val[5],
					greenLine = val[6],
					blueLine = val[7],
					brownLine = val[8],
					purpleLine = val[9],
					pinkLine = val[10],
					orangeLine = val[11],
					yellowLine = val[12];
			System.out.println("Name: " + name +
								"\tLatitude: " + latitude +
								"\tLongitude: " + longitude +
								"\tLocation: " + location +
								"\tWheelchair: " + wheelchair +
								"\tRed Line: " + redLine +
								"\tGreen Line: " + greenLine +
								"\tBlue Line: " + blueLine +
								"\tBrown Line: " + brownLine +
								"\tPurple Line: " + purpleLine +
								"\tPink Line: " + pinkLine +
								"\tOrange Line: " + orangeLine +
								"\tYellow Line: " + yellowLine);
		}
	}
	
	public static void addNewStation() throws IOException
	{
		FileReader file = new FileReader("src/Final_Exam/CTAStops.cvs");		
		Scanner input1 = new Scanner(file);
		String[][] RowAndCol = new String[140][13];
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<CTAStation> arrToStation = new ArrayList<CTAStation>();
		
		inputStationName = new Scanner(System.in);
		inputLatitude = new Scanner(System.in);
		inputLongitude = new Scanner(System.in);
		inputLocation = new Scanner(System.in);
		inputWheelchair = new Scanner(System.in);
		inputRedLine = new Scanner(System.in);
		inputGreenLine = new Scanner(System.in);
		inputBlueLine = new Scanner(System.in);
		inputBrownLine = new Scanner(System.in);
		inputPurpleLine = new Scanner(System.in);
		inputPinkLine = new Scanner(System.in);
		inputOrangeLine = new Scanner(System.in);
		inputYellowLine = new Scanner(System.in);
		inputPosition = new Scanner(System.in);
		int i = 0,
			k = 0;

		/**
		 * Filling in the array with String elements
		 */
		while(input1.hasNextLine() && i < RowAndCol.length)
		{
			String[] val = input1.next().split(",");
			String name = val[0],
					latitude = val[1],
					longitude = val[2],
					location = val[3],
					wheelchair = val[4],
					redLine = val[5],
					greenLine = val[6],
					blueLine = val[7],
					brownLine = val[8],
					purpleLine = val[9],
					pinkLine = val[10],
					orangeLine = val[11],
					yellowLine = val[12];
			
			while(k < RowAndCol[0].length)
			{
				if(k == 0)
				{
					RowAndCol[i][k] = name;
				}
				else if(k == 1)
				{
					RowAndCol[i][k] = latitude;
				}
				else if(k == 2)
				{
					RowAndCol[i][k] = longitude;
				}
				else if(k == 3)
				{
					RowAndCol[i][k] = location;
				}
				else if(k == 4)
				{
					RowAndCol[i][k] = wheelchair;
				}
				else if(k == 5)
				{
					RowAndCol[i][k] = redLine;
				}
				else if(k == 6)
				{
					RowAndCol[i][k] = greenLine;
				}
				else if(k == 7)
				{
					RowAndCol[i][k] = blueLine;
				}
				else if(k == 8)
				{
					RowAndCol[i][k] = brownLine;
				}
				else if(k == 9)
				{
					RowAndCol[i][k] = purpleLine;
				}
				else if(k == 10)
				{
					RowAndCol[i][k] = pinkLine;
				}
				else if(k == 11)
				{
					RowAndCol[i][k] = orangeLine;
				}
				else if(k == 12)
				{
					RowAndCol[i][k] = yellowLine;
				}
				k++;
			}
			k = 0;
			i++;
		}
		
		String name = "", location = "";
		double lat = 0.0, lng = 0.0;
		int redL = 0, greenL = 0,
				blueL = 0, brownL = 0,
				purpleL = 0, pinkL = 0,
				orangeL = 0, yellowL = 0;
		boolean wheel = true;
		CTAStation station;
		for(int row = 0; row < RowAndCol.length; row++)
		{
			for(int col = 0; col < RowAndCol[0].length; col++)
			{
				if(col == 0)
				{
					name = RowAndCol[row][col];
				}
				else if(col == 1)
				{
					lat = Double.parseDouble(RowAndCol[row][col]);
				}
				else if(col == 2)
				{
					lng = Double.parseDouble(RowAndCol[row][col]);
				}
				else if(col == 3)
				{
					location = RowAndCol[row][col];
				}
				else if(col == 4)
				{
					wheel = Boolean.parseBoolean(RowAndCol[row][col]);
				}
				else if(col == 5)
				{
					redL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 6)
				{
					greenL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 7)
				{
					blueL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 8)
				{
					brownL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 9)
				{
					purpleL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 10)
				{
					pinkL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 11)
				{
					orangeL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 12)
				{
					yellowL = Integer.parseInt(RowAndCol[row][col]);
				}
			}
			station = new CTAStation(name, lat, lng, location, wheel, redL, greenL, blueL, brownL, purpleL, pinkL, orangeL, yellowL);
			arrToStation.add(station);
		}		
		CTARoute route = new CTARoute(name, arrToStation);
		
		System.out.print("Enter station name: ");
		String Name = inputStationName.nextLine();
		System.out.print("Enter station latitude: ");
		double Lat = inputLatitude.nextDouble();
		System.out.print("Enter station longitude: ");
		double Lng = inputLongitude.nextDouble();
		System.out.print("Enter station location: ");
		String Loc = inputLocation.nextLine();
		System.out.print("Enter wheelchair access (TRUE or FALSE): ");
		boolean Wheel = inputWheelchair.nextBoolean();
		System.out.print("Enter Red Line (-1 for station with no access to this line): ");
		int redLine = inputRedLine.nextInt();
		System.out.print("Enter Green Line (-1 for station with no access to this line): ");
		int greenLine = inputGreenLine.nextInt();
		System.out.print("Enter Blue Line (-1 for station with no access to this line): ");
		int blueLine = inputBlueLine.nextInt();
		System.out.print("Enter Brown Line (-1 for station with no access to this line): ");
		int brownLine = inputBrownLine.nextInt();
		System.out.print("Enter Purple Line (-1 for station with no access to this line): ");
		int purpleLine = inputPurpleLine.nextInt();
		System.out.print("Enter Pink Line (-1 for station with no access to this line): ");
		int pinkLine = inputPinkLine.nextInt();
		System.out.print("Enter Orange Line (-1 for station with no access to this line): ");
		int orangeLine = inputOrangeLine.nextInt();
		System.out.print("Enter Yellow Line (-1 for station with no access to this line): ");
		int yellowLine = inputYellowLine.nextInt();
		
		station = new CTAStation(Name, Lat, Lng, Loc, Wheel, redLine, greenLine, blueLine, brownLine, purpleLine, pinkLine, orangeLine, yellowLine);
		System.out.print("Enter the name of the previous station: ");
		String previous = inputPosition.nextLine();
		
		CTAStation prev = route.lookupStation(previous);
		CTAStation st;
		int position = 0;
		
		for(int j = 0; j < arrToStation.size(); j++)
		{
			st = arrToStation.get(j);
			if(st.equals(prev))
			{
				j = arrToStation.size();
			}
			position++;
		}
		
		route.insertStation(position, station);
		
		CTAStation curr = route.lookupStation(Name);
		int count = 0;
		for(int j = 0; j < arrToStation.size(); j++)
		{
			st = arrToStation.get(j);
			if(st.equals(curr))
			{
				String str1 = "Name: " + arrToStation.get(j).getName() + 
						"\tLatitude: " + arrToStation.get(j).getLat() +
						"\tLongitude: " + arrToStation.get(j).getLng() +
						"\tLocation: " + arrToStation.get(j).getLocation() +
						"\tWheelchair: " + arrToStation.get(j).getWheelchair();
				if(st.getGreen() == -1 && st.getRed() != j && st.getBlue() != j && st.getBrown() != j && st.getPurple() != j && st.getPink() != j && st.getOrange() != j && st.getYellow() != j)
				{
					String str2 = str1 + "\tRed Line: " + j 
							+ "\tGreen Line: " + arrToStation.get(j).getGreen()
							+ "\tBlue Line: " + j
							+ "\tBrown Line: " + j
							+ "\tPurple Line: " + j
							+ "\tPink Line: " + j
							+ "\tOrange Line: " + j
							+ "\tYellow Line: " + j;
					System.out.println(str2);
				}
				else if(st.getRed() == -1 && st.getGreen() != j && st.getBlue() != j && st.getBrown() != j && st.getPurple() != j && st.getPink() != j && st.getOrange() != j && st.getYellow() != j)
				{
					String str2 = str1 + "\tRed Line: " + arrToStation.get(j).getRed()
							+ "\tGreen Line: " + j
							+ "\tBlue Line: " + j
							+ "\tBrown Line: " + j
							+ "\tPurple Line: " + j
							+ "\tPink Line: " + j
							+ "\tOrange Line: " + j
							+ "\tYellow Line: " + j;
					System.out.println(str2);
				}
				else if(st.getBlue() == -1 && st.getRed() != j && st.getGreen() != j && st.getBrown() != j && st.getPurple() != j && st.getPink() != j && st.getOrange() != j && st.getYellow() != j)
				{
					String str2 = str1 + "\tRed Line: " + j
							+ "\tGreen Line: " + j
							+ "\tBlue Line: " + arrToStation.get(j).getBlue()
							+ "\tBrown Line: " + j
							+ "\tPurple Line: " + j
							+ "\tPink Line: " + j
							+ "\tOrange Line: " + j
							+ "\tYellow Line: " + j;
					System.out.println(str2);
				}	
				else if(st.getBrown() == -1 && st.getRed() != j && st.getGreen() != j && st.getBlue() != j && st.getPurple() != j && st.getPink() != j && st.getOrange() != j && st.getYellow() != j)
				{
					String str2 = str1 + "\tRed Line: " + j
							+ "\tGreen Line: " + j
							+ "\tBlue Line: " + j
							+ "\tBrown Line: " + arrToStation.get(j).getBrown()
							+ "\tPurple Line: " + j
							+ "\tPink Line: " + j
							+ "\tOrange Line: " + j
							+ "\tYellow Line: " + j;
					System.out.println(str2);
				}	
				else if(st.getPurple() == -1 && st.getRed() != j && st.getGreen() != j && st.getBlue() != j && st.getBrown() != j && st.getPink() != j && st.getOrange() != j && st.getYellow() != j)
				{
					String str2 = str1 + "\tRed Line: " + j
							+ "\tGreen Line: " + j
							+ "\tBlue Line: " + j
							+ "\tBrown Line: " + j
							+ "\tPurple Line: " + arrToStation.get(j).getPurple()
							+ "\tPink Line: " + j
							+ "\tOrange Line: " + j
							+ "\tYellow Line: " + j;
					System.out.println(str2);
				}
				else if(st.getPink() == -1 && st.getRed() != j && st.getGreen() != j && st.getBlue() != j && st.getBrown() != j && st.getPurple() != j && st.getOrange() != j && st.getYellow() != j)
				{
					String str2 = str1 + "\tRed Line: " + j
							+ "\tGreen Line: " + j
							+ "\tBlue Line: " + j
							+ "\tBrown Line: " + j
							+ "\tPurple Line: " + j
							+ "\tPink Line: " + arrToStation.get(j).getPink()
							+ "\tOrange Line: " + j
							+ "\tYellow Line: " + j;
					System.out.println(str2);
				}
				else if(st.getOrange() == -1 && st.getRed() != j && st.getGreen() != j && st.getBlue() != j && st.getBrown() != j && st.getPurple() != j && st.getPink() != j && st.getYellow() != j)
				{
					String str2 = str1 + "\tRed Line: " + j
							+ "\tGreen Line: " + j
							+ "\tBlue Line: " + j
							+ "\tBrown Line: " + j
							+ "\tPurple Line: " + j
							+ "\tPink Line: " + j
							+ "\tOrange Line: " + arrToStation.get(j).getOrange()
							+ "\tYellow Line: " + j;
					System.out.println(str2);
				}
				else if(st.getYellow() == -1 && st.getRed() != j && st.getGreen() != j && st.getBlue() != j && st.getBrown() != j && st.getPurple() != j && st.getPink() != j && st.getOrange() != j)
				{
					String str2 = str1 + "\tRed Line: " + j
							+ "\tGreen Line: " + j
							+ "\tBlue Line: " + j
							+ "\tBrown Line: " + j
							+ "\tPurple Line: " + j
							+ "\tPink Line: " + j
							+ "\tOrange Line: " + j
							+ "\tYellow Line: " + arrToStation.get(j).getYellow();
					System.out.println(str2);
				}				
				count++;
			}			
			else
			{
				System.out.println("Name: " + arrToStation.get(j).getName() + 
									"\tLatitude: " + arrToStation.get(j).getLat() +
									"\tLongitude: " + arrToStation.get(j).getLng() +
									"\tLocation: " + arrToStation.get(j).getLocation() +
									"\tWheelchair: " + arrToStation.get(j).getWheelchair() +
									"\tRed Line: " + arrToStation.get(j).getRed() +
									"\tGreen Line: " + arrToStation.get(j).getGreen() +
									"\tBlue Line: " + arrToStation.get(j).getBlue() +
									"\tBrown Line: " + arrToStation.get(j).getBrown() +
									"\tPurple Line: " + arrToStation.get(j).getPurple() +
									"\tPink Line: " + arrToStation.get(j).getPink() +
									"\tOrange Line: " + arrToStation.get(j).getOrange() +
									"\tYellow Line: " + arrToStation.get(j).getYellow());
			}
			
			/** Tried to adjust numbers of either red or green line so that they would
			 * be incremented regardless what did user enter for red or green line
			else
			{
				String str1 = "Name: " + arrToStation.get(j).getName() + 
						"\tLatitude: " + arrToStation.get(j).getLat() +
						"\tLongitude: " + arrToStation.get(j).getLng() +
						"\tLocation: " + arrToStation.get(j).getLocation() +
						"\tWheelchair: " + arrToStation.get(j).getWheelchair();
				if(arrToStation.get(j).getGreen() == -1 && arrToStation.get(j).getRed() == j)
				{
					String str2 = str1 + "\tRed Line: " + j
							+ "\tGreen Line: " + arrToStation.get(j).getGreen();
					System.out.println(str2);
				}
				else if(arrToStation.get(j).getRed() == -1 && arrToStation.get(j).getGreen() != j)
				{
					String str2 = str1 + "\tRed Line: " + arrToStation.get(j).getRed()
							+ "\tGreen Line: " + j;
					System.out.println(str2);
				}
			}
			*/
		}
	}
	
	public static void modifyStation() throws IOException 
	{
		FileReader file = new FileReader("src/Final_Exam/CTAStops.cvs");		
		Scanner input1 = new Scanner(file);
		String[][] RowAndCol = new String[140][13];
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<CTAStation> arrToStation = new ArrayList<CTAStation>();
		Scanner inputStationName = new Scanner(System.in),
				inputLatitude = new Scanner(System.in),
				inputLongitude = new Scanner(System.in),
				inputLocation = new Scanner(System.in),
				inputWheelchair = new Scanner(System.in),
				inputRedLine = new Scanner(System.in),
				inputGreenLine = new Scanner(System.in),
				inputPosition = new Scanner(System.in);
		
		int i = 0,
			k = 0;

		/**
		 * Filling in the array with String elements
		 */
		while(input1.hasNextLine() && i < RowAndCol.length)
		{
			String[] val = input1.next().split(",");
			String name = val[0],
					latitude = val[1],
					longitude = val[2],
					location = val[3],
					wheelchair = val[4],
					redLine = val[5],
					greenLine = val[6],
					blueLine = val[7],
					brownLine = val[8],
					purpleLine = val[9],
					pinkLine = val[10],
					orangeLine = val[11],
					yellowLine = val[12];
					
			while(k < RowAndCol[0].length)
			{
				if(k == 0)
				{
					RowAndCol[i][k] = name;
				}
				else if(k == 1)
				{
					RowAndCol[i][k] = latitude;
				}
				else if(k == 2)
				{
					RowAndCol[i][k] = longitude;
				}
				else if(k == 3)
				{
					RowAndCol[i][k] = location;
				}
				else if(k == 4)
				{
					RowAndCol[i][k] = wheelchair;
				}
				else if(k == 5)
				{
					RowAndCol[i][k] = redLine;
				}
				else if(k == 6)
				{
					RowAndCol[i][k] = greenLine;
				}
				else if(k == 7)
				{
					RowAndCol[i][k] = blueLine;
				}
				else if(k == 8)
				{
					RowAndCol[i][k] = brownLine;
				}
				else if(k == 9)
				{
					RowAndCol[i][k] = purpleLine;
				}
				else if(k == 10)
				{
					RowAndCol[i][k] = pinkLine;
				}
				else if(k == 11)
				{
					RowAndCol[i][k] = orangeLine;
				}
				else if(k == 12)
				{
					RowAndCol[i][k] = yellowLine;
				}
				k++;
			}
			k = 0;
			i++;
		}
		
		String name = "", location = "";
		double lat = 0.0, lng = 0.0;
		int redL = 0, greenL = 0,
				blueL = 0, brownL = 0,
				purpleL = 0, pinkL = 0,
				orangeL = 0, yellowL = 0;
		boolean wheel = true;
		CTAStation station;
		for(int row = 0; row < RowAndCol.length; row++)
		{
			for(int col = 0; col < RowAndCol[0].length; col++)
			{
				if(col == 0)
				{
					name = RowAndCol[row][col];
				}
				else if(col == 1)
				{
					lat = Double.parseDouble(RowAndCol[row][col]);
				}
				else if(col == 2)
				{
					lng = Double.parseDouble(RowAndCol[row][col]);
				}
				else if(col == 3)
				{
					location = RowAndCol[row][col];
				}
				else if(col == 4)
				{
					wheel = Boolean.parseBoolean(RowAndCol[row][col]);
				}
				else if(col == 5)
				{
					redL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 6)
				{
					greenL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 7)
				{
					blueL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 8)
				{
					brownL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 9)
				{
					purpleL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 10)
				{
					pinkL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 11)
				{
					orangeL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 12)
				{
					yellowL = Integer.parseInt(RowAndCol[row][col]);
				}
			}
			station = new CTAStation(name, lat, lng, location, wheel, redL, greenL, blueL, brownL, purpleL, pinkL, orangeL, yellowL);
			arrToStation.add(station);
		}		
		CTARoute route = new CTARoute(name, arrToStation);
		
		System.out.print("Enter station name: ");
		String Name = inputStationName.nextLine();
		
		CTAStation modifyingStation = route.lookupStation(Name);		
		CTAStation st;
		
		route.modifyStation(modifyingStation);
		
		for(int j = 0; j < arrToStation.size(); j++)
		{
			System.out.println("Name: " + arrToStation.get(j).getName() + 
					"\tLatitude: " + arrToStation.get(j).getLat() +
					"\tLongitude: " + arrToStation.get(j).getLng() +
					"\tLocation: " + arrToStation.get(j).getLocation() +
					"\tWheelchair: " + arrToStation.get(j).getWheelchair() +
					"\tRed Line: " + arrToStation.get(j).getRed() +
					"\tGreen Line: " + arrToStation.get(j).getGreen() +
					"\tBlue Line: " + arrToStation.get(j).getBlue() +
					"\tBrown Line: " + arrToStation.get(j).getBrown() +
					"\tPurple Line: " + arrToStation.get(j).getPurple() +
					"\tPink Line: " + arrToStation.get(j).getPink() +
					"\tOrange Line: " + arrToStation.get(j).getOrange() +
					"\tYellow Line: " + arrToStation.get(j).getYellow());			
		}
	}
	
	public static void removeStation() throws IOException 
	{
		FileReader file = new FileReader("src/Final_Exam/CTAStops.cvs");		
		Scanner input1 = new Scanner(file);
		String[][] RowAndCol = new String[140][13];
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<CTAStation> arrToStation = new ArrayList<CTAStation>();
		
		Scanner inputStationName = new Scanner(System.in),
				inputLatitude = new Scanner(System.in),
				inputLongitude = new Scanner(System.in),
				inputLocation = new Scanner(System.in),
				inputWheelchair = new Scanner(System.in),
				inputRedLine = new Scanner(System.in),
				inputGreenLine = new Scanner(System.in),
				inputPosition = new Scanner(System.in);
		
		int i = 0,
			k = 0;

		/**
		 * Filling in the array with String elements
		 */
		while(input1.hasNextLine() && i < RowAndCol.length)
		{
			String[] val = input1.next().split(",");
			String name = val[0],
					latitude = val[1],
					longitude = val[2],
					location = val[3],
					wheelchair = val[4],
					redLine = val[5],
					greenLine = val[6],
					blueLine = val[7],
					brownLine = val[8],
					purpleLine = val[9],
					pinkLine = val[10],
					orangeLine = val[11],
					yellowLine = val[12];
					
			while(k < RowAndCol[0].length)
			{
				if(k == 0)
				{
					RowAndCol[i][k] = name;
				}
				else if(k == 1)
				{
					RowAndCol[i][k] = latitude;
				}
				else if(k == 2)
				{
					RowAndCol[i][k] = longitude;
				}
				else if(k == 3)
				{
					RowAndCol[i][k] = location;
				}
				else if(k == 4)
				{
					RowAndCol[i][k] = wheelchair;
				}
				else if(k == 5)
				{
					RowAndCol[i][k] = redLine;
				}
				else if(k == 6)
				{
					RowAndCol[i][k] = greenLine;
				}
				else if(k == 7)
				{
					RowAndCol[i][k] = blueLine;
				}
				else if(k == 8)
				{
					RowAndCol[i][k] = brownLine;
				}
				else if(k == 9)
				{
					RowAndCol[i][k] = purpleLine;
				}
				else if(k == 10)
				{
					RowAndCol[i][k] = pinkLine;
				}
				else if(k == 11)
				{
					RowAndCol[i][k] = orangeLine;
				}
				else if(k == 12)
				{
					RowAndCol[i][k] = yellowLine;
				}
				k++;
			}
			k = 0;
			i++;
		}
		
		String name = "", location = "";
		double lat = 0.0, lng = 0.0;
		int redL = 0, greenL = 0,
				blueL = 0, brownL = 0,
				purpleL = 0, pinkL = 0,
				orangeL = 0, yellowL = 0;
		boolean wheel = true;
		CTAStation station;
		for(int row = 0; row < RowAndCol.length; row++)
		{
			for(int col = 0; col < RowAndCol[0].length; col++)
			{
				if(col == 0)
				{
					name = RowAndCol[row][col];
				}
				else if(col == 1)
				{
					lat = Double.parseDouble(RowAndCol[row][col]);
				}
				else if(col == 2)
				{
					lng = Double.parseDouble(RowAndCol[row][col]);
				}
				else if(col == 3)
				{
					location = RowAndCol[row][col];
				}
				else if(col == 4)
				{
					wheel = Boolean.parseBoolean(RowAndCol[row][col]);
				}
				else if(col == 5)
				{
					redL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 6)
				{
					greenL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 7)
				{
					blueL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 8)
				{
					brownL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 9)
				{
					purpleL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 10)
				{
					pinkL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 11)
				{
					orangeL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 12)
				{
					yellowL = Integer.parseInt(RowAndCol[row][col]);
				}
			}
			station = new CTAStation(name, lat, lng, location, wheel, redL, greenL, blueL, brownL, purpleL, pinkL, orangeL, yellowL);
			arrToStation.add(station);
		}		
		CTARoute route = new CTARoute(name, arrToStation);
		
		System.out.print("Enter station name: ");
		String Name = inputStationName.nextLine();
		
		CTAStation removingStation = route.lookupStation(Name);		
		CTAStation st;
		
		route.removeStation(removingStation);
		
		for(int j = 0; j < arrToStation.size(); j++)
		{
			System.out.println("Name: " + arrToStation.get(j).getName() + 
					"\tLatitude: " + arrToStation.get(j).getLat() +
					"\tLongitude: " + arrToStation.get(j).getLng() +
					"\tLocation: " + arrToStation.get(j).getLocation() +
					"\tWheelchair: " + arrToStation.get(j).getWheelchair() +
					"\tRed Line: " + arrToStation.get(j).getRed() +
					"\tGreen Line: " + arrToStation.get(j).getGreen() +
					"\tBlue Line: " + arrToStation.get(j).getBlue() +
					"\tBrown Line: " + arrToStation.get(j).getBrown() +
					"\tPurple Line: " + arrToStation.get(j).getPurple() +
					"\tPink Line: " + arrToStation.get(j).getPink() +
					"\tOrange Line: " + arrToStation.get(j).getOrange() +
					"\tYellow Line: " + arrToStation.get(j).getYellow());			
		}
	}
	
	public static void SearchStation() throws IOException 
	{
		FileReader file = new FileReader("src/Final_Exam/CTAStops.cvs");		
		Scanner input1 = new Scanner(file);
		String[][] RowAndCol = new String[140][13];
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<CTAStation> arrToStation = new ArrayList<CTAStation>();
		
		Scanner inputStationName = new Scanner(System.in),
				inputLatitude = new Scanner(System.in),
				inputLongitude = new Scanner(System.in),
				inputLocation = new Scanner(System.in),
				inputWheelchair = new Scanner(System.in),
				inputRedLine = new Scanner(System.in),
				inputGreenLine = new Scanner(System.in),
				inputPosition = new Scanner(System.in);
		
		int i = 0,
			k = 0;

		/**
		 * Filling in the array with String elements
		 */
		while(input1.hasNextLine() && i < RowAndCol.length)
		{
			String[] val = input1.next().split(",");
			String name = val[0],
					latitude = val[1],
					longitude = val[2],
					location = val[3],
					wheelchair = val[4],
					redLine = val[5],
					greenLine = val[6],
					blueLine = val[7],
					brownLine = val[8],
					purpleLine = val[9],
					pinkLine = val[10],
					orangeLine = val[11],
					yellowLine = val[12];
					
			while(k < RowAndCol[0].length)
			{
				if(k == 0)
				{
					RowAndCol[i][k] = name;
				}
				else if(k == 1)
				{
					RowAndCol[i][k] = latitude;
				}
				else if(k == 2)
				{
					RowAndCol[i][k] = longitude;
				}
				else if(k == 3)
				{
					RowAndCol[i][k] = location;
				}
				else if(k == 4)
				{
					RowAndCol[i][k] = wheelchair;
				}
				else if(k == 5)
				{
					RowAndCol[i][k] = redLine;
				}
				else if(k == 6)
				{
					RowAndCol[i][k] = greenLine;
				}
				else if(k == 7)
				{
					RowAndCol[i][k] = blueLine;
				}
				else if(k == 8)
				{
					RowAndCol[i][k] = brownLine;
				}
				else if(k == 9)
				{
					RowAndCol[i][k] = purpleLine;
				}
				else if(k == 10)
				{
					RowAndCol[i][k] = pinkLine;
				}
				else if(k == 11)
				{
					RowAndCol[i][k] = orangeLine;
				}
				else if(k == 12)
				{
					RowAndCol[i][k] = yellowLine;
				}
				k++;
			}
			k = 0;
			i++;
		}
		
		String name = "", location = "";
		double lat = 0.0, lng = 0.0;
		int redL = 0, greenL = 0,
				blueL = 0, brownL = 0,
				purpleL = 0, pinkL = 0,
				orangeL = 0, yellowL = 0;
		boolean wheel = true;
		CTAStation station;
		for(int row = 0; row < RowAndCol.length; row++)
		{
			for(int col = 0; col < RowAndCol[0].length; col++)
			{
				if(col == 0)
				{
					name = RowAndCol[row][col];
				}
				else if(col == 1)
				{
					lat = Double.parseDouble(RowAndCol[row][col]);
				}
				else if(col == 2)
				{
					lng = Double.parseDouble(RowAndCol[row][col]);
				}
				else if(col == 3)
				{
					location = RowAndCol[row][col];
				}
				else if(col == 4)
				{
					wheel = Boolean.parseBoolean(RowAndCol[row][col]);
				}
				else if(col == 5)
				{
					redL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 6)
				{
					greenL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 7)
				{
					blueL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 8)
				{
					brownL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 9)
				{
					purpleL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 10)
				{
					pinkL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 11)
				{
					orangeL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 12)
				{
					yellowL = Integer.parseInt(RowAndCol[row][col]);
				}
			}
			station = new CTAStation(name, lat, lng, location, wheel, redL, greenL, blueL, brownL, purpleL, pinkL, orangeL, yellowL);
			arrToStation.add(station);
		}		
		CTARoute route = new CTARoute(name, arrToStation);
		
		System.out.print("Enter station name: ");
		String Name = inputStationName.nextLine();
		
		route.SearchStation(Name);			
	}
	
	public static void pathGenerator() throws IOException 
	{
		FileReader file = new FileReader("src/Final_Exam/CTAStops.cvs");		
		Scanner input1 = new Scanner(file);
		String[][] RowAndCol = new String[140][13];
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<CTAStation> arrToStation = new ArrayList<CTAStation>();
		
		Scanner inputStationName = new Scanner(System.in),
				inputLatitude = new Scanner(System.in),
				inputLongitude = new Scanner(System.in),
				inputLocation = new Scanner(System.in),
				inputWheelchair = new Scanner(System.in),
				inputRedLine = new Scanner(System.in),
				inputGreenLine = new Scanner(System.in),
				inputPosition = new Scanner(System.in);
		
		int i = 0,
			k = 0;

		/**
		 * Filling in the array with String elements
		 */
		while(input1.hasNextLine() && i < RowAndCol.length)
		{
			String[] val = input1.next().split(",");
			String name = val[0],
					latitude = val[1],
					longitude = val[2],
					location = val[3],
					wheelchair = val[4],
					redLine = val[5],
					greenLine = val[6],
					blueLine = val[7],
					brownLine = val[8],
					purpleLine = val[9],
					pinkLine = val[10],
					orangeLine = val[11],
					yellowLine = val[12];
					
			while(k < RowAndCol[0].length)
			{
				if(k == 0)
				{
					RowAndCol[i][k] = name;
				}
				else if(k == 1)
				{
					RowAndCol[i][k] = latitude;
				}
				else if(k == 2)
				{
					RowAndCol[i][k] = longitude;
				}
				else if(k == 3)
				{
					RowAndCol[i][k] = location;
				}
				else if(k == 4)
				{
					RowAndCol[i][k] = wheelchair;
				}
				else if(k == 5)
				{
					RowAndCol[i][k] = redLine;
				}
				else if(k == 6)
				{
					RowAndCol[i][k] = greenLine;
				}
				else if(k == 7)
				{
					RowAndCol[i][k] = blueLine;
				}
				else if(k == 8)
				{
					RowAndCol[i][k] = brownLine;
				}
				else if(k == 9)
				{
					RowAndCol[i][k] = purpleLine;
				}
				else if(k == 10)
				{
					RowAndCol[i][k] = pinkLine;
				}
				else if(k == 11)
				{
					RowAndCol[i][k] = orangeLine;
				}
				else if(k == 12)
				{
					RowAndCol[i][k] = yellowLine;
				}
				k++;
			}
			k = 0;
			i++;
		}
		
		String name = "", location = "";
		double lat = 0.0, lng = 0.0;
		int redL = 0, greenL = 0,
				blueL = 0, brownL = 0,
				purpleL = 0, pinkL = 0,
				orangeL = 0, yellowL = 0;
		boolean wheel = true;
		CTAStation station;
		for(int row = 0; row < RowAndCol.length; row++)
		{
			for(int col = 0; col < RowAndCol[0].length; col++)
			{
				if(col == 0)
				{
					name = RowAndCol[row][col];
				}
				else if(col == 1)
				{
					lat = Double.parseDouble(RowAndCol[row][col]);
				}
				else if(col == 2)
				{
					lng = Double.parseDouble(RowAndCol[row][col]);
				}
				else if(col == 3)
				{
					location = RowAndCol[row][col];
				}
				else if(col == 4)
				{
					wheel = Boolean.parseBoolean(RowAndCol[row][col]);
				}
				else if(col == 5)
				{
					redL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 6)
				{
					greenL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 7)
				{
					blueL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 8)
				{
					brownL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 9)
				{
					purpleL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 10)
				{
					pinkL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 11)
				{
					orangeL = Integer.parseInt(RowAndCol[row][col]);
				}
				else if(col == 12)
				{
					yellowL = Integer.parseInt(RowAndCol[row][col]);
				}
			}
			station = new CTAStation(name, lat, lng, location, wheel, redL, greenL, blueL, brownL, purpleL, pinkL, orangeL, yellowL);
			arrToStation.add(station);
		}		
		CTARoute route = new CTARoute(name, arrToStation);
		
		System.out.print("Enter starting station name: ");
		String startStation = inputStationName.nextLine();
		
		System.out.print("Enter final station name: ");
		String finalStation = inputStationName.nextLine();
		
		ArrayList<String> arr1 = new ArrayList<String>();
		ArrayList<String> arr2 = new ArrayList<String>();
		int count = 0,
				countR = 0, countG = 0,
				countB = 0, countBr = 0,
				countP = 0, countPnk = 0,
				countO = 0, countY = 0;
		int pos1 = 0, pos2 = 0;
		for(int j = 0; j < arrToStation.size(); j++)
		{
			if(arrToStation.get(j).getName().equals(startStation))
			{
				pos1 = j;
				if(arrToStation.get(j).getName().equals(startStation))
				{	
					if(arrToStation.get(j).getRed() != -1)
					{
						count++;
						countR++;
					}
					else if(arrToStation.get(j).getGreen() != -1)
					{
						count++;
						countG++;
					}
					else if(arrToStation.get(j).getBlue() != -1)
					{
						count++;
						countB++;
					}
					else if(arrToStation.get(j).getBrown() != -1)
					{
						count++;
						countBr++;
					}
					else if(arrToStation.get(j).getPurple() != -1)
					{
						count++;
						countP++;
					}
					else if(arrToStation.get(j).getPink() != -1)
					{
						count++;
						countPnk++;
					}
					else if(arrToStation.get(j).getOrange() != -1)
					{
						count++;
						countO++;
					}
					else if(arrToStation.get(j).getYellow() != -1)
					{
						count++;
						countY++;
					}
				}
				if(count != 1 && count != 0)
				{
					/**
					 * if station takes in all 8 lines
					 */
					if(countR == countG && countG == countB && countB == countBr && 
							countBr == countP && countP == countPnk && countPnk == countO
							&& countO == countY)
					{
						arr1.add("Red");
						arr1.add("Green");
						arr1.add("Blue");
						arr1.add("Brown");
						arr1.add("Purple");
						arr1.add("Pink");
						arr1.add("Orange");
						arr1.add("Yellow");
						
					}
					
					/**
					 * if station takes in 7 lines
					 */
					if(countR == countG && countG == countB && countB == countBr && 
						countBr == countP && countP == countPnk && countPnk == countO)
					{
						arr1.add("Red");
						arr1.add("Green");
						arr1.add("Blue");
						arr1.add("Brown");
						arr1.add("Purple");
						arr1.add("Pink");
						arr1.add("Orange");
					}
					else if(countR == countG && countG == countB && countB == countBr && 
							countBr == countP && countP == countPnk && countPnk == countY)
					{
						arr1.add("Red");
						arr1.add("Green");
						arr1.add("Blue");
						arr1.add("Brown");
						arr1.add("Purple");
						arr1.add("Pink");
						arr1.add("Yellow");
					}
					else if(countR == countG && countG == countB && countB == countBr && 
							countBr == countP && countP == countO && countO == countY)
					{
						arr1.add("Red");
						arr1.add("Green");
						arr1.add("Blue");
						arr1.add("Brown");
						arr1.add("Purple");
						arr1.add("Orange");
						arr1.add("Yellow");
					}
					else if(countR == countG && countG == countB && countB == countBr && 
							countBr == countPnk && countPnk == countO && countO == countY)
					{
						arr1.add("Red");
						arr1.add("Green");
						arr1.add("Blue");
						arr1.add("Brown");
						arr1.add("Pink");
						arr1.add("Orange");
						arr1.add("Yellow");
					}
					else if(countR == countG && countG == countB && countB == countP && 
							countP == countPnk && countPnk == countO && countO == countY)
					{
						arr1.add("Red");
						arr1.add("Green");
						arr1.add("Blue");
						arr1.add("Pink");
						arr1.add("Purple");
						arr1.add("Orange");
						arr1.add("Yellow");
					}
					else if(countR == countG && countG == countBr && countBr == countP && 
							countP == countPnk && countPnk == countO && countO == countY)
					{
						arr1.add("Red");
						arr1.add("Green");
						arr1.add("Brown");
						arr1.add("Pink");
						arr1.add("Purple");
						arr1.add("Orange");
						arr1.add("Yellow");
					}
					else if(countR == countB && countB == countBr && countBr == countP && 
							countP == countPnk && countPnk == countO && countO == countY)
					{
						arr1.add("Red");
						arr1.add("Blue");
						arr1.add("Brown");
						arr1.add("Pink");
						arr1.add("Purple");
						arr1.add("Orange");
						arr1.add("Yellow");
					}
					else if(countG == countB && countB == countBr && countBr == countP && 
							countP == countPnk && countPnk == countO && countO == countY)
					{
						arr1.add("Green");
						arr1.add("Blue");
						arr1.add("Brown");
						arr1.add("Purple");
						arr1.add("Pink");
						arr1.add("Orange");
						arr1.add("Yellow");
					}
					
					/**
					 * if station takes in 6 lines
					 */
					// Yellow is absent
					if(countR == countG && countG == countB && countB == countBr && 
							countBr == countP && countP == countPnk)
					{
						arr1.add("Red");
						arr1.add("Green");
						arr1.add("Blue");
						arr1.add("Brown");
						arr1.add("Purple");
						arr1.add("Pink");
					}
					else if(countR == countG && countG == countB && countB == countBr && 
							countBr == countP && countP == countO)
					{
						arr1.add("Red");
						arr1.add("Green");
						arr1.add("Blue");
						arr1.add("Brown");
						arr1.add("Purple");
						arr1.add("Orange");
					}
					else if(countR == countG && countG == countB && countB == countBr && 
							countBr == countPnk && countPnk == countO)
					{
						arr1.add("Red");
						arr1.add("Green");
						arr1.add("Blue");
						arr1.add("Brown");
						arr1.add("Pink");
						arr1.add("Orange");
					}
					else if(countR == countG && countG == countB && countB == countP && 
							countP == countPnk && countPnk == countO)
					{
						arr1.add("Red");
						arr1.add("Green");
						arr1.add("Blue");
						arr1.add("Purple");
						arr1.add("Pink");
						arr1.add("Orange");
					}
					else if(countR == countG && countG == countBr && countBr == countP && 
							countP == countPnk && countPnk == countO)
					{
						arr1.add("Red");
						arr1.add("Green");
						arr1.add("Brown");
						arr1.add("Purple");
						arr1.add("Pink");
						arr1.add("Orange");
					}
					else if(countR == countB && countB == countBr && countBr == countP && 
							countP == countPnk && countPnk == countO)
					{
						arr1.add("Red");
						arr1.add("Blue");
						arr1.add("Brown");
						arr1.add("Purple");
						arr1.add("Pink");
						arr1.add("Orange");
					}
					else if(countR == countB && countB == countBr && countBr == countP && 
							countP == countPnk && countPnk == countO)
					{
						arr1.add("Green");
						arr1.add("Blue");
						arr1.add("Brown");
						arr1.add("Purple");
						arr1.add("Pink");
						arr1.add("Orange");
					}
					
					// Orange is absent
					else if(countR == countG && countG == countB && countB == countBr && 
							countBr == countP && countP == countY)
					{
						arr1.add("Red");
						arr1.add("Green");
						arr1.add("Blue");
						arr1.add("Brown");
						arr1.add("Purple");
						arr1.add("Yellow");
					}
					else if(countR == countG && countG == countB && countB == countBr && 
							countBr == countPnk && countPnk == countY)
					{
						arr1.add("Red");
						arr1.add("Green");
						arr1.add("Blue");
						arr1.add("Brown");
						arr1.add("Pink");
						arr1.add("Yellow");
					}
					else if(countR == countG && countG == countB && countB == countP && 
							countP == countPnk && countPnk == countY)
					{
						arr1.add("Red");
						arr1.add("Green");
						arr1.add("Blue");
						arr1.add("Purple");
						arr1.add("Pink");
						arr1.add("Yellow");
					}
					else if(countR == countG && countG == countBr && countBr == countP && 
							countP == countPnk && countPnk == countY)
					{
						arr1.add("Red");
						arr1.add("Green");
						arr1.add("Brown");
						arr1.add("Purple");
						arr1.add("Pink");
						arr1.add("Yellow");
					}
					else if(countR == countB && countB == countBr && countBr == countP && 
							countP == countPnk && countPnk == countY)
					{
						arr1.add("Red");
						arr1.add("Blue");
						arr1.add("Brown");
						arr1.add("Purple");
						arr1.add("Pink");
						arr1.add("Yellow");
					}
					else if(countG == countB && countB == countBr && countBr == countP && 
							countP == countPnk && countPnk == countY)
					{
						arr1.add("Green");
						arr1.add("Blue");
						arr1.add("Brown");
						arr1.add("Purple");
						arr1.add("Pink");
						arr1.add("Yellow");
					}
					
					//Pink is absent
					else if(countR == countG && countG == countB && countB == countBr && 
							countBr == countO && countO == countY)
					{
						arr1.add("Red");
						arr1.add("Green");
						arr1.add("Blue");
						arr1.add("Brown");
						arr1.add("Orange");
						arr1.add("Yellow");
					}
					else if(countR == countG && countG == countB && countB == countP && 
							countP == countO && countO == countY)
					{
						arr1.add("Red");
						arr1.add("Green");
						arr1.add("Blue");
						arr1.add("Purple");
						arr1.add("Orange");
						arr1.add("Yellow");
					}
					else if(countR == countG && countG == countBr && countBr == countP && 
							countP == countO && countO == countY)
					{
						arr1.add("Red");
						arr1.add("Green");
						arr1.add("Brown");
						arr1.add("Purple");
						arr1.add("Orange");
						arr1.add("Yellow");
					}
					else if(countR == countB && countB == countBr && countBr == countP && 
							countP == countO && countO == countY)
					{
						arr1.add("Red");
						arr1.add("Blue");
						arr1.add("Brown");
						arr1.add("Purple");
						arr1.add("Orange");
						arr1.add("Yellow");
					}
					else if(countG == countB && countB == countBr && countBr == countP && 
							countP == countO && countO == countY)
					{
						arr1.add("Green");
						arr1.add("Blue");
						arr1.add("Brown");
						arr1.add("Purple");
						arr1.add("Orange");
						arr1.add("Yellow");
					}
					
					//Purple is absent
					else if(countR == countG && countG == countB && countB == countPnk && 
							countPnk == countO && countO == countY)
					{
						arr1.add("Red");
						arr1.add("Green");
						arr1.add("Blue");
						arr1.add("Pink");
						arr1.add("Orange");
						arr1.add("Yellow");
					}	
					else if(countR == countG && countG == countBr && countBr == countPnk && 
							countPnk == countO && countO == countY)
					{
						arr1.add("Red");
						arr1.add("Green");
						arr1.add("Brown");
						arr1.add("Pink");
						arr1.add("Orange");
						arr1.add("Yellow");
					}
					else if(countR == countB && countB == countBr && countBr == countPnk && 
							countPnk == countO && countO == countY)
					{
						arr1.add("Red");
						arr1.add("Blue");
						arr1.add("Brown");
						arr1.add("Pink");
						arr1.add("Orange");
						arr1.add("Yellow");
					}
					else if(countG == countB && countB == countBr && countBr == countPnk && 
							countPnk == countO && countO == countY)
					{
						arr1.add("Green");
						arr1.add("Blue");
						arr1.add("Brown");
						arr1.add("Pink");
						arr1.add("Orange");
						arr1.add("Yellow");
					}
					
					//Brown is absent
					else if(countR == countG && countG == countP && countP == countPnk && 
							countPnk == countO && countO == countY)
					{
						arr1.add("Red");
						arr1.add("Green");
						arr1.add("Purple");
						arr1.add("Pink");
						arr1.add("Orange");
						arr1.add("Yellow");
					}
					else if(countR == countB && countB == countP && countP == countPnk && 
							countPnk == countO && countO == countY)
					{
						arr1.add("Red");
						arr1.add("Blue");
						arr1.add("Purple");
						arr1.add("Pink");
						arr1.add("Orange");
						arr1.add("Yellow");
					}
					else if(countG == countB && countB == countP && countP == countPnk && 
							countPnk == countO && countO == countY)
					{
						arr1.add("Green");
						arr1.add("Blue");
						arr1.add("Purple");
						arr1.add("Pink");
						arr1.add("Orange");
						arr1.add("Yellow");
					}
					
					//Blue is absent
					else if(countR == countBr && countBr == countP && countP == countPnk && 
							countPnk == countO && countO == countY)
					{
						arr1.add("Red");
						arr1.add("Brown");
						arr1.add("Purple");
						arr1.add("Pink");
						arr1.add("Orange");
						arr1.add("Yellow");
					}
					else if(countG == countBr && countBr == countP && countP == countPnk && 
							countPnk == countO && countO == countY)
					{
						arr1.add("Green");
						arr1.add("Brown");
						arr1.add("Purple");
						arr1.add("Pink");
						arr1.add("Orange");
						arr1.add("Yellow");
					}
					
					//Green is absent
					else if(countB == countBr && countBr == countP && countP == countPnk && 
							countPnk == countO && countO == countY)
					{
						arr1.add("Blue");
						arr1.add("Brown");
						arr1.add("Purple");
						arr1.add("Pink");
						arr1.add("Orange");
						arr1.add("Yellow");
					}
					/**
					 * if station takes in 5 lines
					 */
					if(countG == countBr && countBr == countP && countP == countPnk &&
							countPnk == countO)
					{
						arr1.add("Green");
						arr1.add("Brown");
						arr1.add("Purple");
						arr1.add("Pink");
						arr1.add("Orange");
					}
					
					/**
					 * if station takes in 4 lines
					 */
					if(countBr == countP && countP == countPnk && countPnk == countO)
					{
						arr1.add("Brown");
						arr1.add("Purple");
						arr1.add("Pink");
						arr1.add("Orange");
					}
					
					/**
					 * if station takes in 3 lines
					 */
					if(countR == countBr && countBr == countP)
					{
						arr1.add("Red");
						arr1.add("Brown");
						arr1.add("Purple");
					}
					else if(countR == countP && countP == countY)
					{
						arr1.add("Red");
						arr1.add("Purple");
						arr1.add("Yellow");
					}
					else if(countR == countG && countG == countO)
					{
						arr1.add("Red");
						arr1.add("Green");
						arr1.add("Orange");
					}
					/**
					 * if station takes in 2 line
					 */
					if(countR == countG)
					{
						arr1.add("Red");
						arr1.add("Green");
					}
					else if(countR == countB)
					{
						arr1.add("Red");
						arr1.add("Blue");
					}
					else if(countR == countBr)
					{
						arr1.add("Red");
						arr1.add("Brown");
					}
					else if(countR == countP)
					{
						arr1.add("Red");
						arr1.add("Purple");
					}
					else if(countR == countPnk)
					{
						arr1.add("Red");
						arr1.add("Pink");
					}
					else if(countR == countO)
					{
						arr1.add("Red");
						arr1.add("Orange");
					}
					else if(countR == countY)
					{
						arr1.add("Red");
						arr1.add("Yellow");
					}
					
					//
					else if(countG == countB)
					{
						arr1.add("Green");
						arr1.add("Blue");
					}
					else if(countG == countBr)
					{
						arr1.add("Green");
						arr1.add("Brown");
					}
					else if(countG == countP)
					{
						arr1.add("Green");
						arr1.add("Purple");
					}
					else if(countG == countPnk)
					{
						arr1.add("Green");
						arr1.add("Pink");
					}
					else if(countG == countO)
					{
						arr1.add("Green");
						arr1.add("Orange");
					}
					else if(countG == countY)
					{
						arr1.add("Green");
						arr1.add("Yellow");
					}
					
					//
					else if(countB == countBr)
					{
						arr1.add("Blue");
						arr1.add("Brown");
					}
					else if(countB == countP)
					{
						arr1.add("Blue");
						arr1.add("Purple");
					}
					else if(countB == countPnk)
					{
						arr1.add("Blue");
						arr1.add("Pink");
					}
					else if(countB == countO)
					{
						arr1.add("Blue");
						arr1.add("Orange");
					}
					else if(countB == countY)
					{
						arr1.add("Blue");
						arr1.add("Yellow");
					}
					
					//
					else if(countBr == countP)
					{
						arr1.add("Brown");
						arr1.add("Purple");
					}
					else if(countBr == countPnk)
					{
						arr1.add("Brown");
						arr1.add("Pink");
					}
					else if(countBr == countO)
					{
						arr1.add("Brown");
						arr1.add("Orange");
					}
					else if(countBr == countY)
					{
						arr1.add("Brown");
						arr1.add("Yellow");
					}
					
					//
					else if(countP == countPnk)
					{
						arr1.add("Purple");
						arr1.add("Pink");
					}
					else if(countP == countO)
					{
						arr1.add("Purple");
						arr1.add("Orange");
					}
					else if(countP == countY)
					{
						arr1.add("Purple");
						arr1.add("Yellow");
					}
					
					//
					else if(countPnk == countO)
					{
						arr1.add("Pink");
						arr1.add("Orange");
					}
					else if(countPnk == countY)
					{
						arr1.add("Pink");
						arr1.add("Yellow");
					}
					
					//
					else if(countO == countY)
					{
						arr1.add("Orange");
						arr1.add("Yellow");
					}
				}			
				
				else if(count == 1)
				{
					if(countR == 1)
					{
						arr1.add("Red");
					}
					else if(countG == 1)
					{
						arr1.add("Green");
					}
					if(countB == 1)
					{
						arr1.add("Blue");
					}
					if(countBr == 1)
					{
						arr1.add("Brown");
					}
					if(countP == 1)
					{
						arr1.add("Purple");
					}
					if(countPnk == 1)
					{
						arr1.add("Pink");
					}
					if(countO == 1)
					{
						arr1.add("Orange");
					}
					if(countY == 1)
					{
						arr1.add("Yellow");
					}
				}
				count = 0;
					countR = 0;
					countG = 0;
					countB = 0;
					countBr = 0;
					countP = 0;
					countPnk = 0;
					countO = 0;
					countY = 0;
			}
			else if(arrToStation.get(j).getName().equals(finalStation))
			{
				pos2 = j;
				if(arrToStation.get(j).getRed() != -1)
				{
					count++;
					countR++;
				}
				else if(arrToStation.get(j).getGreen() != -1)
				{
					count++;
					countG++;
				}
				else if(arrToStation.get(j).getBlue() != -1)
				{
					count++;
					countB++;
				}
				else if(arrToStation.get(j).getBrown() != -1)
				{
					count++;
					countBr++;
				}
				else if(arrToStation.get(j).getPurple() != -1)
				{
					count++;
					countP++;
				}
				else if(arrToStation.get(j).getPink() != -1)
				{
					count++;
					countPnk++;
				}
				else if(arrToStation.get(j).getOrange() != -1)
				{
					count++;
					countO++;
				}
				else if(arrToStation.get(j).getYellow() != -1)
				{
					count++;
					countY++;
				}
			}
			if(count != 1 && count != 0)
			{
				/**
				 * if station takes in all 8 lines
				 */
				if(countR == countG && countG == countB && countB == countBr && 
						countBr == countP && countP == countPnk && countPnk == countO
						&& countO == countY)
				{
					arr2.add("Red");
					arr2.add("Green");
					arr2.add("Blue");
					arr2.add("Brown");
					arr2.add("Purple");
					arr2.add("Pink");
					arr2.add("Orange");
					arr2.add("Yellow");
					
				}
				
				/**
				 * if station takes in 7 lines
				 */
				if(countR == countG && countG == countB && countB == countBr && 
					countBr == countP && countP == countPnk && countPnk == countO)
				{
					arr2.add("Red");
					arr2.add("Green");
					arr2.add("Blue");
					arr2.add("Brown");
					arr2.add("Purple");
					arr2.add("Pink");
					arr2.add("Orange");
				}
				else if(countR == countG && countG == countB && countB == countBr && 
						countBr == countP && countP == countPnk && countPnk == countY)
				{
					arr2.add("Red");
					arr2.add("Green");
					arr2.add("Blue");
					arr2.add("Brown");
					arr2.add("Purple");
					arr2.add("Pink");
					arr2.add("Yellow");
				}
				else if(countR == countG && countG == countB && countB == countBr && 
						countBr == countP && countP == countO && countO == countY)
				{
					arr2.add("Red");
					arr2.add("Green");
					arr2.add("Blue");
					arr2.add("Brown");
					arr2.add("Purple");
					arr2.add("Orange");
					arr2.add("Yellow");
				}
				else if(countR == countG && countG == countB && countB == countBr && 
						countBr == countPnk && countPnk == countO && countO == countY)
				{
					arr2.add("Red");
					arr2.add("Green");
					arr2.add("Blue");
					arr2.add("Brown");
					arr2.add("Pink");
					arr2.add("Orange");
					arr2.add("Yellow");
				}
				else if(countR == countG && countG == countB && countB == countP && 
						countP == countPnk && countPnk == countO && countO == countY)
				{
					arr2.add("Red");
					arr2.add("Green");
					arr2.add("Blue");
					arr2.add("Pink");
					arr2.add("Purple");
					arr2.add("Orange");
					arr2.add("Yellow");
				}
				else if(countR == countG && countG == countBr && countBr == countP && 
						countP == countPnk && countPnk == countO && countO == countY)
				{
					arr2.add("Red");
					arr2.add("Green");
					arr2.add("Brown");
					arr2.add("Pink");
					arr2.add("Purple");
					arr2.add("Orange");
					arr2.add("Yellow");
				}
				else if(countR == countB && countB == countBr && countBr == countP && 
						countP == countPnk && countPnk == countO && countO == countY)
				{
					arr2.add("Red");
					arr2.add("Blue");
					arr2.add("Brown");
					arr2.add("Pink");
					arr2.add("Purple");
					arr2.add("Orange");
					arr2.add("Yellow");
				}
				else if(countG == countB && countB == countBr && countBr == countP && 
						countP == countPnk && countPnk == countO && countO == countY)
				{
					arr2.add("Green");
					arr2.add("Blue");
					arr2.add("Brown");
					arr2.add("Purple");
					arr2.add("Pink");
					arr2.add("Orange");
					arr2.add("Yellow");
				}
				
				/**
				 * if station takes in 6 lines
				 */
				// Yellow is absent
				if(countR == countG && countG == countB && countB == countBr && 
						countBr == countP && countP == countPnk)
				{
					arr2.add("Red");
					arr2.add("Green");
					arr2.add("Blue");
					arr2.add("Brown");
					arr2.add("Purple");
					arr2.add("Pink");
				}
				else if(countR == countG && countG == countB && countB == countBr && 
						countBr == countP && countP == countO)
				{
					arr2.add("Red");
					arr2.add("Green");
					arr2.add("Blue");
					arr2.add("Brown");
					arr2.add("Purple");
					arr2.add("Orange");
				}
				else if(countR == countG && countG == countB && countB == countBr && 
						countBr == countPnk && countPnk == countO)
				{
					arr2.add("Red");
					arr2.add("Green");
					arr2.add("Blue");
					arr2.add("Brown");
					arr2.add("Pink");
					arr2.add("Orange");
				}
				else if(countR == countG && countG == countB && countB == countP && 
						countP == countPnk && countPnk == countO)
				{
					arr2.add("Red");
					arr2.add("Green");
					arr2.add("Blue");
					arr2.add("Purple");
					arr2.add("Pink");
					arr2.add("Orange");
				}
				else if(countR == countG && countG == countBr && countBr == countP && 
						countP == countPnk && countPnk == countO)
				{
					arr2.add("Red");
					arr2.add("Green");
					arr2.add("Brown");
					arr2.add("Purple");
					arr2.add("Pink");
					arr2.add("Orange");
				}
				else if(countR == countB && countB == countBr && countBr == countP && 
						countP == countPnk && countPnk == countO)
				{
					arr2.add("Red");
					arr2.add("Blue");
					arr2.add("Brown");
					arr2.add("Purple");
					arr2.add("Pink");
					arr2.add("Orange");
				}
				else if(countR == countB && countB == countBr && countBr == countP && 
						countP == countPnk && countPnk == countO)
				{
					arr2.add("Green");
					arr2.add("Blue");
					arr2.add("Brown");
					arr2.add("Purple");
					arr2.add("Pink");
					arr2.add("Orange");
				}
				
				// Orange is absent
				else if(countR == countG && countG == countB && countB == countBr && 
						countBr == countP && countP == countY)
				{
					arr2.add("Red");
					arr2.add("Green");
					arr2.add("Blue");
					arr2.add("Brown");
					arr2.add("Purple");
					arr2.add("Yellow");
				}
				else if(countR == countG && countG == countB && countB == countBr && 
						countBr == countPnk && countPnk == countY)
				{
					arr2.add("Red");
					arr2.add("Green");
					arr2.add("Blue");
					arr2.add("Brown");
					arr2.add("Pink");
					arr2.add("Yellow");
				}
				else if(countR == countG && countG == countB && countB == countP && 
						countP == countPnk && countPnk == countY)
				{
					arr2.add("Red");
					arr2.add("Green");
					arr2.add("Blue");
					arr2.add("Purple");
					arr2.add("Pink");
					arr2.add("Yellow");
				}
				else if(countR == countG && countG == countBr && countBr == countP && 
						countP == countPnk && countPnk == countY)
				{
					arr2.add("Red");
					arr2.add("Green");
					arr2.add("Brown");
					arr2.add("Purple");
					arr2.add("Pink");
					arr2.add("Yellow");
				}
				else if(countR == countB && countB == countBr && countBr == countP && 
						countP == countPnk && countPnk == countY)
				{
					arr2.add("Red");
					arr2.add("Blue");
					arr2.add("Brown");
					arr2.add("Purple");
					arr2.add("Pink");
					arr2.add("Yellow");
				}
				else if(countG == countB && countB == countBr && countBr == countP && 
						countP == countPnk && countPnk == countY)
				{
					arr2.add("Green");
					arr2.add("Blue");
					arr2.add("Brown");
					arr2.add("Purple");
					arr2.add("Pink");
					arr2.add("Yellow");
				}
				
				//Pink is absent
				else if(countR == countG && countG == countB && countB == countBr && 
						countBr == countO && countO == countY)
				{
					arr2.add("Red");
					arr2.add("Green");
					arr2.add("Blue");
					arr2.add("Brown");
					arr2.add("Orange");
					arr2.add("Yellow");
				}
				else if(countR == countG && countG == countB && countB == countP && 
						countP == countO && countO == countY)
				{
					arr2.add("Red");
					arr2.add("Green");
					arr2.add("Blue");
					arr2.add("Purple");
					arr2.add("Orange");
					arr2.add("Yellow");
				}
				else if(countR == countG && countG == countBr && countBr == countP && 
						countP == countO && countO == countY)
				{
					arr2.add("Red");
					arr2.add("Green");
					arr2.add("Brown");
					arr2.add("Purple");
					arr2.add("Orange");
					arr2.add("Yellow");
				}
				else if(countR == countB && countB == countBr && countBr == countP && 
						countP == countO && countO == countY)
				{
					arr2.add("Red");
					arr2.add("Blue");
					arr2.add("Brown");
					arr2.add("Purple");
					arr2.add("Orange");
					arr2.add("Yellow");
				}
				else if(countG == countB && countB == countBr && countBr == countP && 
						countP == countO && countO == countY)
				{
					arr2.add("Green");
					arr2.add("Blue");
					arr2.add("Brown");
					arr2.add("Purple");
					arr2.add("Orange");
					arr2.add("Yellow");
				}
				
				//Purple is absent
				else if(countR == countG && countG == countB && countB == countPnk && 
						countPnk == countO && countO == countY)
				{
					arr2.add("Red");
					arr2.add("Green");
					arr2.add("Blue");
					arr2.add("Pink");
					arr2.add("Orange");
					arr2.add("Yellow");
				}	
				else if(countR == countG && countG == countBr && countBr == countPnk && 
						countPnk == countO && countO == countY)
				{
					arr2.add("Red");
					arr2.add("Green");
					arr2.add("Brown");
					arr2.add("Pink");
					arr2.add("Orange");
					arr2.add("Yellow");
				}
				else if(countR == countB && countB == countBr && countBr == countPnk && 
						countPnk == countO && countO == countY)
				{
					arr2.add("Red");
					arr2.add("Blue");
					arr2.add("Brown");
					arr2.add("Pink");
					arr2.add("Orange");
					arr2.add("Yellow");
				}
				else if(countG == countB && countB == countBr && countBr == countPnk && 
						countPnk == countO && countO == countY)
				{
					arr2.add("Green");
					arr2.add("Blue");
					arr2.add("Brown");
					arr2.add("Pink");
					arr2.add("Orange");
					arr2.add("Yellow");
				}
				
				//Brown is absent
				else if(countR == countG && countG == countP && countP == countPnk && 
						countPnk == countO && countO == countY)
				{
					arr2.add("Red");
					arr2.add("Green");
					arr2.add("Purple");
					arr2.add("Pink");
					arr2.add("Orange");
					arr2.add("Yellow");
				}
				else if(countR == countB && countB == countP && countP == countPnk && 
						countPnk == countO && countO == countY)
				{
					arr2.add("Red");
					arr2.add("Blue");
					arr2.add("Purple");
					arr2.add("Pink");
					arr2.add("Orange");
					arr2.add("Yellow");
				}
				else if(countG == countB && countB == countP && countP == countPnk && 
						countPnk == countO && countO == countY)
				{
					arr2.add("Green");
					arr2.add("Blue");
					arr2.add("Purple");
					arr2.add("Pink");
					arr2.add("Orange");
					arr2.add("Yellow");
				}
				
				//Blue is absent
				else if(countR == countBr && countBr == countP && countP == countPnk && 
						countPnk == countO && countO == countY)
				{
					arr2.add("Red");
					arr2.add("Brown");
					arr2.add("Purple");
					arr2.add("Pink");
					arr2.add("Orange");
					arr2.add("Yellow");
				}
				else if(countG == countBr && countBr == countP && countP == countPnk && 
						countPnk == countO && countO == countY)
				{
					arr2.add("Green");
					arr2.add("Brown");
					arr2.add("Purple");
					arr2.add("Pink");
					arr2.add("Orange");
					arr2.add("Yellow");
				}
				
				//Green is absent
				else if(countB == countBr && countBr == countP && countP == countPnk && 
						countPnk == countO && countO == countY)
				{
					arr2.add("Blue");
					arr2.add("Brown");
					arr2.add("Purple");
					arr2.add("Pink");
					arr2.add("Orange");
					arr2.add("Yellow");
				}
				/**
				 * if station takes in 5 lines
				 */
				if(countG == countBr && countBr == countP && countP == countPnk &&
						countPnk == countO)
				{
					arr2.add("Green");
					arr2.add("Brown");
					arr2.add("Purple");
					arr2.add("Pink");
					arr2.add("Orange");
				}
				
				/**
				 * if station takes in 4 lines
				 */
				if(countBr == countP && countP == countPnk && countPnk == countO)
				{
					arr2.add("Brown");
					arr2.add("Purple");
					arr2.add("Pink");
					arr2.add("Orange");
				}
				
				/**
				 * if station takes in 3 lines
				 */
				if(countR == countBr && countBr == countP)
				{
					arr2.add("Red");
					arr2.add("Brown");
					arr2.add("Purple");
				}
				else if(countR == countP && countP == countY)
				{
					arr2.add("Red");
					arr2.add("Purple");
					arr2.add("Yellow");
				}
				else if(countR == countG && countG == countO)
				{
					arr2.add("Red");
					arr2.add("Green");
					arr2.add("Orange");
				}
				/**
				 * if station takes in 2 line
				 */
				if(countR == countG)
				{
					arr2.add("Red");
					arr2.add("Green");
				}
				else if(countR == countB)
				{
					arr2.add("Red");
					arr2.add("Blue");
				}
				else if(countR == countBr)
				{
					arr2.add("Red");
					arr2.add("Brown");
				}
				else if(countR == countP)
				{
					arr2.add("Red");
					arr2.add("Purple");
				}
				else if(countR == countPnk)
				{
					arr2.add("Red");
					arr2.add("Pink");
				}
				else if(countR == countO)
				{
					arr2.add("Red");
					arr2.add("Orange");
				}
				else if(countR == countY)
				{
					arr2.add("Red");
					arr2.add("Yellow");
				}
				
				//
				else if(countG == countB)
				{
					arr2.add("Green");
					arr2.add("Blue");
				}
				else if(countG == countBr)
				{
					arr2.add("Green");
					arr2.add("Brown");
				}
				else if(countG == countP)
				{
					arr2.add("Green");
					arr2.add("Purple");
				}
				else if(countG == countPnk)
				{
					arr2.add("Green");
					arr2.add("Pink");
				}
				else if(countG == countO)
				{
					arr2.add("Green");
					arr2.add("Orange");
				}
				else if(countG == countY)
				{
					arr2.add("Green");
					arr2.add("Yellow");
				}
				
				//
				else if(countB == countBr)
				{
					arr2.add("Blue");
					arr2.add("Brown");
				}
				else if(countB == countP)
				{
					arr2.add("Blue");
					arr2.add("Purple");
				}
				else if(countB == countPnk)
				{
					arr2.add("Blue");
					arr2.add("Pink");
				}
				else if(countB == countO)
				{
					arr2.add("Blue");
					arr2.add("Orange");
				}
				else if(countB == countY)
				{
					arr2.add("Blue");
					arr2.add("Yellow");
				}
				
				//
				else if(countBr == countP)
				{
					arr2.add("Brown");
					arr2.add("Purple");
				}
				else if(countBr == countPnk)
				{
					arr2.add("Brown");
					arr2.add("Pink");
				}
				else if(countBr == countO)
				{
					arr2.add("Brown");
					arr2.add("Orange");
				}
				else if(countBr == countY)
				{
					arr2.add("Brown");
					arr2.add("Yellow");
				}
				
				//
				else if(countP == countPnk)
				{
					arr2.add("Purple");
					arr2.add("Pink");
				}
				else if(countP == countO)
				{
					arr2.add("Purple");
					arr2.add("Orange");
				}
				else if(countP == countY)
				{
					arr2.add("Purple");
					arr2.add("Yellow");
				}
				
				//
				else if(countPnk == countO)
				{
					arr2.add("Pink");
					arr2.add("Orange");
				}
				else if(countPnk == countY)
				{
					arr2.add("Pink");
					arr2.add("Yellow");
				}
				
				//
				else if(countO == countY)
				{
					arr2.add("Orange");
					arr2.add("Yellow");
				}
			}			
			
			else if(count == 1)
			{
				if(countR == 1)
				{
					arr2.add("Red");
				}
				else if(countG == 1)
				{
					arr2.add("Green");
				}
				if(countB == 1)
				{
					arr2.add("Blue");
				}
				if(countBr == 1)
				{
					arr2.add("Brown");
				}
				if(countP == 1)
				{
					arr2.add("Purple");
				}
				if(countPnk == 1)
				{
					arr2.add("Pink");
				}
				if(countO == 1)
				{
					arr2.add("Orange");
				}
				if(countY == 1)
				{
					arr2.add("Yellow");
				}
			}
			count = 0;
			countR = 0;
			countG = 0;
			countB = 0;
			countBr = 0;
			countP = 0;
			countPnk = 0;
			countO = 0;
			countY = 0;
		}
		
		for(int k1 = 0; k1 < arr1.size(); k1++)
		{
			for(int k2 = 0; k2 < arr2.size(); k2++)
			{
				if(arr1.get(k1) == arr2.get(k2))
				{
					System.out.println("Both start and final stations lay on one line, which is " + arr1.get(k1));
				}
				else if(arr1.get(k1) != arr2.get(k2))
				{
					// arr3 is a transit station
					ArrayList<String> arr3 = new ArrayList<String>();
					for(int h = 0; h < arrToStation.size(); h++)
					{
						if(arrToStation.get(h).getGreen() != -1 && 
								arrToStation.get(h).getBlue() != -1 &&
								arrToStation.get(h).getBrown() != -1 &&
								arrToStation.get(h).getPurple() != -1 && 
								arrToStation.get(h).getPink() != -1 &&
								arrToStation.get(h).getOrange() != -1)
						{
							arr3.add("Green");
							arr3.add("Blue");
							arr3.add("Brown");
							arr3.add("Purple");
							arr3.add("Pink");
							arr3.add("Orange");
						}
						else if(arrToStation.get(h).getGreen() != -1 && 
								arrToStation.get(h).getBrown() != -1 &&
								arrToStation.get(h).getPurple() != -1 && 
								arrToStation.get(h).getPink() != -1 &&
								arrToStation.get(h).getOrange() != -1)
						{
							arr3.add("Green");
							arr3.add("Brown");
							arr3.add("Purple");
							arr3.add("Pink");
							arr3.add("Orange");
						}
						else if(arrToStation.get(h).getBrown() != -1 &&
								arrToStation.get(h).getPurple() != -1 && 
								arrToStation.get(h).getPink() != -1 &&
								arrToStation.get(h).getOrange() != -1)
						{
							arr3.add("Brown");
							arr3.add("Purple");
							arr3.add("Pink");
							arr3.add("Orange");
						}
						else if(arrToStation.get(h).getRed() != -1 && 
								arrToStation.get(h).getGreen() != -1 &&
								arrToStation.get(h).getOrange() != -1)
						{
							arr3.add("Red");
							arr3.add("Green");
							arr3.add("Orange");
						}
						else if(arrToStation.get(h).getRed() != -1 && 
								arrToStation.get(h).getBrown() != -1 &&
								arrToStation.get(h).getPurple() != -1)
						{
							arr3.add("Red");
							arr3.add("Brown");
							arr3.add("Purple");
						}
						else if(arrToStation.get(h).getRed() != -1 && 
								arrToStation.get(h).getPurple() != -1 &&
								arrToStation.get(h).getYellow() != -1)
						{
							arr3.add("Red");
							arr3.add("Purple");
							arr3.add("Yellow");
						}
						else if(arrToStation.get(h).getRed() != -1 && 
								arrToStation.get(h).getGreen() != -1)
						{
							arr3.add("Red");
							arr3.add("Green");
						}
						else if(arrToStation.get(h).getRed() != -1 && 
								arrToStation.get(h).getBlue() != -1)
						{
							arr3.add("Red");
							arr3.add("Blue");
						}
						else if(arrToStation.get(h).getRed() != -1 && 
								arrToStation.get(h).getBrown() != -1)
						{
							arr3.add("Red");
							arr3.add("Brown");
						}
						else if(arrToStation.get(h).getRed() != -1 && 
								arrToStation.get(h).getPurple() != -1)
						{
							arr3.add("Red");
							arr3.add("Purple");
						}
						else if(arrToStation.get(h).getRed() != -1 && 
								arrToStation.get(h).getPink() != -1)
						{
							arr3.add("Red");
							arr3.add("Pink");
						}
						else if(arrToStation.get(h).getRed() != -1 && 
								arrToStation.get(h).getOrange() != -1)
						{
							arr3.add("Red");
							arr3.add("Orange");
						}
						else if(arrToStation.get(h).getRed() != -1 && 
								arrToStation.get(h).getYellow() != -1)
						{
							arr3.add("Red");
							arr3.add("Yellow");
						}
						else if(arrToStation.get(h).getGreen() != -1 && 
								arrToStation.get(h).getBlue() != -1)
						{
							arr3.add("Green");
							arr3.add("Blue");
						}
						else if(arrToStation.get(h).getGreen() != -1 && 
								arrToStation.get(h).getBrown() != -1)
						{
							arr3.add("Green");
							arr3.add("Brown");
						}
						else if(arrToStation.get(h).getGreen() != -1 && 
								arrToStation.get(h).getPurple() != -1)
						{
							arr3.add("Green");
							arr3.add("Purple");
						}
						else if(arrToStation.get(h).getGreen() != -1 && 
								arrToStation.get(h).getPink() != -1)
						{
							arr3.add("Green");
							arr3.add("Pink");
						}
						else if(arrToStation.get(h).getGreen() != -1 && 
								arrToStation.get(h).getOrange() != -1)
						{
							arr3.add("Green");
							arr3.add("Orange");
						}
						else if(arrToStation.get(h).getGreen() != -1 && 
								arrToStation.get(h).getYellow() != -1)
						{
							arr3.add("Green");
							arr3.add("Yellow");
						}
						else if(arrToStation.get(h).getBlue() != -1 && 
								arrToStation.get(h).getBrown() != -1)
						{
							arr3.add("Blue");
							arr3.add("Brown");
						}
						else if(arrToStation.get(h).getBlue() != -1 && 
								arrToStation.get(h).getPurple() != -1)
						{
							arr3.add("Blue");
							arr3.add("Purple");
						}
						else if(arrToStation.get(h).getBlue() != -1 && 
								arrToStation.get(h).getPink() != -1)
						{
							arr3.add("Blue");
							arr3.add("Pink");
						}
						else if(arrToStation.get(h).getBlue() != -1 && 
								arrToStation.get(h).getOrange() != -1)
						{
							arr3.add("Blue");
							arr3.add("Orange");
						}
						else if(arrToStation.get(h).getBlue() != -1 && 
								arrToStation.get(h).getYellow() != -1)
						{
							arr3.add("Blue");
							arr3.add("Yellow");
						}
						else if(arrToStation.get(h).getBrown() != -1 && 
								arrToStation.get(h).getPurple() != -1)
						{
							arr3.add("Brown");
							arr3.add("Purple");
						}
						else if(arrToStation.get(h).getBrown() != -1 && 
								arrToStation.get(h).getPink() != -1)
						{
							arr3.add("Brown");
							arr3.add("Pink");
						}
						else if(arrToStation.get(h).getBrown() != -1 && 
								arrToStation.get(h).getOrange() != -1)
						{
							arr3.add("Brown");
							arr3.add("Orange");
						}
						else if(arrToStation.get(h).getBrown() != -1 && 
								arrToStation.get(h).getYellow() != -1)
						{
							arr3.add("Brown");
							arr3.add("Yellow");
						}
						else if(arrToStation.get(h).getPurple() != -1 && 
								arrToStation.get(h).getPink() != -1)
						{
							arr3.add("Purple");
							arr3.add("Pink");
						}
						else if(arrToStation.get(h).getPurple() != -1 && 
								arrToStation.get(h).getOrange() != -1)
						{
							arr3.add("Purple");
							arr3.add("Orange");
						}
						else if(arrToStation.get(h).getPurple() != -1 && 
								arrToStation.get(h).getYellow() != -1)
						{
							arr3.add("Purple");
							arr3.add("Yellow");
						}
						else if(arrToStation.get(h).getPink() != -1 && 
								arrToStation.get(h).getOrange() != -1)
						{
							arr3.add("Pink");
							arr3.add("Orange");
						}
						else if(arrToStation.get(h).getPink() != -1 && 
								arrToStation.get(h).getYellow() != -1)
						{
							arr3.add("Pink");
							arr3.add("Yellow");
						}
						else if(arrToStation.get(h).getOrange() != -1 && 
								arrToStation.get(h).getYellow() != -1)
						{
							arr3.add("Orange");
							arr3.add("Yellow");
						}
						else if(arrToStation.get(h).getRed() != -1)
						{
							arr3.add("Red");
						}
						else if(arrToStation.get(h).getGreen() != -1)
						{
							arr3.add("Green");
						}
						else if(arrToStation.get(h).getBlue() != -1)
						{
							arr3.add("Blue");
						}
						else if(arrToStation.get(h).getBrown() != -1)
						{
							arr3.add("Brown");
						}
						else if(arrToStation.get(h).getPurple() != -1)
						{
							arr3.add("Purple");
						}
						else if(arrToStation.get(h).getPink() != -1)
						{
							arr3.add("Pink");
						}
						else if(arrToStation.get(h).getOrange() != -1)
						{
							arr3.add("Orange");
						}
						else if(arrToStation.get(h).getYellow() != -1)
						{
							arr3.add("Yellow");
						}
						if(arr3.contains(arr1.get(0)) && arr3.contains(arr2.get(0)))
						{
							System.out.println("Path from " + startStation + " to " + 
										finalStation + ". Transit at " + arrToStation.get(h).getName());
						}
						arr3.clear();
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException 
	{		
		System.out.println("Main menu");
		System.out.println("1) Add a new station");
		System.out.println("2) Modify an existing station");
		System.out.println("3) Remove an existing station");
		System.out.println("4) Search for a station");
		System.out.println("5) Display the nearest station");
		System.out.println("6) Generate a path between two stations (1 transit only & different names)");
		System.out.println("7) Exit");
		
		CTARoute station = new CTARoute(null, null);	
		File file = new File("src/Final_Exam/CTAStops.cvs");
		Scanner input = new Scanner(System.in);		
		
		System.out.print("Your choice: ");
		int decision = input.nextInt();
		
		while(decision != 7)
		{
			if(decision == 1)
			{
				addNewStation();
				System.out.println("***********************************");
				System.out.println("Main menu");
				System.out.println("1) Add a new station");
				System.out.println("2) Modify an existing station");
				System.out.println("3) Remove an existing station");
				System.out.println("4) Search for a station");
				System.out.println("5) Display the nearest station");
				System.out.println("6) Generate a path between two stations (1 transit only & different names)");
				System.out.println("7) Exit");
				System.out.print("Your choice: ");
				decision = input.nextInt();
			}
			else if(decision == 2)
			{
				modifyStation();
				System.out.println("***********************************");
				System.out.println("Main menu");
				System.out.println("1) Add a new station");
				System.out.println("2) Modify an existing station");
				System.out.println("3) Remove an existing station");
				System.out.println("4) Search for a station");
				System.out.println("5) Display the nearest station");
				System.out.println("6) Generate a path between two stations (1 transit only & different names)");
				System.out.println("7) Exit");
				System.out.print("Your choice: ");
				decision = input.nextInt();
			}
			else if(decision == 3)
			{
				removeStation();
				System.out.println("***********************************");
				System.out.println("Main menu");
				System.out.println("1) Add a new station");
				System.out.println("2) Modify an existing station");
				System.out.println("3) Remove an existing station");
				System.out.println("4) Search for a station");
				System.out.println("5) Display the nearest station");
				System.out.println("6) Generate a path between two stations (1 transit only & different names)");
				System.out.println("7) Exit");
				System.out.print("Your choice: ");
				decision = input.nextInt();
			}
			else if(decision == 4)
			{
				SearchStation();
				System.out.println("***********************************");
				System.out.println("Main menu");
				System.out.println("1) Add a new station");
				System.out.println("2) Modify an existing station");
				System.out.println("3) Remove an existing station");
				System.out.println("4) Search for a station");
				System.out.println("5) Display the nearest station");
				System.out.println("6) Generate a path between two stations (1 transit only & different names)");
				System.out.println("7) Exit");
				System.out.print("Your choice: ");
				decision = input.nextInt();
			}	
			else if(decision == 5)
			{
				displayNearest();
				System.out.println("***********************************");
				System.out.println("Main menu");
				System.out.println("1) Add a new station");
				System.out.println("2) Modify an existing station");
				System.out.println("3) Remove an existing station");
				System.out.println("4) Search for a station");
				System.out.println("5) Display the nearest station");
				System.out.println("6) Generate a path between two stations (1 transit only & different names)");
				System.out.println("7) Exit");
				System.out.print("Your choice: ");
				decision = input.nextInt();
			}		
			else if(decision == 6)
			{
				pathGenerator();
				System.out.println("***********************************");
				System.out.println("Main menu");
				System.out.println("1) Add a new station");
				System.out.println("2) Modify an existing station");
				System.out.println("3) Remove an existing station");
				System.out.println("4) Search for a station");
				System.out.println("5) Display the nearest station");
				System.out.println("6) Generate a path between two stations (1 transit only & different names)");
				System.out.println("7) Exit");
				System.out.print("Your choice: ");
				decision = input.nextInt();
			}			
			else
			{
				System.out.println("***********************************");
				System.out.println("Incorrect value. Please, enter from 1 to 4");
				System.out.println("Main menu");
				System.out.println("1) Add a new station");
				System.out.println("2) Modify an existing station");
				System.out.println("3) Remove an existing station");
				System.out.println("4) Search for a station");
				System.out.println("5) Display the nearest station");
				System.out.println("6) Generate a path between two stations (1 transit only & different names)");
				System.out.println("7) Exit");
				System.out.print("Your choice: ");
				decision = input.nextInt();				
			}
		}
		
		if(decision == 7)
		{
			System.out.println("The end of the program.");
		}
	}
}
