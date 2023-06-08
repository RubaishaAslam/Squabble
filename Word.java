/**
 * Class Word represents a word in the game that is comprised of any number of letters
 * @Rubaisha  CS1027 Assignment 2
 */

public class Word {
	
	private LinearNode<Letter> firstLetter;
	
	public Word(Letter[] letters) { // from array add to linked structure 
		
		LinearNode<Letter> newLetter = null; 
		LinearNode<Letter> currLetter;
		
		int arrayLetter = 0;
		while (arrayLetter < letters.length) {
			currLetter = new LinearNode<>(letters[arrayLetter]);
			
			if (arrayLetter != 0) {
				newLetter.setNext(currLetter);
			} else {
				this.firstLetter = currLetter;
			}
			newLetter = currLetter;
			
			arrayLetter++; 
		}
	}
	
	
	public String toString() { // // add to string from letter string
		
		StringBuilder overrideString = new StringBuilder("Word: ");
		
		LinearNode<Letter> node = firstLetter;
		
		while (node != null) {
			
			if (node.getElement() != null) {
				String addElement = node.getElement().toString();
				overrideString.append(addElement).append(" ");
			}
			
			node = node.getNext();
		}
		
		return overrideString.toString();
	}
	
	
	public boolean labelWord(Word mystery) { // word label method that returns the true and false  
		LinearNode<Letter> node = firstLetter;
		
		int counter = 0;
		boolean identical = false;
		while (node != null) {
			if (node.getElement() != null) {
				if (counter == 0) {
					identical = true;
				}
				int check = mystery.checkPosition(node.getElement(), counter);
				if (check == 2) {
					node.getElement().setCorrect();
				} else if (check == 1) {
					node.getElement().setUsed();
					identical = false;
				} else {
					node.getElement().setUnused();
					identical = false;
				}
			}
			counter++;
			node = node.getNext();
		}
		return identical;
	}
	
	//helper method
	private int checkPosition(Letter letter, int position) {
		LinearNode<Letter> node = firstLetter;
		
		int num = 0;
		int counter = 0;
		while (node != null) {
			if (node.getElement() != null) {
				if (letter.equals(node.getElement())) {
					num = 1;
					if (counter == position) {
						num = 2;
						return num;
					}
				}
			}
			counter++;
			node = node.getNext();
		}
		
		return num;
	}
}
