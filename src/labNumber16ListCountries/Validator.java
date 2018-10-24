package labNumber16ListCountries;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validator {
	public static String getString(Scanner sc, String prompt) {
		System.out.print(prompt);
		String s = sc.nextLine(); // read user entry
		 // discard any other data entered on the line
		return s;
	}
	
	public static String getContinue(Scanner sc, String prompt) {
		String input = ("");
		boolean isValid = false;
		while (isValid == false) {
			input = getString(sc, prompt);
			if(input.equalsIgnoreCase("No")) {
				isValid = true;
				break;
			} else if (input.equalsIgnoreCase("Yes")) {
				isValid = true;
			} else {
				System.out.println("Error! Please enter either 'Yes' or 'No'.");
			}
		}
		return input;
			
	}
		

	public static int getInt(Scanner sc, String prompt) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid integer value. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return i;
	}

	public static int getInt(Scanner sc, String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			i = getInt(sc, prompt);
			if (i < min)
				System.out.println("Error! Number must be " + min + " or greater.");
			else if (i > max)
				System.out.println("Error! Number must be " + max + " or less.");
			else
				isValid = true;
		}
		return i;
	}

	public static double getDouble(Scanner sc, String prompt) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				d = sc.nextDouble();
				if (d >= 0 && d != -0) {
				isValid = true;
				} else {
					System.out.println("Number must be a positive value. Enter a positive number value.");
				}
			} else {
				System.out.println("Error! Invalid decimal value for circle. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return d;
	}

	public static double getDouble(Scanner sc, String prompt, double min, double max) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			d = getDouble(sc, prompt);
			if (d < min)
				System.out.println("Error! Number must be " + min + " or greater.");
			else if (d > max)
				System.out.println("Error! Number must be " + max + " or less.");
			else
				isValid = true;
		}
		return d;
	}

	public static String getRegex(Scanner sc, String regexPattern, String prompt) {
		String input = "";
		boolean isValid = false;
		while (isValid == false) {
			input = getString(sc, prompt);

			if (!input.matches(regexPattern)) {
				System.out.println(
						"You have entered a mismatched value. Please enter in a value that matches the pattern");
			} else {
				isValid = true;
			}

		}
		return input;

	}
	
	public static Date getDate(Scanner sc, String prompt) {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		format.setLenient(false); // <-- date format must match
		boolean isValid = false;
		Date date = null;
		String input;
		do {
			// Step 1: get the raw string
			input = getString(sc, prompt);
			// Step 2: convert it to a date
			try {
				// format.parse throws a ParseException, which is a checked exception and MUST
				// be caught.
				date = format.parse(input);
				// If exception doesn't occur, it's valid.
				isValid = true;
			} catch (ParseException ex) {
				// If exception occurs, it's invalid.
				isValid = false;
				System.out.println("Enter a valid date in format mm/dd/yyyy.");
			}

		} while (!isValid);
		return date;
		
	}
}