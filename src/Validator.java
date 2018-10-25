import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Mariah
 *
 */
public class Validator {

	public static int verifyInt(Scanner userInput, String prompt) {
		// verifies that user inserted a valid int for population
		System.out.print(prompt);
		try {
			int number = userInput.nextInt();
			return number;
		} catch (InputMismatchException ex) {
			System.out.println("Please only enter a whole number. Do not use commas, decimals or non-digits.");
			userInput.nextLine();
			// loops to ask question again
			return verifyInt(userInput, prompt);
		}
	}

}
