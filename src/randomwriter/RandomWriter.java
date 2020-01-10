package randomwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RandomWriter {

    public static void main(String[] args) throws FileNotFoundException {
        // Prompt user for input file, output file, analysis level, and length of output
        Scanner s = new Scanner(System.in);
        System.out.print("Input Source File: ");
        File inputFile = new File("src\\randomwriter\\" + s.nextLine());
        System.out.print("Output File: ");
        File outputFile = new File("src\\randomwriter\\" + s.nextLine());
        System.out.print("Analysis Level: ");
        int k = s.nextInt();
        System.out.print("# Characters to Write: ");
        int length = s.nextInt();
        s.close();

        // Initialize input, output, and seed
        String input = readTextFile(inputFile);
        StringBuilder output = new StringBuilder(input.substring(0, k));
        StringBuilder seed = new StringBuilder(input.substring(0, k));

        // Loop to determine and write the next character seed (previous k characters)
        for (int i = k; i < length; i++) {
            List<Character> chars = analyzeText(input, seed, k, length);
            System.out.println(seed + ": " + chars);
            if (chars.size() != 0)
                output.append(chooseCharacter(chars));
            seed.deleteCharAt(0);
            seed.append(input.charAt(i));
        }

        // Print the output
        System.out.println(output);
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
        for (int i = 0; i < length - k; i++) {
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
