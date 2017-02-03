import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Validator {

	private static Validator numeric;
	private static Validator empty;
	private static Validator date;

	private Validator val;

	public Validator(Validator val) {
		this.val = val;

	}

	public Validator() {
		this(null);
	}
	
	/**
	 * Should be overridden using anonymous classes.
	 * @return Always returns true (if not overridden).
	 */
	public boolean validate(String data){
		return true;
	}
	
	public boolean validateNumber(String data) {
		try {
			Float.valueOf(data); //If the text is a valid float value.
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public boolean validateEmpty(String data) {
		if (!data.isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean validateDate(String data) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
		sdf.setLenient(false);

		try {
			Date date = sdf.parse(data);
			System.out.println(date);
			return true;
		} catch (ParseException e) {
			System.err.println("Bad Date");
			return false;
		}
	}

	public static Validator getNumeric() {
		return numeric;
	}

	public static void setNumeric(Validator numeric) {
		Validator.numeric = numeric;
	}

	public static Validator getEmpty() {
		return empty;
	}

	public static void setEmpty(Validator empty) {
		Validator.empty = empty;
	}

	public static Validator getDate() {
		return date;
	}

	public static void setDate(Validator date) {
		Validator.date = date;
	}

	public Validator getVal() {
		return val;
	}

	public void setVal(Validator val) {
		this.val = val;
	}

}
