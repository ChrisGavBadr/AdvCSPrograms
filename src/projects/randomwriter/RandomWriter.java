package projects.randomwriter;

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
        System.out.println("---- Input File ----");
        String input = readTextFile(promptFile());
        // Prompt for output file
        System.out.println("---- Output File ----");
        File outputFile = promptFile();
        FileWriter outputFW = new FileWriter(outputFile);
        // Prompt for analysis level
        int k = promptAnalysisLevel(input);
        // Prompt for # of characters to write
        int length = promptOutputLength();

        // Initialize seed
        StringBuilder seed = generateSeed(input, k);

        // Loop to write 'length' random characters based on seed(s)
        for (int i = 0; i < length; i++) {
            List<Character> chars = analyzeText(input, seed, k);
            // Generate new seed and character list if there are no characters to choose from
            while (chars.size() == 0) {
                seed = generateSeed(input, k);
                chars = analyzeText(input, seed, k);
            }
            // Write random character to output file and update seed
            char ch = chooseCharacter(chars);
            outputFW.write(ch);
            seed.deleteCharAt(0);
            seed.append(ch);
        }

        outputFW.close();

        // Finished message
        System.out.println("\n**** Successfully Executed! See output at " + outputFile.getName() + ". ****");
    }

    // Generates random seed of length k from input text
    public static StringBuilder generateSeed(String input, int k) {
        int lowerSeedIdx = (int) ((input.length() - k)*Math.random());
        int upperSeedIdx = lowerSeedIdx + k;

        return new StringBuilder(input.substring(lowerSeedIdx, upperSeedIdx));
    }

    // Prompts for existing text file
    public static File promptFile() {
        Scanner s = new Scanner(System.in);
        File file;

         do {
             System.out.print("File Name: ");
             file = new File("src\\projects.randomwriter\\" + s.nextLine());
             if (!file.exists())
                 System.out.println("File does not exist.");
         } while (!file.exists());

        return file;
    }

    // Prompts for analysis level
    public static int promptAnalysisLevel(String input) {
        Scanner s = new Scanner(System.in);
        int k;

        do {
            System.out.print("Analysis Level: k = ");
            k = s.nextInt();
            if (k < 0)
                System.out.println("- \'k\' must be non-negative.");
            if (k >= input.length())
                System.out.println("- \'k\' must be lower than the size of the input text (" + input.length() + ").");
        } while (k < 0 || k >= input.length());

        return k;
    }

    // Prompts for output length
    public static int promptOutputLength() {
        Scanner s = new Scanner(System.in);
        int length;

        do {
            System.out.print("# Characters to Write: length = ");
            length = s.nextInt();
            if (length < 0)
                System.out.print("- \'length\' must be non-negative.");
        } while (length < 0);

        return length;
    }

    // Returns the text, expressed as a string, from the .txt file
    public static String readTextFile(File file) throws FileNotFoundException {
        Scanner s = new Scanner(file);
        StringBuilder text = new StringBuilder();

        while (s.hasNextLine())
            text.append("\n").append(s.nextLine());

        return text.toString();
    }

    // Returns a list of possible characters to append based on seed
    public static List<Character> analyzeText(String text, StringBuilder seed, int k) {
        List<Character> chars = new ArrayList<Character>();

        for (int i = 0; i < text.length() - k; i++) {
            if (text.substring(i, i + k).equals(seed.toString()))
                chars.add(text.charAt(i + k));
        }

        return chars;
    }

    // Returns random character from list of possible characters
    public static char chooseCharacter(List<Character> chars) {
        return chars.get((int) (chars.size()*Math.random()));
    }
}
