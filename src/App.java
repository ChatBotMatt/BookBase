import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application{
	
	String testURL = "https://www.goodreads.com/book/show/13569581-blood-song?ac=1&from_search=true";
	Form form;
	
	private void runApp() throws IOException{
		Scraper scraper = new Scraper();
	}
	
    @Override
    public void start(Stage primaryStage) {
       form = new Form(primaryStage);
       form.start();
    }
    
 public static void main(String[] args) throws IOException {
        launch(args);
        //new App().runApp();
    }

}
