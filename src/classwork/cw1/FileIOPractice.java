package classwork.cw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileIOPractice {

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("src/text/Coin_Flips.txt");
		Scanner s = new Scanner(f);
		
		// evenNumbers(s);
		// printDuplicates(s);
		coinFlip(s);
	}
	
	private static void evenNumbers(Scanner s) {
		int cnt = 0;
		int evenCnt = 0;
		int sum = 0;
		
		while (s.hasNextInt()) {
			int num = s.nextInt();
			sum += num;
			cnt++;
			evenCnt += (num % 2 == 0) ? 1 : 0;
		}
		
		System.out.printf("# of Integers: %d\n", cnt);
		System.out.printf("Sum: %d\n", sum);
		System.out.printf("# of Evens: %d\n", evenCnt);
		System.out.printf("%% Evens: %.2f%%\n", (double) evenCnt/cnt * 100);
	}
	
	private static void printDuplicates(Scanner s) {
		String[] line;
		int cnt;
		
		while (s.hasNextLine()) {
			line = s.nextLine().split(" ");
			cnt = 1;
			
			for (int i = 0; i < line.length; i++) {
				if (i != line.length - 1 && line[i].equals(line[i + 1]))
					cnt++;
				else if (cnt != 1) {
					System.out.print(line[i] + "*" + cnt + " ");
					cnt = 1;
				}
			}
			
			System.out.println();
		}
	}
	
	private static void coinFlip(Scanner s) {
		while (s.hasNextLine()) {
			char[] flips = s.nextLine().replaceAll("[^htHT]", "").toLowerCase().toCharArray();
			int cnt = 0;
			
			for (char c : flips) {
				if (c == 'h')
					cnt++;
			}
			
			double headRate = (double) cnt / flips.length;
			System.out.printf("%d heads (%.1f%%)\n", cnt, 100*headRate);
			
			if (headRate > 0.5)
				System.out.println("You win!");
		}
	}
}