package gov.cida.cdat.exception.transform;

/**
 * Thrown if the data cannot be parsed as expected.
 * Details to be specified in the message text.
 * 
 * @author duselmann
 */
public class ParseException extends TransformException {

	private static final long serialVersionUID = 1L;

	// Do not add other constructors. We want to ensure a message.
	public ParseException(String msg) {super(msg);}
	public ParseException(String msg, Throwable cause) {super(msg,cause);}
	
}
