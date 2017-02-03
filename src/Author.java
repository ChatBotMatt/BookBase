import java.util.ArrayList;

public class Author {
	private String name;
	private ArrayList<Book> books;
	private String genre = "Unknown";

	public Author(String name, ArrayList<Book> books, String genre) {
		this.name = name;
		this.genre = genre;
		if (books == null){
			this.books = new ArrayList<Book>();
		}
		else{
			this.books = books;
		}
	}

	public Author(String name, ArrayList<Book> books) {
		this(name,books,"Unknown");
	}

	public Author(String name, String genre) {
		this(name,null,genre);
	}

	public Author(String name) {
		this(name,null,"Unknown");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		String text = name + " has written ";
		if (books.isEmpty()) {
			text += " no books to date.";
			return text;
		} else {
			text = +books.size() + " books ";
		}
		text += " and their main genre is " + genre + ".";
		return text;
	}
}
