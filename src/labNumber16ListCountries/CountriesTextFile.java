package labNumber16ListCountries;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CountriesTextFile {

	public static void readFromFile(String directoryFolder, String fileName) {
		Path filePath = Paths.get(directoryFolder, fileName);
		File file = filePath.toFile();

		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);

			String line = reader.readLine();

			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found! You need to create a file first before you can view it...");
		} catch (IOException e) {
			System.out.println("Contact customer service. We may have added file wrong...");
		}

	}

	public static void writeToFile(String directoryFolder, String fileName, Scanner sc) {
		Path filePath = Paths.get(directoryFolder, fileName);
		File file = filePath.toFile();
		String enteredCountry;

		enteredCountry = Validator.getString(sc, "What is the name of Country to be added?: ");

		try {
			// the true parameter for the for FileOutputStream() constructor
			// appends data to the end of the file
			//
			PrintWriter outW = new PrintWriter(new FileOutputStream(file, true));
			outW.println(enteredCountry);
			outW.close(); // need to close when you are done

		} catch (FileNotFoundException e) {
			System.out.println("The file was not found");
		}

	}

	public static void createFile(String directoryFolder, String fileName) {

		Path filePath = Paths.get(directoryFolder, fileName);
		System.out.println("One moment while I create the file to store your country...\n");
		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
				System.out.println("File was created successfully.");
			} catch (IOException e) {
				System.out.println("Something went wrong with the file creation.");
			}
		} else {
			System.out.println("File already exists!");
		}
	}

	public static void createDirectory(String directoryFolder) {

		Path folder = Paths.get(directoryFolder);
		System.out.println("One moment while I create the folder for your country file...\n");
		if (Files.notExists(folder)) {
			try {// this is an example of a checked expection
				Files.createDirectories(folder);
				System.out.println("Folder was created successfully!");
			} catch (IOException e) {
				System.out.println("Something went wrong with the folder creation.");
			}
		} else {
			System.out.println("Folder already exists!");
		}

	}
}