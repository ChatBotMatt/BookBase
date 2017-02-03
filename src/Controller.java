import java.util.ArrayList;

import javafx.scene.control.Alert;
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
		boolean valid = true;
		for (InputGroup group : groups) {
			if (!group.validate()) {
				valid = false;
				group.showValidity(false);
			}
			else{
				group.showValidity(true);
			}
		}
		return valid;
	}
	
	public Alert submit() {
		Alert status;
		if (validateFields(gui.getGroups())) {
			String[] genres = gui.getGenre().getText().split(", ");						
			Book newBook = createBook(genres);
			gui.updateInfo(newBook);
			gui.clearFields();
			//System.out.println(newBook.toString());
			status = new Alert(AlertType.INFORMATION, "The book has been submitted!");
			status.setHeaderText("Successful Submission");
		} else {
			status = new Alert(AlertType.ERROR, "One or more fields are invalid. All fields must contain info, and Rating must have a numeric value between 0 and 10 inclusive. Only partial data has been accepted, and the book was not submitted.");
			status.setHeaderText("Invalid Submission");
		}
		status.setTitle("Submission");
		return status;
	}
	
	private Book createBook(String[] genres) {
		Book newBook = new Book();
		
		newBook.setTitle(gui.getTitle().getText());
		newBook.setAuthor(gui.getAuthor().getText());
		newBook.setGenre(genres);
		newBook.setRating(gui.getRating().getNumber());
		newBook.setTimesRead((int) gui.getTimesRead().getNumber());
		newBook.setPageCount((int) gui.getPageCount().getNumber());
		newBook.setPubDate(gui.getPubDate().getDate());
		
		return newBook;
	}
	
}
