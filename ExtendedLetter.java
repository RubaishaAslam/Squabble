
/**
 * Class ExtendedLetter subclass of Letter and extends the functionality and uses string instance rather than char
 * @Rubaisha  CS1027 Assignment 2
 */


import java.util.Objects;

public class ExtendedLetter extends Letter {
	private String content; // add private variable 
	private int family;
	private boolean related;
	private final int SINGLETON = -1;
	
	public ExtendedLetter(String s) { // add instance variable 
		super('c'); 
		this.content = s;
		this.related = false;
		this.family = this.SINGLETON;
	}
	
	
	public ExtendedLetter(String s, int fam) {
		super('c');
		this.content = s;
		this.related = false;
		this.family = fam;
	}
	
	@Override
	public boolean equals(Object other) { // check if this equals to other 
		if (other instanceof ExtendedLetter) {
			
			ExtendedLetter otherExtendedLetter = (ExtendedLetter) other;
			if (this.family == otherExtendedLetter.family) {
				this.related = true;
			}
			
			return Objects.equals(this.content, otherExtendedLetter.content);
		}
		return false; // return false if the parameter other is not an instanceOf ExtendedLetter
	}
	
	public String toString() { // override the string method and add decorator 
		
		if (this.isUnused() && this.related) {
			return "." + this.content + ".";
		} else {
			return decorator() + this.content + decorator();
		}
	}
	
	
	public static Letter[] fromStrings(String[] content, int[] codes) {
		Letter[] letters = new Letter[content.length]; // create new array letters and add objects of the same size 
		
		if (codes == null) {
			for (int i = 0; i < content.length; i++) {
				letters[i] = new ExtendedLetter(content[i]);
			}
		} else {
			for (int i = 0; i < content.length; i++) {
				letters[i] = new ExtendedLetter(content[i], codes[i]);
			}
		}
		
		return letters;
		
	}
}