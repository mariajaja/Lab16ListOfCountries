import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 
 */

/**
 * @author Mariah
 *
 */
public class CountriesApp {

	/**
	 * @param args
	 */
	private static Path filePath = Paths.get("src/countries.txt");
	private static Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		boolean isValid = false;
		System.out.println("Welcome to the Countries Maintenance Application!\n");

		do {
			// menu with the options of what user can do with the list of countries
			System.out.println("  1. See the list of countries");
			System.out.println("  2. Add a country");
//			System.out.println("  3. Remove a country");
			System.out.println("  3. See countries in alphabetical order.");
			System.out.println("  4. Exit");

			int menuChoice;

			do {
				menuChoice = Validator.verifyInt(userInput, "\nEnter menu number: ");
				if (menuChoice > 5 && menuChoice <= 0) {
					System.out.println("Not a valid menu choice. Try again.");
				}
			} while (menuChoice > 5 && menuChoice <= 0);

			switch (menuChoice) {
			case 1:
				userInput.nextLine();
				List<Country> countries = CountriesTextFile.readFile(filePath);
				// show user a list of countries
				for (Country country : countries) {
					System.out.println(country);
				}
				isValid = false;
				break;
			case 2:
				userInput.nextLine();
				userAddCountry();
				isValid = false;
				break;
//			case 3:
//				userInput.nextLine();
//				userRemoveCountry();
//				isValid = false;
//				break;
			case 3:
				userInput.nextLine();
				countriesInAlphabeticalOrder();
				break;
			case 4:
				// allow user to exit
				isValid = true;
				System.out.println("Buh-bye!");
				break;
			}

			System.out.print("What would you like to do next? \n");
			System.out.println();

		} while (!isValid);

	}

	// method to ask user to add a country
	public static void userAddCountry() throws IOException {
		String userChoice;

		do {
			System.out.print("What's the name of the country you'd like to add? ");
			String userCountry = userInput.nextLine();

			int countryPopulation = Validator.verifyInt(userInput, "What's the population of the country? ");

			// convert int into string for storage
			String item = userCountry + ", " + countryPopulation;
			userInput.nextLine();

			CountriesTextFile.appendToFile(item, filePath);

			// see if user wants to add another country
			System.out.println(
					"Would you like to add another country? \n(press y to continue and any other key to go back to menu): ");
			userChoice = userInput.nextLine();

		} while (userChoice.toLowerCase().startsWith("y"));
	}

//	// method to allow user to remove a country
//	public static void userRemoveCountry() throws IOException {
//		String userChoice;
//
//		do {
//			System.out.print("Please type the name of the country you'd like to remove: ");
//			userChoice = userInput.nextLine();
//
//			// runs method to remove selected object
//			CountriesTextFile.removeLineInFile(filePath, userChoice);
//
//			// see if user wants to remove another
//			System.out.println(
//					"Would you like to remove another country? \n(press y to continue and any other key to go back to menu): ");
//			userChoice = userInput.nextLine();
//
//		} while (userChoice.toLowerCase().startsWith("y"));
//
//	}

	public static void countriesInAlphabeticalOrder() throws IOException {
		List<Country> countries = CountriesTextFile.readFile(filePath);
		TreeMap<String, Integer> countryInOrder = new TreeMap<>();

		for (Country country : countries) {
			String countryName = country.getCountryName();
			int countryPopulation = country.getPopulation();
			countryInOrder.put(countryName, countryPopulation);
		}

		System.out.println(countryInOrder);
	}

}
