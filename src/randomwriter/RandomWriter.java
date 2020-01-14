package randomwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RandomWriter {

    public static void main(String[] args) throws IOException {
        // Prompt for input file
        Scanner s = new Scanner(System.in);
        System.out.print("Input Source File: ");
        File inputFile = promptFile();
        String input = readTextFile(inputFile);
        // Prompt for output file
        System.out.print("Output File: ");
        File outputFile = promptFile();
        FileWriter outputFW = new FileWriter(outputFile);
        // Prompt for analysis level
        System.out.print("Analysis Level: ");
        int k = s.nextInt();
        while (k < 0 || k > input.length()) {
            System.out.print("Invalid input. Try again: ");
            k = s.nextInt();
        }
        // Prompt for # of characters to write
        System.out.print("# Characters to Write: ");
        int length = s.nextInt();
        while (length < 0) {
            System.out.print("Invalid input. Try again: ");
            length = s.nextInt();
        }
        s.close();

        // Initialize output and seed
        StringBuilder output = new StringBuilder();
        StringBuilder seed = new StringBuilder(input.substring(0, k));

        // Loop to determine and write the next character seed (previous k characters)
        for (int i = k; i < length; i++) {
            List<Character> chars = analyzeText(input, seed, k, length);
            if (chars.size() != 0)
                outputFW.write(chooseCharacter(chars));
            seed.deleteCharAt(0);
            seed.append(input.charAt(i));
        }

        outputFW.close();

        // Finished message
        System.out.println("\n**** Successfully Executed! See output at " + outputFile.getName() + ". ****");
    }

    public static File promptFile() {
        Scanner s = new Scanner(System.in);
        File file = new File("src\\randomwriter\\" + s.nextLine());

        while (!file.exists()) {
            System.out.print("File does not exist. Try again: ");
            file = new File("src\\randomwriter\\" + s.nextLine());
        }

        return file;
    }

    // Returns the text, expressed as a string, from the .txt file
    public static String readTextFile(File inputFile) throws FileNotFoundException {
        Scanner s = new Scanner(inputFile);
        StringBuilder input = new StringBuilder();

        while (s.hasNextLine())
            input.append(s.nextLine());

        return input.toString();
    }

    // Returns a list of possible characters to append based on a seed
    public static List<Character> analyzeText(String text, StringBuilder seed, int k, int length) {
        List<Character> chars = new ArrayList<Character>();
        for (int i = 0; i < length; i++) {
            if (text.substring(i, i + k).equals(seed.toString()))
                chars.add(text.charAt(i + seed.length()));
        }

        return chars;
    }

    // Returns random character from list of possible characters
    public static char chooseCharacter(List<Character> chars) {
        return chars.get((int) (chars.size()*Math.random()));
    }
}
