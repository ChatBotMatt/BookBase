//TODO TextField.disable() when inSeries is false for SeriesNo and Series name
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
	private HBox top;

	private Text center;

	private ArrayList<InputGroup> groups;

	private InputGroup title;
	private InputGroup author;
	private InputGroup genre;
	private InputGroup rating;
	private InputGroup timesRead;
	private InputGroup pageCount;
	private InputGroup pubDate;

	private Button submit;
	private CheckBox masterCheck;
	
	public Form(Stage primaryStage) {
		stage = primaryStage;

		border = new BorderPane(center = new Text());
		border.setLeft(left = new VBox(5));
		border.setBottom(bottom = new HBox(5));
		border.setTop(top = new HBox());

	}

	public void start() {
		controller = new Controller(this);
		
		title = new InputGroup("Book Name");
		author = new InputGroup("Book Author");
		genre = new InputGroup("Book Genre", "?");
		genre.setButtonVisible(true);
		rating = new InputGroup(new ValidityTextField("", 0, 10), new Label("Book Rating"), new Button(), new CheckBox());
		timesRead = new InputGroup(new ValidityTextField("", 0, Float.MAX_VALUE), new Label("Times Read"), new Button(), new CheckBox());
		pageCount = new InputGroup(new ValidityTextField("", 0, Float.MAX_VALUE), new Label("Page Count"), new Button(), new CheckBox());
		pubDate = new InputGroup("Publication Date (DD/MM/YYYY)");
		
		submit = new Button("Submit Book");
		masterCheck = new CheckBox();
		masterCheck.setAllowIndeterminate(false);
		masterCheck.setPadding(new Insets(30,10,10,10)); //TODO Make HBox take that space itself, instead?
		
		Validator numericValidator = new Validator(){
			
			@Override
			public boolean validate(String data){
				return validateEmpty(data) && validateNumber(data);
			}
		};
		
		Validator dateValidator = new Validator(){
			
			@Override
			public boolean validate(String data){
				return validateEmpty(data) && validateDate(data);
			}
		};
		
		rating.setValidator(numericValidator);
		timesRead.setValidator(numericValidator);
		pageCount.setValidator(numericValidator);
		pubDate.setValidator(dateValidator);
		
		//test.getInput().setValidator(testVal);
		
		submit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				submit(); //TODO
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
		groups.add(timesRead);
		groups.add(pageCount);
		groups.add(pubDate);
		
		controller.setup();

		left.getChildren().addAll(groups);
		top.getChildren().add(masterCheck);

		bottom.getChildren().add(submit);

		Scene scene = new Scene(border, 300, 300);
		
		stage.setTitle("BookBase");
		stage.setScene(scene);
		stage.setMaxHeight(800);
		stage.setMaxWidth(1000);
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

	/**
	 * Updates the display information for the current book.
	 * @param genres The book's genres. //TODO Make it take a Book object and build from that instead.
	 */
	public void updateInfo(Book submitBook) {
		String title = submitBook.getTitle();
		String authorName = submitBook.getAuthor().getName();
		float rating = submitBook.getRating();
		int timesRead = submitBook.getTimesRead();
		int pageCount = submitBook.getPageCount();
		String pubDate = submitBook.getPubDateAsString();

		String updated = "The currently submitted book's info is: \n\nIt is named " + title + "\nIt was written by: " + authorName + "\n\nIn the following genres: \n";
		if (submitBook.getGenre().size() > 0){
			for (String genre: submitBook.getGenre()){
				genre.trim();
				updated += genre;
				updated += "\n";
			}
		}
		updated += "\nAnd is rated " + rating + " out of 10. \nIt has " + pageCount + " pages.\n\nYou have read it " + timesRead + " times.\nIt was published at " + pubDate + ".\n";
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

	public InputGroup getTimesRead() {
		return timesRead;
	}

	public void setTimesRead(InputGroup timesRead) {
		this.timesRead = timesRead;
	}

	public InputGroup getPageCount() {
		return pageCount;
	}

	public void setPageCount(InputGroup pageCount) {
		this.pageCount = pageCount;
	}

	public InputGroup getPubDate() {
		return pubDate;
	}

	public void setPubDate(InputGroup pubDate) {
		this.pubDate = pubDate;
	}

	public HBox getTop() {
		return top;
	}

	public void setTop(HBox top) {
		this.top = top;
	}

	public CheckBox getMasterCheck() {
		return masterCheck;
	}

	public void setMasterCheck(CheckBox masterCheck) {
		this.masterCheck = masterCheck;
	}

	public Button getSubmit() {
		return submit;
	}

	public void setSubmit(Button submit) {
		this.submit = submit;
	}

}
