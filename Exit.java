import java.util.ArrayList;
public class Exit {
	
	String room1; // One of the two rooms that the Exit leads between; this room should be encountered before room2
	String room2; // One of the two rooms that the Exit leads between; this room should be encountered after room1
	// [room1] <---> (exit) <---> [room2]
	// in room 1, exit is called "east" (room1Names = "east, e")
	// in room 2, exit is called "west" (room2Names = "west, w")
	// the player would, organizationally, have to go through room 1 before they've been in room 2, but that's totally 
	// not neccessary at all.
	String[] room1Names; // What the Exit is called in room1; should be cardinal directions, if possible (n & north, se & southeast, etc)
	String[] room2Names; // What the Exit is called in room2; should be cardinal directions, if possible (n & north, se & southeast, etc)
	String[] generalName; 
	boolean locked; // Can the Player travel through the Exit?
	public static ArrayList<Exit> allExits = new ArrayList<Exit>();
	
	Exit(String inputRoom1, String inputRoom2, String[] inputRoom1Names, String[] inputRoom2Names, boolean inputLocked){
		room1 = inputRoom1;
 		room2 = inputRoom2;
 		room1Names = inputRoom1Names;
 		room2Names = inputRoom2Names;
 		locked = inputLocked;
 		allExits.add(this);
 	}
	
	public String room1(){
		return room1;
	}
	
	public String room2(){
		return room2;
	}
	
	public String room1Names(int index){
		return room1Names[index];
	}
	
	public String room2Names(int index){
		return room2Names[index];
	}
	
	public boolean locked(){
		return locked;
	}
	
	public void changeLocked(boolean toggle){
		locked = toggle;
	}
	
	public boolean isExit(String word){
			
	}
}
