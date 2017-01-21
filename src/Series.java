import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Series{
    private static Map<String,Series> series = new HashMap<String,Series>();
    
    private String name;
    private Author author;
    private ArrayList<Book> books;
    
    private Series(String name, Author author, ArrayList<Book> books){
    	if (books == null){
    		books = new ArrayList<Book>();
    	}
    	this.name = name;
    	this.author = author;
    	this.books = books;
    }
    
    private Series(String name, Author author){ //TODO Needed?
        this(name,author,null);
    }
	
	public static Series findOrCreate(String name, Author author, ArrayList<Book> books){
		Series series = null;
		try{
			series = findSeries(name);
		}
		catch(NoSuchSeriesException e){
			try {
				series = createSeries(name,author,books);
			} catch (SeriesExistsException e2) {
				e.printStackTrace();
			}
		}
		return series;
	}
	
	public static Series findSeries(String name) throws NoSuchSeriesException{
		if (series.containsKey(name)){
            return series.get(name);
        }
		else{
			throw new NoSuchSeriesException();
		}
	}
	
	/**
	* Returns true if a new series is made and added, False if the Series already exists and is thus not added.
	 * @throws SeriesExistsException 
	*/
	public static Series createSeries(String name, Author author, ArrayList<Book> books) throws SeriesExistsException{
		if (series.containsKey(name)){
            throw new SeriesExistsException();
        }
        else{
			Series mySeries = new Series(name, author, books);
			series.put(name,mySeries);
            return mySeries;
        }
	}
    
    public static Series getSeries(String name, Author author, ArrayList<Book> books){
        if (series.containsKey(name)){
            return series.get(name);
        }
        else{
			Series mySeries = new Series(name, author, books);
			series.put(name,mySeries);
            return mySeries;
        }
    }
    
    public static Series getSeries(String name, Author author){
    	ArrayList<Book> books = new ArrayList<Book>(3);
    	return getSeries(name,author,books);
    }
    
    public static Series getSeries(String name){
    	return getSeries(name,new Author("Unknown"));
    }
    
    public String toString(){
    	return name + " was written by " + author + " and contains " + books.size() + " books.";
    }
}
