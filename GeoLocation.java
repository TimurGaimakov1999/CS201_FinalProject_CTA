package project;


public class GeoLocation 
{
	private double lat;
	private double lng;
	
	public GeoLocation()
	{
		lat = 0.0;
		lng = 0.0;
	}
	
	public GeoLocation(double lat, double lng)
	{
		this.lat = lat;
		this.lng = lng;
	}	
	
	public double getLat()
	{
		return lat;
	}
	
	public double getLng()
	{
		return lng;
	}
	
	public void setLat(double latitude)
	{
		lat = latitude;
	}
	
	public void setLng(double longitude)
	{
		lng = longitude;
	}
	
	public String toString() 
	{
		return "Latitude: " + lat + "\nLongitude: " + lng;
	}
	
	public boolean consistentLat()
	{
		return ((lat > -90.0) && (lat < 90.0));		
	}
	
	public boolean consistentLng()
	{
		return ((lng > -180.0) && (lng < 180.0));		
	}
	
	/**public double calcDistance(GeoLocation loc) //I do not know how to do it
	{
		return Math.sqrt(Math.pow(lat1 - loc.getLat(), 2) + Math.pow(long1 - loc.getLng(), 2));		
	}
	*/
	
	public double calcDistance(double lat2, double long2)
	{
		return Math.sqrt(Math.pow(getLat() - lat2, 2) + Math.pow(getLng() - long2, 2));		
	}
}
