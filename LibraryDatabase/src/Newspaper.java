
public class Newspaper extends Item
{
	private String location;
	private String date;
	
	public Newspaper()
	{
		super();
		this.location = null;
		this.date = null;
	}
	
	public void setLocation(String location)
	{
		this.location = location;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public String getLocation()
	{
		return this.location;
	}
	
	public String getDate()
	{
		return this.date;
	}
	
	public String toString()
	{
		return "Newspaper:\n\tTitle:" + this.getTitle() + "\tLocation: " + this.location + "\tDate: " + this.date;
	}
}
