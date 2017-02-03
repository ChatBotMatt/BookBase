import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Series implements Serializable{
   
	private static final long serialVersionUID = -4549229975279965862L;
	
	private String name;
    private Author author;
    private ArrayList<Book> books = new ArrayList<Book>();
    
    private Series(){
        
    }
	
    public boolean checkBook(String bookname){
    	for (Book book: books){
    		if (book.getTitle().equals(bookname)){
    			return true;
    		}
    	}
    	return false;
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((books == null) ? 0 : books.hashCode());
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
		Series other = (Series) obj;
		if (author == null) {
			if (other.author != null) {
				return false;
			}
		} else if (!author.equals(other.author)) {
			return false;
		}
		if (books == null) {
			if (other.books != null) {
				return false;
			}
		} else if (!books.equals(other.books)) {
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

	public String toString(){
    	return name + " was written by " + author + " and contains " + books.size() + " books.";
    }
}
