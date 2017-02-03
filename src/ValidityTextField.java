import javafx.scene.control.TextField;

public class ValidityTextField extends TextField {

	private boolean optional; //If the contents are not required, then verification will skip the isEmpty() check.
	private boolean numeric;
	private float min;
	private float max;
	
	private Validator validator;

	public ValidityTextField(String text, boolean numeric, float min, float max) {
		setText(text);
		this.numeric = numeric;
		this.min = min;
		this.max = max;
		
		if (!optional){
			validator = new Validator(){
				
				@Override
				public boolean validate(String data){
					return validateEmpty(data);
				}
			};
		}
		else{
			validator = new Validator();
		}

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
		if(numeric){
			if(validator.validate(getText())){
				float value = Float.valueOf(getText());
				return (min <= value && value <= max);
			}
			else{
				return false;
			}
		}
		else{
			return validator.validate(getText());
		}
	}
	
	public boolean validate(){
		return validate(false);
	}

	public void setValidator(Validator validator){
		this.validator = validator;
	}
	
	public Validator getValidator(){
		return validator;
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
