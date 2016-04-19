import java.util.ArrayList;
import java.util.Scanner;
public class Base {
	/*
	 *I feel that if we're going to have a game engine then we should have the engine, that interacts with another class containing the actual content of our game(items, rooms, verbs) 
	 */
	public static boolean itsHappening = true;
	public static ArrayList exits = new ArrayList<Exit>();
	public static ArrayList items = new ArrayList<Item>();
	
	public static Room playerRoom = new Room("","","",items,exits);
	
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
		Room dankDungeon = new Room("DUNGEON","A dark, dank expanse of cobbled stone, forming the room around you.","A dark cobblestone room.",items,exits);
		resetRoomArrayLists();
		Room pastaParlor = new Room("PASTA PARLOR","A quaint little Italian resturaunt. The tables are covered with red-and-white checkered tableclothes and stacked high with bowls of spaghetti, but no other patrons are visible.","An empty Italian resturaunt.",items,exits);
		// End constructing all game objects

		Scanner sc = new Scanner(System.in);
		// Just laying a groundwork to show how the actual game-loop will work.
		playerRoom = pastaParlor;
		while (itsHappening = true){
			// maybe we should stop printing the roomname + roomdesc/shortdesc after your first "turn" in a room, until you change rooms
			// use the short description after every turn, "look" for long description
			System.out.println(playerRoom.roomName()); 
			// playerRoom references whatever room the player is currently in, I guess??
			if (playerRoom.visited() == false){
				// visisted should stay true after the first visit, to prevent too much spam when you're trying to navigate your way across the "world."
				// the full description should be able to be brought up again with a "look" verb, and maybe in the future we can have an option to
				// choose whether you get shortdescriptions or the full description everytime (most infocom interactive fictions have something like that).
				System.out.println(playerRoom.roomDesc());
			}
			else{
				System.out.println(playerRoom.roomShortDesc());
			}
			System.out.print(">_ ");
			String input = sc.nextLine();
			playerRoom.visited = true;
			System.out.println();
			// at this point, we need to be able to detect a noun & a verb in the input. common verbs will be easy; "take" will just add a pickupable item
			// to an inventory arraylist; "drop" will add the item to the playerRoom's item arraylist; examine will print the itemdescription. I don't know
			// how we're going to handle the logic for unique interactions, like "use fork with spaghetti" or "screw in lightbulb."
			// "use <Item1> with <Item2>" will have to be a special case, and "screw in" can be a Verb associated with a lightbulb
			checkInput(input);
			System.out.println();
		}
	}
	public static void resetRoomArrayLists(){
		exits = new ArrayList<Exit>();
		items = new ArrayList<Item>();
	}
	
	private static void checkInput(String input){
		/*
		if (input.equalsIgnoreCase("look"))
			return playerRoom.roomDesc();
		else
			return "That is not a recognized command";
			*/
		// need to figure out splitting the input into a verb and a noun, I guess?? 
		// examine <noun> prints itemdescription 
		// take/grab/pickup <noun> checks if item is pickupable and adds to inventory arraylist
		// drop <noun> checks if item is droppable and adds to playerRoom's item arraylist
		
		// this is going to be some really rough code for implementing Verbs into this method, should give you a basic idea
		for(Verb currentVerb : Verb.allVerbs){
			if(input.equalsIgnoreCase(currentVerb.name)){
				// then do sometthiiiiiiiing
				// might need to make Verbs into individual methods in the Verb class, or their own classes; idk how we're going to get basic functionality
				// out of them by just passing parameters when we construct them.
				// so, like, maybe if currentVerb is "drop", it calls Verb.drop(nounItem, playerRoom) or something.
				// ('nounItem' would be whatever noun the verb is being applied to.
			}
			
		}
		
		
	}
	
	public static void main (String str[]) {
		runGame();
	}
}
