import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 */

/**
 * @author Mariah
 *
 */

public class CountriesTextFile {

	private static Path filePath = Paths.get("src/countries.txt");

	// displays list of file
	public static List<Country> readFile(Path filePath) {
		List<Country> countries = new ArrayList<>();
		// ** Example of reading a file into a list
		try {
			// reads each line back as a a single string
			List<String> lines = Files.readAllLines(filePath);
			// convert the list of strings back to a string and an int
			for (String line : lines) {
				Country country = convertLineToItem(line);
				countries.add(country);
			}
			return countries;
		} catch (NoSuchFileException ex) {
			return new ArrayList<>();
		} catch (IOException ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}

//	public static void removeLineInFile(Path filePath, String userRemove) throws IOException {
//		// reads each line as single string and adds to the list
//		List<String> items = Files.readAllLines(filePath);
//		List<String> newItems = new ArrayList<>();
//
//		boolean matches = false;
//		
//
//		// delete all the old files to recreate list without the deletion
//		Files.write(filePath, items, StandardOpenOption.TRUNCATE_EXISTING);
//
//		// filters out the country name and adds in all other countries
//		for (String item : items) {
//			// allows user to remove not matter the case
//			matches = item.equalsIgnoreCase(userRemove);
//			// adds filtered out countries into a new blank list
//			if (!matches) {
//				newItems.add(item);
//			}
//		}
//
//		for (String item : newItems) {
//			// adds all new items into the old file
//			appendToFile(item, filePath);
//		}
//
//	}

	// Modify this method as necessary to convert a line of text from the file to a
	// new item instance
	public static Country convertLineToItem(String line) {
		String[] parts = line.split(", ");
		String countryName = parts[0];
		int population = Integer.parseInt(parts[1]);
		Country country = new Country(countryName, population);
		return country;
	}

	// makes changes to the list (adds)
	public static void appendToFile(String item, Path filePath) throws IOException {
		if (Files.notExists(filePath)) {
			Files.createFile(filePath);
		}

		// Create a list with the user's food in it
		List<String> linesToAdd = Arrays.asList(item);
		// Write those lines to the end of the file
		Files.write(filePath, linesToAdd, StandardOpenOption.APPEND);
	}

}
