public class Exit {
	
	String room1; // One of the two rooms that the Exit leads between; this room should be encountered before room2
	String room2; // One of the two rooms that the Exit leads between; this room should be encountered after room1           I dont get what youre saying for these 4 string things
	String[] room1Names; // What the Exit is called in room1; should be cardinal directions, if possible (n & north, se & southeast, etc)
	String[] room2Names; // What the Exit is called in room2; should be cardinal directions, if possible (n & north, se & southeast, etc)
	boolean locked; // Can the Player travel through the Exit?
	
	Exit(String inputRoom1, String inputRoom2, String[] inputRoom1Names, String[] inputRoom2Names, boolean inputLocked){
		room1 = inputRoom1;
 		room2 = inputRoom2;
 		room1Names = inputRoom1Names;
 		room2Names = inputRoom2Names;
 		locked = inputLocked;
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
}