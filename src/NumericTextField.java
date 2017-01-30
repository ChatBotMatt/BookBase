import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class NumericTextField extends TextField {
	
	int min = 0;
	int max = 100;
	
	public NumericTextField(String text, int min, int max){
		this.min = min;
		this.max = max;
		this.setText(text);
		
		textProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.isEmpty()){
				new Alert(AlertType.ERROR,"Please enter a value.");
			}
			else if (!newValue.matches("^[0-9]*\\.?[0-9]*$")){
		    	new Alert(AlertType.ERROR,"Only numeric values are allowed.");
		    }
		});
	}
	
	public NumericTextField(int min, int max){
		this("",min,max);
	}
	
	public boolean validate() {
		if (!getText().isEmpty()) {
			try {
				double number = Double.valueOf(getText());
				if (min <= number && number <= max) {
					return true;
				}
			} catch (NumberFormatException e) {
				return false;
			}
		} else {
			return false;
		}
		return false;
	}
	
	public float getNumber(){
		float number;
		try{
			number = Float.valueOf(getText());
		}
		catch (NumberFormatException e){
			number = min;
		}
		return number;
	}
}
