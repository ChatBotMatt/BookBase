import java.util.Date;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Book implements Serializable {

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

	public Book() {

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
		this.author = new Author();
		author.setName(authorName);
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
		for (int i = 0; i < genres.length; i++) {
			genre.add(genres[i]);
		}
	}

	public Date getPubDate() {
		return pubDate;
	}

	public String getPubDateAsString() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + Float.floatToIntBits(goodreadsRating);
		result = prime * result + (inSeries ? 1231 : 1237);
		result = prime * result + pageCount;
		result = prime * result + ((pubDate == null) ? 0 : pubDate.hashCode());
		result = prime * result + Float.floatToIntBits(rating);
		result = prime * result + ((series == null) ? 0 : series.hashCode());
		result = prime * result + seriesNo;
		result = prime * result + ((similarBooks == null) ? 0 : similarBooks.hashCode());
		result = prime * result + timesRead;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((universe == null) ? 0 : universe.hashCode());
		result = prime * result + (int) (wordCount ^ (wordCount >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null) {
				return false;
			}
		} else if (!author.equals(other.author)) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (genre == null) {
			if (other.genre != null) {
				return false;
			}
		} else if (!genre.equals(other.genre)) {
			return false;
		}
		if (Float.floatToIntBits(goodreadsRating) != Float.floatToIntBits(other.goodreadsRating)) {
			return false;
		}
		if (inSeries != other.inSeries) {
			return false;
		}
		if (pageCount != other.pageCount) {
			return false;
		}
		if (pubDate == null) {
			if (other.pubDate != null) {
				return false;
			}
		} else if (!pubDate.equals(other.pubDate)) {
			return false;
		}
		if (Float.floatToIntBits(rating) != Float.floatToIntBits(other.rating)) {
			return false;
		}
		if (series == null) {
			if (other.series != null) {
				return false;
			}
		} else if (!series.equals(other.series)) {
			return false;
		}
		if (seriesNo != other.seriesNo) {
			return false;
		}
		if (similarBooks == null) {
			if (other.similarBooks != null) {
				return false;
			}
		} else if (!similarBooks.equals(other.similarBooks)) {
			return false;
		}
		if (timesRead != other.timesRead) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		if (universe == null) {
			if (other.universe != null) {
				return false;
			}
		} else if (!universe.equals(other.universe)) {
			return false;
		}
		if (wordCount != other.wordCount) {
			return false;
		}
		return true;
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
