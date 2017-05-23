package ua.edu.kpi;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import ua.edu.kpi.logic.Europe;

public class Main {

	public static void main(String[] args) {

		int i = 1;
		List<String> europeanStates = getEuopeanCountryFromFile("input.txt");

		for (String data : europeanStates) {
			System.out.println("Case number " + i++ + ":");

			Europe europe = new Europe(data);

			do {
				europe.nextDay();
			} while (!europe.isCompleted());

			europe.showResult();
		}

	}

	public static List<String> getEuopeanCountryFromFile(String fileName) {

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
