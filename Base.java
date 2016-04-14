import java.util.ArrayList;

public class Base {
	
	public static ArrayList exits = new ArrayList();
	public static ArrayList items = new ArrayList();
	
	public static void runGame(){
		// Start constructing all game objects 
		
		/*Item constructor takes, in this order: 
		 * Name (String)
		 * Description (String)
		 * Pickupable (boolean)
		 * Usable (boolean)
		 * Dropable (boolean)
		 */
		Item meme = new Item("Meme","An unusually dank item.",true,false,true);
		Item spaghetti = new Item("Bowl of spaghetti","A blue plastic bowl, filled to the brim with tasty pasta.",true,true,true);
		
		/*Room constructor takes, in this order: 
		 * Name (String)
		 * Description (String)
		 * Short Description (String)
		 * Exits (ArrayList)
		 * Items (ArrayList)
		 */
		items.add(meme);
		Room dankDungeon = new Room("Dungeon","A dark, dank expanse of cobbled stone, forming the room around you.","A dark cobblestone room.",items,exits);
		resetRoomArrayLists();
		Room pastaParlor = new Room("Pasta Parlor","A quaint little Italian resturaunt. The tables are covered with red-and-white checkered tableclothes and stacked high with bowls of spaghetti, but no other patrons are visible.","An empty Italian resturaunt.",items,exits);
		// End constructing all game objects

		// DEBUGGING I GUESS???
		System.out.println("DEBUG");
		System.out.println();
		System.out.println(meme.itemName());
		// Probs either going to need a method that changes the punctuation/capitalization of the names so it fits in a variety of outputs 
		// like "This is a meme." and "Meme is hungry." Or we can just be lazy and do it like "This is a MEME." and "MEME is hungry."
		// ^^^^^^^^^ Will we ever need that for items? "The meme is hungry." "A meme Is lying on the ground."
		System.out.println(meme.itemDescription());
		System.out.println();
		System.out.println(spaghetti.itemName());
		System.out.println(spaghetti.itemDescription());
		System.out.println();
		System.out.println(pastaParlor.roomName());
		System.out.println(pastaParlor.roomDesc()); 
		// We'll need a method to automatically split the text into a new line if it exceeds the size of the console (on a 1600x900 screen)
		System.out.println(pastaParlor.roomShortDesc());
		System.out.println();
		System.out.println(dankDungeon.roomName());
		System.out.println(dankDungeon.roomDesc());
		System.out.println(dankDungeon.roomShortDesc());
	}
	public static void resetRoomArrayLists(){
		/*
		int sizeExits = exits.size();
		int sizeItems = items.size();
		
		for (int count = 0; count < sizeExits; count++){
			exits.remove(count);
		}
		for (int count = 0; count < sizeItems; count++){
			items.remove(count);
		}
		ya dingus
		*/
		exits = new ArrayList();
		items = new ArrayList();
	}
	public static void main (String str[]) {
		runGame();
	}
}
