package eval.business;

public class BusinessException extends Exception {

	private static final long serialVersionUID = -1839401313897766917L;
	private String[] args;

	/**
	 * <p>
	 * Create a new instance of BusinessException.
	 * </p>
	 */
	public BusinessException() {
		this.args = new String[0];
	}

	/**
	 * <p>
	 * Create a new instance of BusinessException.
	 * </p>
	 * 
	 * @param message
	 *            the message to show.
	 */
	public BusinessException(final String message) {
		super(message);
		this.args = new String[0];
	}

	/**
	 * <p>
	 * Create a new instance of BusinessException.
	 * </p>
	 * 
	 * @param message
	 *            the message to show.
	 * @param arg
	 *            the message argument.
	 */
	public BusinessException(final String message, final String arg) {
		super(message);
		this.args = new String[] { arg };
	}

	/**
	 * <p>
	 * Create a new instance of BusinessException.
	 * </p>
	 * 
	 * @param message
	 *            the message to show.
	 * @param arg
	 *            the message argument.
	 * @param cause
	 *            the exception that caused this exception.
	 */
	public BusinessException(final String message, final String arg,
			final Throwable cause) {
		super(message, cause);
		this.args = new String[] { arg };
	}

	/**
	 * <p>
	 * Create a new instance of BusinessException.
	 * </p>
	 * 
	 * @param message
	 *            the message to show.
	 * @param args
	 *            the message arguments.
	 */
	public BusinessException(final String message, final String[] args) {
		super(message);
		this.args = args;
	}

	/**
	 * <p>
	 * Create a new instance of BusinessException.
	 * </p>
	 * 
	 * @param message
	 *            the message to show.
	 * @param args
	 *            the message arguments.
	 * @param cause
	 *            the exception that caused this exception.
	 */
	public BusinessException(final String message, final String[] args,
			final Throwable cause) {
		super(message, cause);
		this.args = args;
	}

	/**
	 * <p>
	 * Create a new instance of BusinessException.
	 * </p>
	 * 
	 * @param message
	 *            the message to show.
	 * @param cause
	 *            the exception that caused this exception.
	 */
	public BusinessException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * <p>
	 * Create a new instance of BusinessException.
	 * </p>
	 * 
	 * @param cause
	 *            the exception that caused this exception.
	 */
	public BusinessException(final Throwable cause) {
		super(cause);
	}

	public String[] getArgs() {
		return args;
	}

}