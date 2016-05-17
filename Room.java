import java.util.ArrayList;

public class Room {
	String roomName; // What the room is referenced as.
	String roomDesc; // The description of the room, given upon first entering the room or using the "Look" verb.
	String roomShortDesc; // The abridged description of the room, given upon entering the room for the second time and onwards.
	Exit north;
	Exit south;
	Exit east;
	Exit west;
	ArrayList items; // Items placed in the room.
	boolean visited = false; // Has the player been inside of the room before?
	
	Room(String inputName, String inputDesc, String inputShortDesc,Exit inputNorth, Exit inputSouth, Exit inputEast, Exit inputWest, ArrayList inputItems){
		roomName = inputName;
		roomDesc = inputDesc;
		roomShortDesc = inputShortDesc;
		north = inputNorth;
		south = inputSouth;
		east = inputEast;
		west = inputWest;
		items = inputItems;
	}
	// Following methods all just retrieve variables
	public String roomName(){
		return roomName;
	}
	public String roomDesc(){
		return roomDesc;
	}
	public String roomShortDesc(){
		return roomShortDesc;
	}
	public ArrayList items(){
		return items;
	}
	public boolean visited(){
		return visited;
	}
}
