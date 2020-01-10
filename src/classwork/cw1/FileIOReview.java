package classwork.cw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class FileIOReview {

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("src/text/Practice_File.txt");
		Scanner s = new Scanner(f);
		
		while (s.hasNextLine())
			System.out.println(s.nextLine());
		
		s.close();
	}
}
