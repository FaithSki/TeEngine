import java.util.ArrayList;
import java.util.Scanner;
public class Base {
	/*
	 *I feel that if we're going to have a game engine then we should have the engine, that interacts with another class containing the actual content of our game(items, rooms, verbs) 
	 */
	public static boolean itsHappening = true;
	public static ArrayList<Exit> exits = new ArrayList<Exit>();
	public static ArrayList<Item> items = new ArrayList<Item>();
	
	public static Room playerRoom = new Room("","","",items,exits);
	
	//TODO: fix our code, now we should remove any items or rooms except for testing stuffs, make sure our game loop is super tight 
	
	public static void runGame(){
		// Start constructing all game objects 
		
		/*Item constructor takes, in this order: 
		 * Name (String)
		 * Description (String)
		 * Pickupable (boolean)
		 * Usable (boolean)
		 * Dropable (boolean)
		 * Visible (boolean)
		 * Possible Actions (String array)
		 * Cantpickupmessage (String) 
		 */
		String[] memeActions = {"examine","post"};
		Item meme = new Item("Meme","An unusually shiny item.",true,false,true,true,memeActions,"You can't quite get a grip on it.");
		String[] spaghettiActions = {"examine","eat"};
		Item spaghetti = new Item("Bowl of spaghetti","A blue plastic bowl, filled to the brim with tasty pasta.",true,true,true,true,spaghettiActions,"It's bolted to the table!");
		String[] actions = {"examine","eat"};
		Item fettuccine = new Item("Fettuccine","delicious",true,true,true,true,actions,"It's too slippery!");
		String[] generalActions = {"look","take"};//take maybe should be on the item side and not the "general actions" side
		Item blank = new Item("","",false,false,false,false,generalActions,"");
		items.add(blank);
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
		items.add(spaghetti);
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
			try{
				checkInput(input);
			}
			catch (Exception a){
				System.out.println("That doesn't quite make sense.");
			}
			System.out.println();
		}
	}	
	public static void resetRoomArrayLists(){
		exits = new ArrayList<Exit>();
		items = new ArrayList<Item>();
	}
	
	private static void checkInput(String input){
		/*
		Item nounItem = new Item("","",false,false,false,false);
		//remember to check the items in the CURRENT ROOM not all items
		for(Item currentItem : playerRoom.items){
			if(input.equalsIgnoreCase(currentItem.itemName)){
				nounItem = currentItem;
			}
		}
		
		for(int count = 0; count < playerRoom.items.size(); count++){
			if(input.equalsIgnoreCase(playerRoom.items(count))){
				nounItem = playerRoom.items(count);
			}
		}
		
		for(Verb currentVerb : Verb.allVerbs){
			if(input.equalsIgnoreCase(currentVerb.name)){
				// aaaahhhhh
				
			}
		}
		
		if (input.equalsIgnoreCase("examine")){
			Verb.examine(nounItem);
		}
		if (input.equalsIgnoreCase("look")){
			Verb.look(playerRoom);
		}
		if (input.equalsIgnoreCase("take")){
			Verb.take(nounItem,playerRoom);
		}
		if (input.equalsIgnoreCase("drop")){
			Verb.drop(nounItem,playerRoom);
		}
		*/
		
		/* What needs to go on here
		 * 1. get input
		 * 2. get verb from input
		 * 3. get noun from input
		 * 4. find Item from noun
		 * 5. now check through all the possible verbs for that noun
		 * 6. if it is a possible action, then do it
		 * We just need a proof of concept for the demo
		 */
		
		
		PlayerInfo.inventory.add(fettuccine);//what do you wanttttt
		
		int space = input.indexOf(" ");
		//input must be in order "verb noun" for now
		//we might want to find a more flexible way to get the input, maybe find the verb keyword FIRST and then find the relating nouns
		//each verb could have a specific format, maybe if it finds "eat" and "with" it will get the "eat with" verb in the "eat 'noun' with 'noun'" format, looking for words before and after with, including spaces
		String foundVerb = input.substring(0,space);
		String foundNoun = input.substring(space);
		
		// if i'm not misunderstanding this; it should check both your inventory and the current room, cuz we want
		// to be able to "take" stuff, "examine" stuff, and maybe "use" stuff without picking it up.
		for(Object current : PlayerInfo.inventory){
			if(current == PlayerInfo.inventory){
				if(fettuccine.isActionPossible(foundVerb)){
					Verb.findAction(foundVerb);
				}else{
					System.out.print("How will you manage that?");
				}
			}else{
				System.out.println("You can't see such a thing.");
			}
		}
	}
	
	public static void main (String str[]) {
		//Scanner input = new Scanner(System.in);
		runGame();
		//checkInput(input.nextLine());
	}
}
