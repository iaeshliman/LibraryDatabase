
public class Book extends Item
{
	private String author;
	private int pageCount;
	
	public Book()
	{
		super();
		this.author = null;
		this.pageCount = 0;
	}
	
	public void setAuthor(String author)
	{
		this.author = author;
	}
	
	public void setPageCount(int pageCount)
	{
		this.pageCount = pageCount;
	}
	
	public String getAuthor()
	{
		return this.author;
	}
	
	public int getPageCount()
	{
		return this.pageCount;
	}
	
	public String toString()
	{
		return "Book:\n\tTitle:" + this.getTitle() + "\tAuthor: " + this.author + "\tPage Count: " + this.pageCount;
	}
}
