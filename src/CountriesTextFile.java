import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
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

	private static Path filePath = Paths.get("countries.txt");

	public static void main(String[] args) throws IOException {

		// create a directory, if not created already
		Path dirPath = Paths.get("countries");
		if (Files.notExists(dirPath)) {
			Files.createDirectories(dirPath);
		}

		// create file if it's not created already
		if (Files.notExists(filePath)) {
			Files.createFile(filePath);
		}
	}

	// displays list of file
	public static List<Country> readFile(Path filePath) {
		List<Country> countries = null;
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
		} catch (FileNotFoundException ex) {
			return new ArrayList<>();
		} catch (IOException ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}

	// Modify this method as necessary to convert a line of text from the file to a
	// new item instance
	public static Country convertLineToItem(String line) {
		String[] parts = line.split(", ");
		Country country = new Country();
		country.setCountryName(parts[0]);
		country.setPopulation(Integer.parseInt(parts[1]));
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
