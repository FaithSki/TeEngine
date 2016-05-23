import java.util.ArrayList;
public class Character {
	public static ArrayList<Character> allCharacters = new ArrayList<Character>();
	public String name;
	public Room location;
	public int opinion = 0; // the character's disposition for or against the player
	Character(String inputName, Room inputLocation){
		name = inputName;
		location = inputLocation;
		allCharacters.add(this);
	}
	
	public static boolean isCharacter(String word){
		for(Character currentCharacter : allCharacters)
			if(word.equalsIgnoreCase(currentCharacter.name))
				return true;
		return false;
	}
	
	public static Character getCharacter(String word){
		for(Character currentCharacter : allCharacters)
			if(word.equalsIgnoreCase(currentCharacter.name))
				return currentCharacter;
		return null;
	}
}
