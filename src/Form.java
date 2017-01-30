
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Form {

	private Stage stage;
	private BorderPane border;
	private HBox bottom;
	private VBox left;
	
	//private GridPane grid;
	private Text center;
	
	private ArrayList<InputGroup> groups;

	private InputGroup title;
	private InputGroup author;
	private InputGroup genre;
	private InputGroup rating;
	
	private Button submit;
	
	//private TextField blank; //Used to create an empty row in the GridPane.
	private Label status;

	private ArrayList<String> genreList;
	private Button submitGenre;
	private Label submittedGenres;

	public Form(Stage primaryStage) {
		stage = primaryStage;

		border = new BorderPane(center = new Text());
		border.setLeft(left = new VBox(5));
		border.setBottom(bottom = new HBox(5));
		
		genreList = new ArrayList<String>();
	}

	public void start() {
		title = new InputGroup("Book Name");
		author = new InputGroup("Book Author");
		genre = new InputGroup("Book Genre","Submit");
		genre.setSubmitVisible(true);
		rating = new InputGroup(new NumericTextField("",0,10), new Label("Book Rating"), new Button());
		submit = new Button("Submit Book");
		submitGenre = new Button("Submit Genre");
		
		//blank = new TextField();
		//blank.setVisible(false);
		status = new Label();
		submittedGenres = new Label();

		submit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				submit(); //TODO
			}

		});

		genre.getSubmit().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (genre.validate()) {
					if (!genreList.contains(genre.getText())){
						genreList.add(genre.getText());
						status.setText("Genre submitted!");
						submittedGenres.setText(submittedGenres.getText() + "\n" + genre.getText());
					}		
				} else {
					status.setText("Enter a genre first!");
				}
			}

		});

		//grid.getColumnConstraints().add(new ColumnConstraints(250)); //Makes it wide enough to fit the full text for genre/rating.
		//grid.setGridLinesVisible(true);
		//left.setVgap(10);
		
		groups = new ArrayList<InputGroup>(4);
		groups.add(title);
		groups.add(author);
		groups.add(genre);
		groups.add(rating);
		
		left.getChildren().addAll(groups);
		
		bottom.getChildren().add(submit);
		bottom.getChildren().add(submitGenre);

		center.setText("No book info is yet available. Submit some!");
		//updateInfo();
		
		//left.getChildren().add(submittedGenres);
		bottom.getChildren().add(status);

		Scene scene = new Scene(border, 300, 300);

		stage.setTitle("BookBase");
		stage.setScene(scene);
		stage.show();

	}

	private boolean validateFields() {
		boolean valid = false;
		for (InputGroup group: groups){
			if (!group.validate()){
				return false;
			}
		}
		return (rating.validate(true));
		//return (title.validate() && author.validate() && genre.validate() && rating.validate(true));
		//return (validate(title) && validate(author) && validate(genre) && rating.validate());
	}

	/*private boolean validateNumeric(TextField field, Label status, int min, int max) {
		if (validate(field)) {
			try {
				double number = Double.valueOf(field.getText());
				if (min <= number && number <= max) {
					return true;
				}
			} catch (NumberFormatException e) {
				status.setText("Please enter a numeric value.");
				return false;
			}
		} else {
			return false;
		}
		return false;
	}*/

	/*private boolean validate(TextField field) {
		if (field.getLength() > 0) {
			return true;
		} else {
			return false;
		}
	}*/

	private boolean submit() {
		genre.getSubmit().fire();
		if (validateFields()) {
			status.setText("Input accepted!");
			updateInfo();
			Book newBook = createBook();
			System.out.println(newBook);
			return true;
		} else {
			status.setText("Input invalid!");
			return false;
		}

	}
	
	private Book createBook(){
		Book newBook = new Book();
		newBook.setTitle(title.getText());
		newBook.setAuthor(author.getText());
		newBook.setGenre(genreList);
		newBook.setRating(rating.getNumber());
		
		return newBook;
	}

	/**
	 * Produces blank labels to "fill" rows and allow spacing.
	 * @return blank A blank, invisible label.
	 */
	/*private Label createBlank() {
		Label blank = new Label();
		blank.setVisible(false);
		return blank;
	}*/
	
	private void updateInfo(){
		String title = this.title.getText();
		String authorName = author.getText();
		float rating = this.rating.getNumber();
		
		String updated = "The currently submitted book's info is: \n\n" + title + "\nWritten by: " + authorName + "\n\nIn the following genres: \n";
		for (String genre: genreList){
			updated += genre;
			updated += "\n";
		}
		updated+= "\nAnd is rated " + rating + " out of 10.";
		center.setText(updated);
	}

}
