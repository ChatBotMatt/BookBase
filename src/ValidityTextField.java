import javafx.scene.control.TextField;

public class ValidityTextField extends TextField {

	private boolean numeric;
	private float min;
	private float max;

	public ValidityTextField(String text, boolean numeric, float min, float max) {
		setText(text);
		this.numeric = numeric;
		this.min = min;
		this.max = max;
	}
	
	public ValidityTextField(String text, float min, float max){
		this(text,true,min,max);
	}
	
	public ValidityTextField(String text){
		this(text,false,Float.MIN_VALUE,Float.MIN_VALUE);
	}
	
	public ValidityTextField(){
		this(""); //A non-numeric VTF has no need for min/max values.
	}
	
	/**
	 * Validates the contents of the field, optionally based on if the field contains anything, and if the value is within a range and numeric. 
	 * @param allowEmpty If the field is allowed to be empty.
	 * @return 
	 */
	public boolean validate(boolean allowEmpty){
		if (!allowEmpty){
			if (getText().isEmpty()){
				return false;
			}
		}
		if (numeric){
			try{
				Float.valueOf(getText()); //If the text is a valid float value.
				return true;
			}
			catch (NumberFormatException e){
				return false;
			}
		}
		return true;
	}
	
	public boolean validate(){
		return validate(false);
	}

	
	public boolean isNumeric() {
		return numeric;
	}

	public void setNumeric(boolean numeric) {
		this.numeric = numeric;
	}

	public float getMin() {
		return min;
	}

	public void setMin(float min) {
		this.min = min;
	}

	public float getMax() {
		return max;
	}

	public void setMax(float max) {
		this.max = max;
	}
}
