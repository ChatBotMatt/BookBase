import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;

/**
 * A group of Nodes that every submission "unit" needs: Describing label, Input field, optional Submit Button.
 * @author Matthew
 *
 */
public class InputGroup extends GridPane {

	private CheckBox check;
	private Label descriptor;
	private Button submit;
	private ValidityTextField input;

	public InputGroup(ValidityTextField input, Label label, Button submit, CheckBox check) {
		this.input = input;
		this.descriptor = label;
		this.submit = submit;
		this.check = check;
		
		submit.setVisible(false);
		check.setAllowIndeterminate(false);

		add(check,0,0);
		add(label,1,0);
		add(input,2,0);
		add(submit,3,0);
		
		/*double width = check.getLayoutBounds().getWidth();
		getColumnConstraints().add(new ColumnConstraints(width));
		getColumnConstraints().add(new ColumnConstraints(label.getLayoutBounds().getWidth()));
		getColumnConstraints().add(new ColumnConstraints(input.getLayoutBounds().getWidth()));
		getColumnConstraints().add(new ColumnConstraints(submit.getLayoutBounds().getWidth()));*/

		//setPadding(new Insets(0, 0, 0, -30));
		check.setPadding(new Insets(10,10,10,10));
		setHgap(10);
		//setGridLinesVisible(true);
		
	}
	
	public InputGroup(String inputText, String labelText, String buttonText, CheckBox check){
		this(new ValidityTextField(inputText), new Label(labelText), new Button(buttonText),check);
	}

	public InputGroup(String inputText, String labelText, String buttonText) {
		this(inputText, labelText, buttonText, new CheckBox());
	}

	public InputGroup(String labelText, String buttonText) {
		this("", labelText, buttonText);
	}

	public InputGroup(String labelText) {
		this(labelText, "");
	}

	public InputGroup() {
		this("");
	}
	
	public void clear(){
		input.clear();
	}

	/*public boolean validate(boolean numeric) { //TODO Delete/move to MVC
		if (numeric) {
			NumericTextField num = (NumericTextField) input;
			return num.validate();
		} else {
			if (input.getLength() > 0) {
				return true;
			}
		}
		return false;
	}*/

	public boolean validate() {
		return input.validate();
	}

	public String getText() {
		return input.getText();
	}

	public float getNumber() {
		float num;
		if (input.getText().matches("^[0-9]*\\.?[0-9]*$")) {
			num = Float.valueOf(input.getText());
			return num;
		} else {
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
	
	public boolean isChecked(){
		return check.isSelected();
	}

	public void setSubmitVisible(boolean visible) {
		submit.setVisible(visible);
	}

	public void setInputVisible(boolean visible) {
		input.setVisible(visible);
	}

	public void setDescriptorVisible(boolean visible) {
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

	public void setInput(ValidityTextField input) {
		this.input = input;
	}
	
	public void setCheckAllowIndeterminate(boolean indeterminate){
		check.setAllowIndeterminate(indeterminate);
	}
	
	public boolean getCheckAllowIndeterminate(boolean indeterminate){
		return check.isAllowIndeterminate();
	}

}
