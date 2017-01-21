import java.util.Date;
import java.util.ArrayList;

public class Book {
	private String title;
	private String description;
	private boolean inSeries;
	private String series;
	private int seriesNo;
	private Author author;
	private float rating;
	private float goodreadsRating;
	private int timesRead;
	private ArrayList<String> genre; 
	private Date pubDate;
	private int pageCount;
	
	private String[] seriesByAuthor; //Series objects?
	private Book[] universe;
	private Book[] similarBooks;
	private String country;
	private long wordCount;
	
	public Book(){
		
	}
	
	public Book(String title, String description, boolean inSeries, String series, int seriesNo, Author author, float rating, float goodreadsRating, int timesRead, ArrayList<String> genre, Date pubDate, int pageCount, String[] seriesByAuthor, Book[] universe, Book[] similarBooks, String country, long wordCount) {
		this.title = title;
		this.description = description;
		this.inSeries = inSeries;
		this.series = series;
		this.seriesNo = seriesNo;
		this.author = author;
		this.rating = rating;
		this.goodreadsRating = goodreadsRating;
		this.timesRead = timesRead;
		this.genre = genre;
		this.pubDate = pubDate;
		this.pageCount = pageCount;
		this.seriesByAuthor = seriesByAuthor;
		this.universe = universe;
		this.similarBooks = similarBooks;
		this.country = country;
		this.wordCount = wordCount;
	}

	public Book(String title, String description, Author author, float rating, float goodreadsRating, int timesRead) {
		this.title = title;
		this.description = description;
		this.setSeries("None");
		this.setSeriesNo(1);
		this.author = author;
		this.rating = rating;
		this.goodreadsRating = goodreadsRating;
		this.timesRead = timesRead;
	}
	
	public Book(String title, String description, String series, int seriesNo, Author author, float rating, float goodreadsRating, int timesRead) {
		this.title = title;
		this.description = description;
		this.setSeries(series);
		this.setSeriesNo(seriesNo);
		this.author = author;
		this.rating = rating;
		this.goodreadsRating = goodreadsRating;
		this.timesRead = timesRead;
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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getTimesRead() {
		return timesRead;
	}

	public void setTimesRead(int timesRead) {
		this.timesRead = timesRead;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public int getSeriesNo() {
		return seriesNo;
	}

	public void setSeriesNo(int seriesNo) {
		this.seriesNo = seriesNo;
	}

	public boolean isInSeries() {
		return inSeries;
	}

	public void setInSeries(boolean inSeries) {
		this.inSeries = inSeries;
	}

	public float getGoodreadsRating() {
		return goodreadsRating;
	}

	public void setGoodreadsRating(float goodreadsRating) {
		this.goodreadsRating = goodreadsRating;
	}

	public ArrayList<String> getGenre() {
		return genre;
	}

	public void setGenre(ArrayList<String> genre) {
		this.genre = genre;
	}

	public Date getPubDate() {
		return pubDate;
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

	public String[] getSeriesByAuthor() {
		return seriesByAuthor;
	}

	public void setSeriesByAuthor(String[] seriesByAuthor) {
		this.seriesByAuthor = seriesByAuthor;
	}

	public Book[] getUniverse() {
		return universe;
	}

	public void setUniverse(Book[] universe) {
		this.universe = universe;
	}

	public Book[] getSimilarBooks() {
		return similarBooks;
	}

	public void setSimilarBooks(Book[] similarBooks) {
		this.similarBooks = similarBooks;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getWordCount() {
		return wordCount;
	}

	public void setWordCount(long wordCount) {
		this.wordCount = wordCount;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		String toString = "Title: " + title + ".\nDescription: " + description + "\n";
		if(series.compareTo("None") != 0){
			toString += "Series: " + series + ".\nBook Number: " + seriesNo + "\n";
		}
		toString += "Author: " + author + ".\nRating: " + rating + "\nGoodreads Rating: " + goodreadsRating + "\nTimes Read: " + timesRead + ".\n";
		return toString;
	}
	
	
}
