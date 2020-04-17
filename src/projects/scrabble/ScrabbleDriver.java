package projects.scrabble;

import java.util.Scanner;
import java.io.IOException;

public class ScrabbleDriver {

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the file name: ");
		String fileName = s.nextLine();
		TextFileAccessor scrab = new MaxScrabbleScore();
		scrab.openFile(fileName);
		scrab.processFile();
		System.out.println(scrab.getReportStr());
		s.close();
	}
}