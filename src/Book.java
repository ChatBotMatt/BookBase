import java.util.Date;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Book implements Serializable{

	private static final long serialVersionUID = -5525644198431199870L;
	
	private String title;
	private String description;
	
	private boolean inSeries;
	private Series series;
	private int seriesNo;
	
	private ArrayList<Book> universe;
	private ArrayList<Book> similarBooks;
	
	private Author author;
	
	private float rating;
	private float goodreadsRating;
	
	private int timesRead;
	private ArrayList<String> genre; 
	private Date pubDate;
	private int pageCount;
	
	private long wordCount;
	
	public Book(){
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isInSeries() {
		return inSeries;
	}

	public void setInSeries(boolean inSeries) {
		this.inSeries = inSeries;
	}

	public Series getSeries() {
		return series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}

	public int getSeriesNo() {
		return seriesNo;
	}

	public void setSeriesNo(int seriesNo) {
		this.seriesNo = seriesNo;
	}

	public ArrayList<Book> getUniverse() {
		return universe;
	}

	public void setUniverse(ArrayList<Book> universe) {
		this.universe = universe;
	}

	public ArrayList<Book> getSimilarBooks() {
		return similarBooks;
	}

	public void setSimilarBooks(ArrayList<Book> similarBooks) {
		this.similarBooks = similarBooks;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	/**
	 * Sets the Author to be a default Author object, with the given name.
	 * @param authorName The author's name.
	 */
	public void setAuthor(String authorName) {
		this.author = new Author(authorName);
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public float getGoodreadsRating() {
		return goodreadsRating;
	}

	public void setGoodreadsRating(float goodreadsRating) {
		this.goodreadsRating = goodreadsRating;
	}

	public int getTimesRead() {
		return timesRead;
	}

	public void setTimesRead(int timesRead) {
		this.timesRead = timesRead;
	}

	public ArrayList<String> getGenre() {
		return genre;
	}

	public void setGenre(ArrayList<String> genres) {
		this.genre = genres;
	}
	
	/**
	 * If a book only has one genre, this convenience method can be used.
	 * @param genre
	 */
	public void setGenre(String genre) {
		this.genre = new ArrayList<String>(1);
		this.genre.add(genre);
	}
	
	public void setGenre(String[] genres) {
		genre = new ArrayList<String>(genres.length);
		for (int i = 0; i < genres.length; i++){
			genre.add(genres[i]);
		}
	}

	public Date getPubDate() {
		return pubDate;
	}
	
	public String getPubDateAsString(){
		return new SimpleDateFormat("dd/MM/yyyy").format(pubDate);
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public long getWordCount() {
		return wordCount;
	}

	public void setWordCount(long wordCount) {
		this.wordCount = wordCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/*@Override
	public String toString() {
		String toString = "Title: " + title + ".\nDescription: " + description + "\n";
		if(series.compareTo("None") != 0){
			toString += "Series: " + series + ".\nBook Number: " + seriesNo + "\n";
		}
		toString += "Author: " + author + ".\nRating: " + rating + "\nGoodreads Rating: " + goodreadsRating + "\nTimes Read: " + timesRead + ".\n";
		return toString;
	}*/
	
	
}
