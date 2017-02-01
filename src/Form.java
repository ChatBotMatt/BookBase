//TODO TextField.disable() when inSeries is false for SeriesNo and Series name
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Form {
	
	private Controller controller;

	private Stage stage;
	private BorderPane border;
	private HBox bottom;
	private VBox left;

	private Text center;

	private ArrayList<InputGroup> groups;

	private InputGroup title;
	private InputGroup author;
	private InputGroup genre;
	private InputGroup rating;

	private Button submit;

	private ArrayList<String> genreList;

	public Form(Stage primaryStage) {
		stage = primaryStage;

		border = new BorderPane(center = new Text());
		border.setLeft(left = new VBox(5));
		border.setBottom(bottom = new HBox(5));

		genreList = new ArrayList<String>();
	}

	public void start() {
		controller = new Controller(this);
		
		title = new InputGroup("Book Name");
		author = new InputGroup("Book Author");
		genre = new InputGroup("Book Genre", "Submit");
		genre.setSubmitVisible(true);
		rating = new InputGroup(new ValidityTextField("", 0, 10), new Label("Book Rating"), new Button(), new CheckBox());
		submit = new Button("Submit Book");

		//blank = new TextField();
		//blank.setVisible(false);

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
					if (!genreList.contains(genre.getText())) {
						genreList.add(genre.getText());
						//new Alert(AlertType.INFORMATION, "The genre has been submitted!").show();
					}
				} else {
					//new Alert(AlertType.ERROR, "You can't submit a blank genre!").show();

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
		
		controller.setup();

		left.getChildren().addAll(groups);

		bottom.getChildren().add(submit);

		Scene scene = new Scene(border, 300, 300);

		stage.setTitle("BookBase");
		stage.setScene(scene);
		stage.show();

	}

	private void submit() {
		controller.submit().show(); //Display the appropriate status after submission.
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

	public void updateInfo() {
		String title = this.title.getText();
		String authorName = author.getText();
		float rating = this.rating.getNumber();

		String updated = "The currently submitted book's info is: \n\n" + title + "\nWritten by: " + authorName + "\n\nIn the following genres: \n";
		for (String genre : genreList) {
			updated += genre;
			updated += "\n";
		}
		updated += "\nAnd is rated " + rating + " out of 10.";
		center.setText(updated);
	}
	
	public void clearFields(){
		for (InputGroup group: groups){
			if (!group.isChecked()){
				group.clear();
			}
		}
	}

	public Controller getControl() {
		return controller;
	}

	public void setControl(Controller control) {
		this.controller = control;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public BorderPane getBorder() {
		return border;
	}

	public void setBorder(BorderPane border) {
		this.border = border;
	}

	public HBox getBottom() {
		return bottom;
	}

	public void setBottom(HBox bottom) {
		this.bottom = bottom;
	}

	public VBox getLeft() {
		return left;
	}

	public void setLeft(VBox left) {
		this.left = left;
	}

	public Text getCenter() {
		return center;
	}

	public void setCenter(Text center) {
		this.center = center;
	}

	public ArrayList<InputGroup> getGroups() {
		return groups;
	}

	public void setGroups(ArrayList<InputGroup> groups) {
		this.groups = groups;
	}

	public InputGroup getTitle() {
		return title;
	}

	public void setTitle(InputGroup title) {
		this.title = title;
	}

	public InputGroup getAuthor() {
		return author;
	}

	public void setAuthor(InputGroup author) {
		this.author = author;
	}

	public InputGroup getGenre() {
		return genre;
	}

	public void setGenre(InputGroup genre) {
		this.genre = genre;
	}

	public InputGroup getRating() {
		return rating;
	}

	public void setRating(InputGroup rating) {
		this.rating = rating;
	}

	public Button getSubmit() {
		return submit;
	}

	public void setSubmit(Button submit) {
		this.submit = submit;
	}

	public ArrayList<String> getGenreList() {
		return genreList;
	}

	public void setGenreList(ArrayList<String> genreList) {
		this.genreList = genreList;
	}

}
