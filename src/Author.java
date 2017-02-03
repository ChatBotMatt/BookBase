import java.io.Serializable;
import java.util.ArrayList;

public class Author implements Serializable{

	private String name;
	private ArrayList<Book> books = new ArrayList<Book>();
	private ArrayList<String> genres = new ArrayList<String>();
	
	private static final long serialVersionUID = -3448595689316724159L;

	public Author(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (!name.isEmpty()){
			this.name = name;
		}
		else{
			throw new IllegalArgumentException("A name cannot be blank");
		}
		
	}

	public ArrayList<Book> getBooks() {
		return books;
	}
	
	public void addBook(Book book){
		books.add(book);
	}

	public void setBooks(ArrayList<Book> books) {
		if (books != null){
			this.books = books;
		}
		else{
			throw new NullPointerException();
		}
		
	}

	public ArrayList<String> getGenre() {
		return genres;
	}

	public void setGenre(ArrayList<String> genre) {
		if (genre != null){
			this.genres = genre;
		}
		else{
			throw new NullPointerException();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		result = prime * result + ((genres == null) ? 0 : genres.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Author other = (Author) obj;
		if (books == null) {
			if (other.books != null) {
				return false;
			}
		} else if (!books.equals(other.books)) {
			return false;
		}
		if (genres == null) {
			if (other.genres != null) {
				return false;
			}
		} else if (!genres.equals(other.genres)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
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
		text += " and they work in the following genres: ";
		for (String genre: genres){
			text+=genre+"\n";
		}
		text+=".";
		return text;
	}
}
