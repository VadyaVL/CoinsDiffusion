/**
 * @author Vadym. Email: vadyavl@gmail.com
 * @since 1.0
 */
package ua.edu.kpi;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import ua.edu.kpi.logic.Europe;

/**
 * Class - the entry point into the program.
 * @author Vadym
 * @since 1.0
 */
public class Main {
	
	/**
	 * Method - the entry point into the program.
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<String> europeanStates = getEuropeanCountryFromFile("input.txt");
		int i = 1;

		for (String data : europeanStates) {
			Europe europe = new Europe(data);

			do {
				europe.nextDay();
			} while (!europe.isCompleted());

			System.out.println("Case number " + i + ":");
			europe.showResult();
			i = i + 1;
		}
	}
	
	/**
	 * Get List data foreach Europe case.
	 * @param fileName File with data about Europe cases.
	 * @return
	 */
	public static List<String> getEuropeanCountryFromFile(String fileName) {

		List<String> europeanStates = new ArrayList<>();
		File inputFile = new File(fileName);

		if (inputFile.exists()) {
			try {
				List<String> lines = Files.readAllLines(inputFile.toPath());
				String currentState = "";

				for (String currentLine : lines) {
					if (currentLine.chars().allMatch(Character::isDigit)) {
						if (currentState != "") {
							europeanStates.add(currentState);
						}

						currentState = currentLine;
					} 
					else {
						currentState += "\n" + currentLine;
					}
				}
			} 
			catch (Exception exception) {
				System.err.println(exception.getMessage());
			}
		} 
		else {
			System.err.println(fileName + " does not exist!");
		}

		return europeanStates;
	}

}
