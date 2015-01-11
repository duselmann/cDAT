package gov.cida.cdat.exception.control;

import gov.cida.cdat.exception.CdatException;

/**
 * General Control base Exception
 * 
 * @author duselmann
 */
public class ControlException extends CdatException {

	private static final long serialVersionUID = 1L;

	public ControlException() {}
	public ControlException(String msg) {super(msg);}
	public ControlException(String msg, Throwable cause) {super(msg,cause);}
	
}
