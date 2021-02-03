
public abstract class Item
{
	private String title;
	
	public Item()
	{
		this.title = null;
	}
	
	protected void setTitle(String title)
	{
		this.title = title;
	}
	
	protected String getTitle()
	{
		return this.title;
	}
}
