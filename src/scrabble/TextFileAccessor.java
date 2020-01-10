package scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class TextFileAccessor {

	protected Scanner scan;

	// Write the openFile method that returns nothing and accepts the file name as a
	// parameter and assigns the file to the Scanner object scan
	public void openFile(String fileName) throws FileNotFoundException {
		this.scan = new Scanner(new File("src/Scrabble/" + fileName));
	}

	// Write the processFile method which takes no parameters and hands each line to
	// the processLine method in a loop before closing the Scanner
	public void processFile() {
		while (scan.hasNextLine())
			processLine(scan.nextLine());
		
		scan.close();
	}

	protected abstract void processLine(String line);
	public abstract String getReportStr();
}


