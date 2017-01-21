import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App {
	
	Document doc;
	Elements elements = new Elements();
	String testURL = "https://www.goodreads.com/book/show/13569581-blood-song?ac=1&from_search=true";
	
	public void runApp() throws IOException{
		Scraper scraper = new Scraper();
	
	}

	public static void main(String[] args) throws IOException {
		App app = new App();
		app.runApp();

	}

}
