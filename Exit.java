import java.util.ArrayList;
public class Exit {
	
	//Room room1; // One of the two rooms that the Exit leads between; this room should be encountered before room2
	//Room room2; // One of the two rooms that the Exit leads between; this room should be encountered after room1
	// [room1] <---> (exit) <---> [room2]
	// in room 1, exit is called "east" (room1Names = "east, e")
	// in room 2, exit is called "west" (room2Names = "west, w")
	// the player would, organizationally, have to go through room 1 before they've been in room 2, but that's totally 
	// not neccessary at all.
	String[] room1Name; // What the Exit is called in room1; should be cardinal directions, if possible (n & north, se & southeast, etc) the game should establish at the start whether or not they should be adressed as "northwest" or "nw"
	String[] room2Name; // What the Exit is called in room2; should be cardinal directions, if possible (n & north, se & southeast, etc)
	String exitRoom1; // The text for when you exit room 1 and enter room 2
	String exitRoom2; // The text for when you exit room 2 and enter room 1
	boolean locked; // Can the Player travel through the Exit?
	String lockedText; // What's printed when the Player tries to travel through the locked Exit
	public static ArrayList<Exit> allExits = new ArrayList<Exit>();
	/*Exit constructor takes, in this order:
	 * Room 1 (Room)
	 * Room 2 (Room)
	 * Name in Room 1 (String)
	 * Name in Room 2 (String)
	 * Description of Exiting Room 1 (String)
	 * Description of Exiting Room 2 (String)
	 * Locked (Boolean)
	 * Locked Text (String)
	 */
	Exit(String[] inputRoom1Name, String[] inputRoom2Name, String inputExitRoom1, String inputExitRoom2, boolean inputLocked, String inputLockedText){
		//room1 = inputRoom1;
 		//room2 = inputRoom2;
 		room1Name = inputRoom1Name;
 		room2Name = inputRoom2Name;
 		exitRoom1 = inputExitRoom1;
 		exitRoom2 = inputExitRoom2;
 		locked = inputLocked;
 		lockedText = inputLockedText;
 		allExits.add(this);
 	}
	
	/*public Room room1(){
		return room1;
	}
	
	public Room room2(){
		return room2;
	}*/
	
	public String room1Name(int index){
		return room1Name[index];
	}
	
	public String room2Name(int index){
		return room2Name[index];
	}
	
	public boolean locked(){
		return locked;
	}
	
	public void changeLocked(boolean toggle){
		locked = toggle;
	}
	
	public static boolean isExit(String word){
		for(Exit currentExit : allExits)
			if(word.equalsIgnoreCase(currentExit.room1Name[0]) || word.equalsIgnoreCase(currentExit.room2Name[0]))
				return true;
		return false;
	}
	
	public static boolean isExit(String firstWord, String secondWord){
		for(Exit currentExit : allExits)
			if((firstWord.equalsIgnoreCase(currentExit.room1Name[0]) && secondWord.equalsIgnoreCase(currentExit.room1Name[1])) || (firstWord.equalsIgnoreCase(currentExit.room2Name[0]) && secondWord.equalsIgnoreCase(currentExit.room2Name[1])))
				return true;
		return false;
	}
	
	public static Exit getExit(String word){
		for(Exit currentExit : allExits)
			if(word.equalsIgnoreCase(currentExit.room1Name[0]) || word.equalsIgnoreCase(currentExit.room2Name[0]))
				return currentExit;
		return null;
	}
	
	public static Exit getExit(String firstWord, String secondWord){
		for(Exit currentExit : allExits)
			if((firstWord.equalsIgnoreCase(currentExit.room1Name[0]) && secondWord.equalsIgnoreCase(currentExit.room1Name[1])) || (firstWord.equalsIgnoreCase(currentExit.room2Name[0]) && secondWord.equalsIgnoreCase(currentExit.room2Name[1])))
				return currentExit;
		return null;
	}
}
