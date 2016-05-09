import java.util.ArrayList;
import java.util.Scanner;
public class Base {
	/*
	 *I feel that if we're going to have a game engine then we should have the engine, that interacts with another class containing the actual content of our game(items, rooms, verbs) 
	 */
	public static boolean itsHappening = true;
	public static ArrayList<Exit> exits = new ArrayList<Exit>();
	public static ArrayList<Item> items = new ArrayList<Item>();
	
	//TODO: clean this crap up, I have no idea what you did that you still need so if you dont need it then delete it
	
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
		PlayerInfo.playerRoom = pastaParlor;
		while (itsHappening = true){
			// maybe we should stop printing the roomname + roomdesc/shortdesc after your first "turn" in a room, until you change rooms
			// use the short description after every turn, "look" for long description
			System.out.println(PlayerInfo.playerRoom.roomName()); 
			// playerRoom references whatever room the player is currently in, I guess??
			if (PlayerInfo.playerRoom.visited() == false){
				// visisted should stay true after the first visit, to prevent too much spam when you're trying to navigate your way across the "world."
				// the full description should be able to be brought up again with a "look" verb, and maybe in the future we can have an option to
				// choose whether you get shortdescriptions or the full description everytime (most infocom interactive fictions have something like that).
				System.out.println(PlayerInfo.playerRoom.roomDesc());
			}
			else{
				System.out.println(PlayerInfo.playerRoom.roomShortDesc());
			}
			System.out.print(">_ ");

			String input = sc.nextLine();
			PlayerInfo.playerRoom.visited = true;
			System.out.println();
			// at this point, we need to be able to detect a noun & a verb in the input. common verbs will be easy; "take" will just add a pickupable item
			// to an inventory arraylist; "drop" will add the item to the playerRoom's item arraylist; examine will print the itemdescription. I don't know
			// how we're going to handle the logic for unique interactions, like "use fork with spaghetti" or "screw in lightbulb."
			// "use <Item1> with <Item2>" will have to be a special case, and "screw in" can be a Verb associated with a lightbulb
			//try{
				checkInput(input);
			//}
			//catch (Exception a){
				//System.out.println("That doesn't quite make sense.");
			//}
			System.out.println();
		}
	}	
	public static void resetRoomArrayLists(){
		exits = new ArrayList<Exit>();
		items = new ArrayList<Item>();
	}
	
	private static void checkInput(String input){
		/* What needs to go on here
		 * 1. get input
		 * 2. get verb from input
		 * 3. get noun from input
		 * 4. find Item from noun
		 * 5. now check through all the possible verbs for that noun
		 * 6. if it is a possible action, then do it
		 * We just need a proof of concept for the demo
		 */
				//input must be in order "verb noun" for now
				//we might want to find a more flexible way to get the input, maybe find the verb keyword FIRST and then find the relating nouns
				//each verb could have a specific format, maybe if it finds "eat" and "with" it will get the "eat with" verb in the "eat 'noun' with 'noun'" format, looking for words before and after with, including spaces
		boolean doesNounExist = false;
		int space = input.indexOf(" ");
		
		if(!(space == -1)){
			String foundVerb = input.substring(0,space);
			String foundNoun = input.substring(space);

			for(Item current : PlayerInfo.inventory)
				if(current.itemName == foundNoun){
					doesNounExist = true;
					if(current.isActionPossible(foundVerb))
						//VerbMain.findVerb(foundVerb);
						System.out.print("debug");
					else
						System.out.print("How will you manage that?");	
				}
			for(int count = 0; count < PlayerInfo.playerRoom.items.size(); count++){
				// sorry for using my crappy for loop again, but foreach doesn't like ArrayLists since they return Objects instead of Items
				if(PlayerInfo.playerRoom.items.get(count) == foundNoun){
					doesNounExist = true;
					Verb runVerb = VerbMain.findVerb(foundVerb);
					runVerb.action();
				}
					else
						System.out.print("How will you manage that?");	
				}
			if(!doesNounExist)
				System.out.println("You can't see such an item.");
		}else{
			Verb runVerb = VerbMain.findVerb(input);
			runVerb.action();
		}
	}
	
	public static void main (String str[]) {
		//Scanner input = new Scanner(System.in);
		runGame();
		//checkInput(input.nextLine());
	}
}
