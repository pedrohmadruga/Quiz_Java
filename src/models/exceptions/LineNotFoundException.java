package models.exceptions;

public class LineNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public LineNotFoundException(String msg) {
		super(msg);
	}
}