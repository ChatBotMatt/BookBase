import javafx.scene.control.Label;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * A group of Nodes that every submission "unit" needs: Describing label, Input field, optional Submit Button.
 * @author Matthew
 *
 */
public class InputGroup extends GridPane {

	private CheckBox check;
	private Label descriptor;
	private Button button;
	private ValidityTextField input;

	private Effect validEffect;
	private Effect invalidEffect;

	public InputGroup(ValidityTextField input, Label label, Button button, CheckBox check) {
		this.input = input;
		this.descriptor = label;
		this.button = button;
		this.check = check;

		button.setVisible(false);
		check.setAllowIndeterminate(false);

		add(check, 0, 0);
		add(label, 1, 0);
		add(input, 2, 0);
		add(button, 3, 0);

		check.setPadding(new Insets(10, 10, 10, 10));
		setHgap(10);

		DropShadow validShadow = new DropShadow(5, 0, 0, Color.GREEN);
		this.validEffect = validShadow;

		DropShadow invalidShadow = new DropShadow(5, 0, 0, Color.RED);
		this.invalidEffect = invalidShadow;

	}

	public InputGroup(String inputText, String labelText, String buttonText, CheckBox check) {
		this(new ValidityTextField(inputText), new Label(labelText), new Button(buttonText), check);
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

	public void clear() {
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
		return Float.valueOf(getText());
	}

	public Date getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
		sdf.setLenient(false);

		try {
			return sdf.parse(getText());
		} catch (ParseException e) {
			return null;
		}
	}

	public void showValidity(boolean valid) {
		if (valid) {
			input.setEffect(validEffect);
		} else {
			input.setEffect(invalidEffect);
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

	public boolean isChecked() {
		return check.isSelected();
	}

	public void setButtonVisible(boolean visible) {
		button.setVisible(visible);
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

	public Button getButton() {
		return button;
	}

	public void setButton(Button submit) {
		this.button = submit;
	}

	public ValidityTextField getInput() {
		return input;
	}

	public void setInput(ValidityTextField input) {
		this.input = input;
	}

	public void setCheckAllowIndeterminate(boolean indeterminate) {
		check.setAllowIndeterminate(indeterminate);
	}

	public boolean getCheckAllowIndeterminate(boolean indeterminate) {
		return check.isAllowIndeterminate();
	}

	public void setValidEffect(Effect effect) {
		this.validEffect = effect;
	}

	public void setInvalidEffect(Effect effect) {
		this.invalidEffect = effect;
	}

	public void setValidator(Validator valid) {
		input.setValidator(valid);
	}

	public Validator setValidator() {
		return input.getValidator();
	}

}
