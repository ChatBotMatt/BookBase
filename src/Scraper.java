import java.io.IOException;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraper {
	
	Document doc;
	Elements elements;
	HashMap<String,Book> bookshelf;
	
	private String titleField = "bookTitle";
	private String descField = "description";
	private String authorField = "authorName";
	//private String seriesField = 
	
	public Scraper() {
		elements = new Elements();
		bookshelf = new HashMap<String,Book>(100);
		addBook("https://www.goodreads.com/book/show/13569581-blood-song");	
		addBook("https://www.goodreads.com/book/show/13569581-blood-song");
	}
	
	/**
	 * Adds a book to the bookshelf via URL. 
	 * @param URL The URL of the book on Goodreads.
	 * @return True if added, False otherwise.
	 */
	private boolean addBook(String URL){
		Book newBook = scrapeBook(URL);
		if (newBook != null){
			bookshelf.put(newBook.getTitle(),newBook);
			return true;
		}
		return false;
	}
	
	/**
	 * Scrapes Goodreads to get data about a book referenced by the URL.
	 * @param URL
	 * @return newBook The Book created by said data.
	 */
	public Book scrapeBook(String URL){
		
		try {		
			doc = Jsoup.connect(URL).get();
		} catch (IOException e) {
			System.out.println("Not a valid URL!");
			return null;
		}
		Element titleElem = doc.getElementById(titleField);
		String title = titleElem.ownText();
		if (checkShelves(title)){
			System.out.println("The book is already on your bookshelf!");
			return null;
		}
		String series = titleElem.child(0).text();
		series = series.substring(1, series.length()-1);
		int num = Integer.parseInt(series.substring(series.lastIndexOf("#")+1));
		series = series.substring(0, series.lastIndexOf("#")-1);
		String description = doc.getElementById(descField).child(1).text();
		Author author = new Author(doc.getElementsByClass(authorField).first().text());
		float rating = Float.parseFloat(doc.getElementsByClass("average").first().text());
		Book newBook = new Book();//(title,description,series,num,author,0,rating,0); TODO
		System.out.println(newBook.toString());
		return newBook;
	}
	
	/**
	 * Checks if a book is already included.
	 * @param title The title to look for.
	 * @return True if the bookshelf contains it. False otherwise.
	 */
	private boolean checkShelves(String title){
		if ((bookshelf.containsKey(title)) || bookshelf.containsKey(title.toLowerCase())){
			return true;
		}
		else{
			return false;
		}
	}
}
