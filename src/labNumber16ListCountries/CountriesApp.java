package labNumber16ListCountries;

import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		String enter;
		int optionSelect = 0;
		String directoryFolder = "List";
		String fileName = "countries.txt";

		System.out.println(
				"Welcome to the Countries Maintenance Application. Choose an option by entering the number associated with it.");
		
		
		while (optionSelect != 3) {
			System.out.println("1. Add a country\n2. See current list of countries\n3. Exit the app\n");
			optionSelect = Validator.getInt(key, "Enter the option number: ", 1, 3);
			switch (optionSelect) {
			case 1:
				do {
					
					CountriesTextFile.createDirectory(directoryFolder);
					
					CountriesTextFile.createFile(directoryFolder, fileName);

					CountriesTextFile.writeToFile(directoryFolder, fileName, key);

					enter = Validator.getContinue(key,
							"Would you like to enter another country? (Enter either Yes/No): ");
				} while (enter.equalsIgnoreCase("Yes"));
				break;
			case 2:
				do {
					CountriesTextFile.readFromFile(directoryFolder, fileName);

					enter = Validator.getContinue(key,
							"Would you like to view the country list again? (Enter either Yes/No): ");
				} while (enter.equalsIgnoreCase("Yes"));
				break;
			case 3:
				break;
			}
		}
		System.out.println("Thank you for using the Countries Maintenance App. Goodbye!");
	}

}
