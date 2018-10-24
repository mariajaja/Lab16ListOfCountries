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

		System.out.println("Welcome to the Countries Maintenance Application!\n");

		// TODO possibly add removing country, sorting by population and ssorting
		// alphabetically
		// menu with the options of what user can do with the list of countries
		System.out.println("  1. See the list of countries");
		System.out.println("  2. Add a country");
		System.out.println("  3. Exit");

		System.out.print("\nEnter menu number: ");
		int menuChoice = userInput.nextInt();

		if (menuChoice == 1) {
			List<Country> countries = CountriesTextFile.readFile(filePath);
			// TODO do a String.format to make pretty
			// show user a list of countries
			System.out.println(countries);
		} else if (menuChoice == 2) {
			userInput.nextLine();
			userAddCountry();
		} else if (menuChoice == 3) {
			// allow user to exit
		}

		// show a menu w/ three options

		// TODO option 1: display list of countries saved in the file

		// TODO option 2: prompt the user to enter a country and then write the country
		// to the file of countries

		// TODO possible option 4: create an option that allows the user to delete a
		// country from the file

		// TODO option 3: display a goodbye message and exit
		System.out.println("Buh-bye!");

	}

	// TODO write method to ask user about what country and population they'd like
	// to add; convert the "country" into a single "item" to append (use loop for
	// multiple additions
	public static void userAddCountry() throws IOException {

		System.out.print("What's the name of the country you'd like to add? ");
		String userCountry = userInput.nextLine();

		// TODO add check for valid input (i.e. no commas, just ints)
		System.out.print("What's the population of the country? ");
		int countryPopulation = userInput.nextInt();

		// convert int into string for storage
		String item = userCountry + ", " + countryPopulation;

		CountriesTextFile.appendToFile(item, filePath);
	}

}
