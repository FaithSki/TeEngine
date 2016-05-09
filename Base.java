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
		
		/*
		 * What I was saying to do with this method
		 * 
		 * have arrays of strings
		 * 
		 * String[] format = {"use","(Item)","with","(Item)"};
		 * String[] separatedInput = {"use","memes","with","sauce"};
		 * 
		 * It will be easy to handle in this manner
		 * but will the engine handle
		 */
		boolean works = true;
		//TODO there are some big things wrong with the framework of the method(what does it do once it finds nouns and verbs, you cant put them both into an array) but the basic idea is that it goes through each item in the array and finds what it is
		//I have an idea ill write down later
		String[] separatedInput = input.split(" ");
		// we should also think about how to work exits into this method
		for(String word : separatedInput){
			if(works = true)
				if(Item.isItem(word)){
					if(PlayerInfo.isItemOwned){
					
					
				}
			}
		}	
			
		/*	
		Ignore for now, rewriting again
		 
		boolean doesNounExist = false;
		int space = input.indexOf(" "); 
		 
		if(space == -1){

			for(Item current : PlayerInfo.inventory)
				if(current.itemName == foundNoun){
					doesNounExist = true;
					if(current.isActionPossible(foundVerb)) // gotta get a verb
						Verb.findAction(foundVerb);
					else
						System.out.print("How will you manage that?");	
				}
			if(!doesNounExist)
				System.out.println("You can't see such an item.");
		}else
			System.out.println("That doesn't quite make sense.");
		*/
	}
	
	public static void main (String str[]) {
		//Scanner input = new Scanner(System.in);
		//runGame();
		//checkInput(input.nextLine());
		for(String t : "ayy bee cee".split(" "))
			System.out.println(t);
		//TODO: look at meeeee TODO: look at dis shiznitt, makes things simple
	}
}