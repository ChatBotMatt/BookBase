import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;

/**
 * A group of Nodes that every submission "unit" needs: Describing label, Input field, optional Submit Button.
 * @author Matthew
 *
 */
public class InputGroup extends TilePane {

	private Label descriptor;
	private Button submit;
	private TextField input;
	
	public InputGroup(TextField input, Label label, Button submit) {
		this.input = input;
		this.descriptor = label;
		this.submit = submit;
		
		//setAlignment(Pos.CENTER);
		submit.setVisible(false);
		
		getChildren().add(label);
		getChildren().add(input);
		getChildren().add(submit);
		
		setPadding(new Insets(0,0,0,-30));
		setHgap(-20);
		
		//System.out.println();
	}
	
	public InputGroup(String inputText, String labelText, String buttonText){
		this(new TextField(inputText), new Label(labelText), new Button(buttonText));
	}
	
	public InputGroup(String labelText, String buttonText){
		this("",labelText,buttonText);
	}
	
	public InputGroup(String labelText) {
		this(labelText,"");
	}
	
	public InputGroup() {
		this("");
	}
	
	public boolean validate(boolean numeric){
		if (numeric){
			NumericTextField num = (NumericTextField) input;
			return num.validate();
		}
		else{
			if (input.getLength() > 0){
				return true;
			}
		}
		return false;
	}
	
	public boolean validate(){
		return validate(false);
	}
	
	public String getText(){
		return input.getText();
	}
	
	public float getNumber(){
		float num;
		if(input.getText().matches("^[0-9]*\\.?[0-9]*$")){
			num = Float.valueOf(input.getText());
			return num;
		}
		else{
			throw new NumberFormatException("Not a numeric field.");
		}
	}
	
	/*public void setDescriptorPadding(int top, int bot, int left, int right){
		descriptor.setPadding(new Insets(top,right,bot,left));
	}
	
	public void setDescriptorPadding(int pad){
		descriptor.setPadding(new Insets(pad));
	}
	
	public void setInputPadding(int top, int bot, int left, int right){
		input.setPadding(new Insets(top,right,bot,left));
	}
	
	public void setInputPadding(int pad){
		input.setPadding(new Insets(pad));
	}
	
	public void setSubmitPadding(int top, int bot, int left, int right){
		submit.setPadding(new Insets(top,right,bot,left));
	}
	
	public void setSubmitPadding(int pad){
		submit.setPadding(new Insets(pad));
	}*/
	
	public void setSubmitVisible(boolean visible){
		submit.setVisible(visible);
	}
	
	public void setInputVisible(boolean visible){
		input.setVisible(visible);
	}
	
	public void setDescriptorVisible(boolean visible){
		descriptor.setVisible(visible);
	}
	
	
	
	
	

	public Label getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(Label descriptor) {
		this.descriptor = descriptor;
	}

	public Button getSubmit() {
		return submit;
	}

	public void setSubmit(Button submit) {
		this.submit = submit;
	}

	public TextField getInput() {
		return input;
	}

	public void setInput(TextField input) {
		this.input = input;
	}

}
