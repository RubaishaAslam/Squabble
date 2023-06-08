
/**
 * Class Letter represents a single letter that will be used in the game
 * @Rubaisha  CS1027 Assignment 2
 */

public class Letter {
	
	private int label; // add private variables 
	private char letter;
	private static final int UNSET = 0;
	private static final int UNUSED = 1;
	private static final int USED = 2;
	private static final int CORRECT = 3;
	
	public Letter(char c) { // set label and letter 
		label = UNSET;
		letter = c;
	}
	
	
	public boolean equals(Object otherObject) { // checks if new object is same if yes return true, else false
		if (otherObject instanceof Letter) {
			Letter letter = (Letter) otherObject;
			return this.letter == letter.letter;
		} else {
			return false; 
		}
	}
	
	public String decorator() { // set label (decorator)
		if (label == USED) {
			return "+";
			
		} else if (label == UNUSED) {
			return "-";
		}
		if (label == CORRECT) {
			return "!";
		} else if (label == UNSET)
			return " ";
		return "";
		
	}
	
	
	public String toString() { // return string of the decorator 
		return decorator() + letter + decorator();
	}
	
	public void setUnused() { // integer label which indicates whether it is used, unused, or correct with respect to the mystery word.
		label = UNUSED;
	}
	
	public void setUsed() {
		label = USED;
	}
	
	public void setCorrect() {
		label = CORRECT;
	}
	
	
	public boolean isUnused() { 
		return label == UNUSED;
	}
	
	
	public static Letter[] fromString(String s) {  // produce array and add to it 
		int sLength = s.length();
		Letter[] arraySort = new Letter[sLength]; // create an empty array with the length of s
		for (int i = 0; i < sLength; ++i) {
			arraySort[i] = new Letter(s.charAt(i));   // add the characters to array
		}
		return arraySort;
	}
	
}
