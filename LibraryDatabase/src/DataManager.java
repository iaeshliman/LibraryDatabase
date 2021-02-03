import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DataManager
{
	private ArrayList<Item> items;
	
	public DataManager(String fileName)
	{
		items = new ArrayList<Item>();
		
		try(Scanner scan = new Scanner(new File(fileName)))
		{
			while(scan.hasNext())
			{
				String line = scan.nextLine();
				String data = "";
				String endTag = "";
				
				switch(line)
				{
				case "<Book>":
					endTag = "</Book>";
					break;
				case "<Newspaper>":
					endTag = "</Newspaper>";
					break;
				default:
					break;
				}
				
				while((line=scan.nextLine()).compareToIgnoreCase(endTag)!=0)
				{
					data += line + "\n";
				}
				
				Scanner parseData = new Scanner(data);
				HashMap<String,String> dataMap = new HashMap<String,String>();
				
				while(parseData.hasNext())
				{
					String dataLine = parseData.nextLine();
					
					switch(dataLine.split(">")[0] + ">")
					{
					case "<Title>":
						dataMap.put("Title", dataLine.substring(7,dataLine.length()-8));
						break;
					case "<Author>":
						dataMap.put("Author", dataLine.substring(8,dataLine.length()-9));
						break;
					case "<Pages>":
						dataMap.put("Pages", dataLine.substring(7,dataLine.length()-8));
						break;
					case "<Location>":
						dataMap.put("Location", dataLine.substring(10,dataLine.length()-11));
						break;
					case "<Date>":
						dataMap.put("Date", dataLine.substring(6,dataLine.length()-7));
						break;
					default:
						break;
					}
				}
				switch(endTag)
				{
				case "</Book>":
					Book book = new Book();
					items.add(book);
					if(dataMap.containsKey("Title"))
					{
						book.setTitle(dataMap.get("Title"));
					}
					if(dataMap.containsKey("Author"))
					{
						book.setAuthor(dataMap.get("Author"));
					}
					if(dataMap.containsKey("Pages"))
					{
						book.setPageCount(Integer.parseInt(dataMap.get("Pages")));
					}
					break;
				case "</Newspaper>":
					Newspaper newspaper = new Newspaper();
					items.add(newspaper);
					if(dataMap.containsKey("Title"))
					{
						newspaper.setTitle(dataMap.get("Title"));
					}
					if(dataMap.containsKey("Location"))
					{
						newspaper.setLocation(dataMap.get("Location"));
					}
					if(dataMap.containsKey("Date"))
					{
						newspaper.setDate(dataMap.get("Date"));
					}
					break;
				default:
					break;
				}
				parseData.close();
			}
			scan.close();
		}
		catch(FileNotFoundException e)
		{
			System.err.println("File " + fileName + " was not found!");
			e.printStackTrace();
		}
	}
	
	public ArrayList<Item> getItems()
	{
		return this.items;
	}
	
	public String toString()
	{
		String toString = "";
		
		for(Item i : items)
		{
			toString += i.toString() + "\n";
		}
		
		return toString;
	}
}
