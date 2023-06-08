/**
 * Class WordLL stores a mystery word and all word guesses
 * @Rubaisha  CS1027 Assignment 2
 */

public class WordLL {
	
	private Word mysteryWord; // add private methods 
	private LinearNode<Word> history; // Initialize empty history 
	
	
	public WordLL(Word mystery) {
		
		history = null;
		this.mysteryWord = mystery; // add mystery word
		
	}
	
	
	public boolean tryWord(Word guess) { // returns true if the word represented by guess is identical to the word represented by mysteryWord, otherwise returns false
		boolean check = guess.labelWord(mysteryWord);
		
		LinearNode<Word> word = new LinearNode<>(guess);
		if (history!=null){
			word.setNext(history);
		}
		history = word;
		
		return check;
		
		
	}
	
	
	public String toString() { // String representation of the past guesses
		
		LinearNode<Word> current = history; // take linked structure and switch to string 
		StringBuilder string = new StringBuilder();
		while (current != null) {
			
			string.append(current.getElement().toString()).append("\n");
			current = current.getNext();
		}
		return string.toString();
		
	}
}