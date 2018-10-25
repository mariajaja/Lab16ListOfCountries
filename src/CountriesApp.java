import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

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

		// TODO possibly add removing country, sorting by population and sorting
		// alphabetically
		do {
			// menu with the options of what user can do with the list of countries
			System.out.println("  1. See the list of countries");
			System.out.println("  2. Add a country");
			System.out.println("  3. Remove a country");
			System.out.println("  4. Exit");

			System.out.print("\nEnter menu number: ");
			int menuChoice = userInput.nextInt();

			switch (menuChoice) {
			case 1:
				userInput.nextLine();
				List<Country> countries = CountriesTextFile.readFile(filePath);
				// TODO do a String.format to make pretty
				// show user a list of countries
				System.out.println(countries);
				isValid = false;
				break;
			case 2:
				userInput.nextLine();
				userAddCountry();
				isValid = false;
				break;
			case 3:
				userInput.nextLine();
				userRemoveCountry();
				isValid = false;
				break;
			case 4:
				// allow user to exit
				isValid = true;
				System.out.println("Buh-bye!");
				break;
			}

//			if (menuChoice == 1) {
//				List<Country> countries = CountriesTextFile.readFile(filePath);
//				// TODO do a String.format to make pretty
//				// show user a list of countries
//				System.out.println(countries);
//				isValid = false;
//			} else if (menuChoice == 2) {
//				userInput.nextLine();
//				userAddCountry();
//				isValid = false;
//			} else if (menuChoice == 3) {
//				userInput.nextLine();
//				userRemoveCountry();
//				isValid = false;
//			} else if (menuChoice == 4) {
//				// allow user to exit
//				isValid = true;
//			}
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

			// TODO add check for valid input (i.e. no commas, just ints, no space after)
			System.out.print("What's the population of the country? ");
			int countryPopulation = userInput.nextInt();

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

	// method to allow user to remove a country
	public static void userRemoveCountry() throws IOException {
		String userChoice;

		do {
			System.out.print("Please type the name of the country you'd like to remove: ");
			userChoice = userInput.nextLine();

			// runs method to remove selected object
			CountriesTextFile.removeLineInFile(filePath, userChoice);

			// see if user wants to remove another
			System.out.println(
					"Would you like to remove another country? \n(press y to continue and any other key to go back to menu): ");
			userChoice = userInput.nextLine();

		} while (userChoice.toLowerCase().startsWith("y"));

	}

}
