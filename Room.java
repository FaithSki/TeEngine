import java.util.ArrayList;

public class Room {
	String roomName; // What the room is referenced as.
	String roomDesc; // The description of the room, given upon first entering the room or using the "Look" verb.
	String roomShortDesc; // The abridged description of the room, given upon entering the room for the second time and onwards.
	ArrayList exits; // Directions and objects leading out of the room. (N, E, W, S, Up, Down, Secret Door, etc)
	ArrayList items; // Items placed in the room.
	boolean visited = false; // Has the player been inside of the room before?
	
	Room(String inputName, String inputDesc, String inputShortDesc, ArrayList inputExits, ArrayList inputItems){
		roomName = inputName;
		roomDesc = inputDesc;
		roomShortDesc = inputShortDesc;
		exits = inputExits;
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
	public ArrayList exits(){
		return exits;
	}
	public ArrayList items(){
		return items;
	}
	public boolean visited(){
		return visited;
	}
}
