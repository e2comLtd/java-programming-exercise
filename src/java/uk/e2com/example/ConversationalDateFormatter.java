package uk.e2com.example;

import java.text.MessageFormat;
import java.util.ArrayList;

/**
 * Formats String as HH:MM in conversational format
 * 
 * @author Ivan Rigoni - e2com Limited
 * @version v0.1 (12/04/14)
 */
public class ConversationalDateFormatter {

	private static ArrayList<String> minuteToString = new ArrayList<String>();
	static {
		minuteToString.add(" o'clock");
		minuteToString.add("just after");
		minuteToString.add("two past");
		minuteToString.add("three past");
		minuteToString.add("four past");
		minuteToString.add("five past");
		minuteToString.add("six past");
		minuteToString.add("seven past");
		minuteToString.add("eight past");
		minuteToString.add("nine past");
		minuteToString.add("ten past");
		minuteToString.add("eleven past");
		minuteToString.add("twelve past");
		minuteToString.add("thirteen past");
		minuteToString.add("fourteen past");
		minuteToString.add("quarter past");
		minuteToString.add("sixteen past");
		minuteToString.add("seventeen past");
		minuteToString.add("eighteen past");
		minuteToString.add("nineteen past");
		minuteToString.add("twenty past");
		minuteToString.add("twentyone past");
		minuteToString.add("twentytwo past");
		minuteToString.add("twentythree past");
		minuteToString.add("twentyfour past");
		minuteToString.add("twentyfive past");
		minuteToString.add("twentysix past");
		minuteToString.add("twentyseven past");
		minuteToString.add("twentyeight past");
		minuteToString.add("twentynine past");
		minuteToString.add("half past");

		minuteToString.add("twentynine to");
		minuteToString.add("twentyeight to");
		minuteToString.add("twentyseven to");
		minuteToString.add("twentysix to");
		minuteToString.add("twentyfive to");
		minuteToString.add("twentyfour to");
		minuteToString.add("twentythree to");
		minuteToString.add("twentytwo to");
		minuteToString.add("twentyone to");
		minuteToString.add("twenty to");
		minuteToString.add("nineteen to");
		minuteToString.add("eighteen to");
		minuteToString.add("seventeen to");
		minuteToString.add("sixteen to");
		minuteToString.add("quarter to");
		minuteToString.add("fourteen to");
		minuteToString.add("thirteen to");
		minuteToString.add("twelve to");
		minuteToString.add("eleven to");
		minuteToString.add("ten to");
		minuteToString.add("nine to");
		minuteToString.add("eight to");
		minuteToString.add("seven to");
		minuteToString.add("six to");
		minuteToString.add("five to");
		minuteToString.add("four to");
		minuteToString.add("three to");
		minuteToString.add("two to");
		minuteToString.add("one to");

	}

	private static ArrayList<String> hourToString = new ArrayList<String>();
	static {
		hourToString.add(" midnight");
		hourToString.add(" one AM");
		hourToString.add(" two AM");
		hourToString.add(" three AM");
		hourToString.add(" four AM");
		hourToString.add(" five AM");
		hourToString.add(" six AM");
		hourToString.add(" seven AM");
		hourToString.add(" eight AM");
		hourToString.add(" nine AM");
		hourToString.add(" ten AM");
		hourToString.add(" eleven AM");
		hourToString.add(" midday");
		hourToString.add(" one PM");
		hourToString.add(" two PM");
		hourToString.add(" three PM");
		hourToString.add(" four PM");
		hourToString.add(" five PM");
		hourToString.add(" six PM");
		hourToString.add(" seven PM");
		hourToString.add(" eight PM");
		hourToString.add(" nine PM");
		hourToString.add(" ten PM");
		hourToString.add(" eleven PM");
	}

	/**
	 * Default Constructor
	 */
	public ConversationalDateFormatter() {
	}

	/**
	 * 
	 * @param hoursAndMinutes
	 * @return
	 */
	public String format(String hoursAndMinutes) {
		String[] figure = hoursAndMinutes.split(":");
		int hour = Integer.parseInt(figure[0]);
		int minute = Integer.parseInt(figure[1]);

		validateInput(hour, minute);

		StringBuffer result = new StringBuffer(50);
		int hourParam = hour;
		if (minute > 30) {
			hourParam = hour + 1;
		}
		if (hourParam == 24) {
			hourParam = 0;
		}

		if (hour == 0 && minute == 0) {
			result.append(hourToString.get(hourParam));
		} else {
			result.append(minuteToString.get(minute)).append(
					hourToString.get(hourParam));
		}
		return result.toString().trim();
	}

	private void validateInput(int hour, int minute) {
		String errorString = "";
		if (hour > 23 || hour < 0) {
			errorString += MessageFormat.format("invalid hour {0} ", hour);
		}
		if (minute < 0 || minute > 59) {
			errorString += MessageFormat.format("invalid minute {0} ", minute);
		}
		if (!errorString.isEmpty()) {
			throw new IllegalArgumentException(errorString);
		}
	}

	/**
	 * @param args
	 *            First argument has to be in format hh:mm
	 */
	public static void main(String[] args) {
		ConversationalDateFormatter cdf = new ConversationalDateFormatter();
		if (args.length > 0) {
			System.out.println(cdf.format(args[0]));
		} else {
			System.err.println("USAGE: \n java " + cdf.getClass().getName() + " hour:minute");

		}
	}

}
