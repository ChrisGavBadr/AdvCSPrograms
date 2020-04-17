package projects.scrabble;

public class MaxScrabbleScore extends TextFileAccessor {

	private static final int[] SCOREBOARD = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
	private int maxScore = 0;
	private String bestLine;

	MaxScrabbleScore() {
	}

	protected void processLine(String line) {
		// process each character from the current line
		// calculate sum of the scores for characters in that line
		int sum = 0;
		
		for (int i = 0; i < line.length(); i++) {
			if (Character.isLetter((line.charAt(i))))
					sum += getScrabbleScore(line.charAt(i), i);
		}
		
		if (maxScore < sum) {
			maxScore = sum;
			bestLine = line;
		}
	}

	private int getScrabbleScore(char c, int position) {
		// helper method to return the score for the character
		c = Character.toLowerCase(c);

		if (position % 4 == 0)
			return 2*SCOREBOARD[c - 'a'];
		else if (position % 9 == 0)
			return 3*SCOREBOARD[c - 'a'];
		else
			return SCOREBOARD[c - 'a'];
	}

	public String getReportStr() {
		// returns the score and the string that was entered
		return "Max Scrabble Score: " + maxScore + " for this line: " + bestLine;
	}

} // end class