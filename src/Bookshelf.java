import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bookshelf {

	ArrayList<Book> books;
	Map<String, Series> series; // Series Name / Series Object
	ArrayList<Author> authors;
	
	public Bookshelf(ArrayList<Book> books, HashMap<String, Series> series, ArrayList<Author> authors) {
		this.books = books;
		this.series = series;
		this.authors = authors;
	}

	public Bookshelf(ArrayList<Book> books) {
		this.books = books;
		for (Book book : books) {
			try {
				addSeries(book.getSeries());
			} catch (IllegalArgumentException e) {
			}
		}
	}

	public Bookshelf() {
		this(new ArrayList<Book>(), new HashMap<String, Series>(), new ArrayList<Author>());
	}

	public void addBook(Book book) throws IllegalArgumentException, NullPointerException {
		if (book != null){
			if (!books.contains(book)) {
				books.add(book);
				try {
					addAuthor(book.getAuthor());
				} catch (NullPointerException n) {
					throw n;
				}
				try {
					addSeries(book.getSeries());
				} catch (NullPointerException n) {
					throw n;
				}
			} else {
				throw new IllegalArgumentException("Book already exists.");
			}
		}
		else{
			throw new NullPointerException("No valid Book passed.");
		}

	}

	public void addAuthor(Author add) throws IllegalArgumentException, NullPointerException {
		if (add != null) {
			if (!authors.contains(add)) {
				authors.add(add);
				for (Book book : add.getBooks()) {
					try{
						addBook(book);
					}
					catch (IllegalArgumentException i){ //Skip the existing book
						
					}
				}
			} else {
				throw new IllegalArgumentException("That author already exists.");
			}
		} else {
			throw new NullPointerException("No valid Author passed");
		}

	}

	public Author findAuthor(String name, Book book) throws IllegalArgumentException {
		for (Author author : authors) {
			if ((author.getName().equals(name)) && (author.getBooks().contains(book))) {
				return author;
			}
		}
		throw new IllegalArgumentException("That author already exists.");
	}

	public void addSeries(Series add) throws IllegalArgumentException, NullPointerException {
		if (add != null) {
			if (!series.containsValue(add)) {
				series.put(add.getName(), add);
				if (!authors.contains(add.getAuthor())){
					try{
						addAuthor(add.getAuthor());
					}
					catch (IllegalArgumentException i){}
				}
			} else {
				throw new IllegalArgumentException("That series already exists.");
			}
		} else {
			throw new NullPointerException("No valid Series passed");
		}

	}

	public Series findSeries(String name) throws IllegalArgumentException {
		if (series.containsKey(name)) {
			return series.get(name);
		} else {
			throw new IllegalArgumentException("Series does not exist.");
		}
	}

	public Series findSeries(String name, String bookName) {
		if (series.containsKey(name)) {
			if (series.get(name).checkBook(bookName)) {
				return series.get(name);
			}
		}
		throw new IllegalArgumentException("Series does not exist.");
	}
}
