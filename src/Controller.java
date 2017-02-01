import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.ColumnConstraints;

public class Controller {
	
	private Form gui;

	public Controller(Form form){
		gui = form;
	}
	
	/**
	 * Initial actions for the GUI, such as setting start text for the "center" element that describes book info.
	 */
	public void setup(){
		gui.getCenter().setText("No book info is yet available. Submit some!");
		constrain(gui.getGroups());
	}
	
	/**
	 * Sets up Constraints for the input boxes in the left side of the BorderPane that comprises the form.
	 * @param groups The input boxes.
	 */
	private void constrain(ArrayList<InputGroup> groups) {

		int longest = 0;
		for (InputGroup group : groups) {
			System.out.println(group.getDescriptor().getLayoutBounds().getWidth());
			String text = group.getDescriptor().getText();
			if (text.length() > longest) {
				longest = text.length();
			}
		}
		for (InputGroup group : groups) {
			ColumnConstraints label = new ColumnConstraints(7 * longest);
			group.getColumnConstraints().add(new ColumnConstraints());
			group.getColumnConstraints().add(label);
		}
	}
	
	public boolean validateFields(ArrayList<InputGroup> groups) {
		for (InputGroup group : groups) {
			if (!group.validate()) {
				return false;
			}
		}
		return true;
		//return (title.validate() && author.validate() && genre.validate() && rating.validate(true));
		//return (validate(title) && validate(author) && validate(genre) && validate(rating));
	}
	
	public Alert submit() {
		gui.getGenre().getSubmit().fire();
		if (validateFields(gui.getGroups())) {	
			gui.updateInfo();
			gui.clearFields();
			Book newBook = createBook();
			//System.out.println(newBook.toString());
			return new Alert(AlertType.INFORMATION, "The book has been submitted!");
		} else {
			return new Alert(AlertType.ERROR, "One or more fields are invalid. All fields must contain info, and Rating must have a numeric value between 0 and 10 inclusive. Only partial data has been accepted, and the book was not submitted.");
		}
	}
	
	private Book createBook() {
		Book newBook = new Book();
		newBook.setTitle(gui.getTitle().getText());
		newBook.setAuthor(gui.getAuthor().getText());
		newBook.setGenre(gui.getGenreList());
		newBook.setRating(gui.getRating().getNumber());
		return newBook;
	}
	
}
