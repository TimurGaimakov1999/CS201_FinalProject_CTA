package project;

public class CTAStation extends GeoLocation
{
	private String name;
	private String location;
	private boolean opened;
	private boolean wheelchair;;
	private int redLine;
	private int greenLine;
	private int blueLine;
	private int brownLine;
	private int purpleLine;
	private int pinkLine;
	private int orangeLine;
	private int yellowLine;
	
	public CTAStation(String name, double lat1, double long1, String location, boolean wheelchair, boolean opened)
	{
		super(lat1, long1);
		this.name = name;
		this.location = location;
		this.wheelchair = wheelchair;
		this.opened = opened;
	}

	public CTAStation(String name, double lat1, double long1, String location, boolean wheelchair, int redLine, int greenLine,
			int blueLine, int brownLine, int purpleLine, int pinkLine, int orangeLine, int yellowLine)
	{
		super(lat1, long1);
		this.name = name;
		this.location = location;
		this.wheelchair = wheelchair;
		this.redLine = redLine;
		this.greenLine = greenLine;
		this.blueLine = blueLine;
		this.brownLine = brownLine;
		this.purpleLine = purpleLine;
		this.pinkLine = pinkLine;
		this.orangeLine = orangeLine;
		this.yellowLine = yellowLine;
	}
	public String getName()
	{
		return name;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public boolean getWheelchair()
	{
		return wheelchair;
	}
	
	public boolean getOpened()
	{
		return opened;
	}
	
	public int getRed()
	{
		return redLine;
	}
	
	public int getGreen()
	{
		return greenLine;
	}
	
	public int getBlue()
	{
		return blueLine;
	}
	
	public int getBrown()
	{
		return brownLine;
	}
	
	public int getPurple()
	{
		return purpleLine;
	}
	
	public int getPink()
	{
		return pinkLine;
	}
	
	public int getOrange()
	{
		return orangeLine;
	}
	
	public int getYellow()
	{
		return yellowLine;
	}
	
	public String toString()
	{
		return "Name: " + getName() + 
				"\tLatitude: " + getLat() +
				"\tLongitude: " + getLng() +
				"\tLocation: " + getLocation() +
				"\tWheelchair: " + getWheelchair() +
				"\tRed Line: " + getRed() +
				"\tGreen Line: " + getGreen() +
				"\tBlue Line: " + getBlue() +
				"\tBrown Line: " + getBrown() +
				"\tPurple Line: " + getPurple() +
				"\tPink Line: " + getPink() +
				"\tOrange Line: " + getOrange() +
				"\tYellow Line: " + getYellow();
	}
	
	public boolean equals(CTAStation station)
	{
		if(name.equals(station.getName()))
		{
			return true;
		}
		return false;
	}
}
