package eval.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UIUtils {

	public static final UIUtils INSTANCE = new UIUtils();
	public static final String PROPERTY_RESOURCE_BUNDLE = "resources.globalMessages";

	private final Log log;
	private final BufferedReader reader;
	private final TextManager textManager;

	private UIUtils() {
		this.log = LogFactory.getLog(getClass());
		this.reader = new BufferedReader(new InputStreamReader(System.in));
		this.textManager = new TextManager(PROPERTY_RESOURCE_BUNDLE);
	}

	/**
	 * @return the textManager
	 */
	public TextManager getTextManager() {
		return textManager;
	}

	public void handleUnexceptedError(Exception e) {
		System.out.println(textManager.getText("exception.unexpected"));
		log.error(e);
		e.printStackTrace();
		System.exit(-1);
	}

	public String propertyToString(String field, Date value) {
		return propertyToString(field, sdf.format(value));
	}

	public String propertyToString(String field, double value) {
		return propertyToString(field, new Double(value).toString());
	}

	public String propertyToString(String field, int value) {
		return propertyToString(field, new Integer(value).toString());
	}

	public String propertyToString(String field, long value) {
		return propertyToString(field, new Long(value).toString());
	}

	public String propertyToString(String field, String value) {
		StringBuffer sb = new StringBuffer();
		sb.append(textManager.getText(field)).append(": ").append(value);
		return sb.toString();
	}

	public Double readDouble(String field) {
		Double value = null;
		while (value == null) {
			try {
				System.out.print(textManager.getText(field) + ": ");
				value = new Double(reader.readLine());
			} catch (NumberFormatException nfe) {
				System.out.println(textManager
						.getText("exception.double.format"));
				log.warn(nfe);
			} catch (Exception e) {
				handleUnexceptedError(e);
			}
		}
		return value;
	}

	public Integer readInteger(String field) {
		Integer value = null;
		while (value == null) {
			try {
				if (field != null)
					System.out.print(textManager.getText(field) + ": ");
				value = new Integer(reader.readLine());
			} catch (NumberFormatException nfe) {
				System.out.println(textManager
						.getText("exception.integer.format"));
				log.warn(nfe);
			} catch (Exception e) {
				handleUnexceptedError(e);
			}
		}
		return value;
	}

	public Integer readInteger(String field, int min, int max) {
		Integer value = null;
		while (value == null) {
			value = readInteger(field);
			if (value < min || value > max) {
				value = null;
				System.out.println(textManager.getText(
						"exception.integer.range", new String[] { "" + min,
								"" + max }, false));
			}
		}
		return value;
	}

	public Long readLong(String field) {
		Long value = null;
		while (value == null) {
			try {
				System.out.print(textManager.getText(field) + ": ");
				value = new Long(reader.readLine());
			} catch (NumberFormatException nfe) {
				System.out
						.println(textManager.getText("exception.long.format"));
				log.warn(nfe);
			} catch (Exception e) {
				handleUnexceptedError(e);
			}
		}
		return value;
	}

	public String readString(String field) {
		String value = null;
		while (value == null) {
			try {
				if (field != null)
					System.out.print(textManager.getText(field) + ": ");
				value = reader.readLine();
			} catch (Exception e) {
				handleUnexceptedError(e);
			}
		}
		return value;
	}

}
