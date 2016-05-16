import java.util.ArrayList;
import java.util.Scanner;
public class Base {
	/*
	 *I feel that if we're going to have a game engine then we should have the engine, that interacts with another class containing the actual content of our game(items, rooms, verbs) 
	 */
	public static boolean itsHappening = true;
	public static ArrayList<Exit> exits = new ArrayList<Exit>();
	public static ArrayList<Item> items = new ArrayList<Item>();
	public static String[] itemNames = new String[10];
	public static String[] exitNames = new String[10];

	public Item bed;
	public Item window;
	public Item television;
	public Item blank;

	public Room startApartment;
	/*
	oh my gosh golly I didnt realize that the 5/17 due date was for seniors, ours is due on the 24th and we have a whole extra week than what I thought -_-

	Hey look at me

	If you ever want multi-word items/exits or whatever it will be hard, so if you cant find a way around it then we can make special cases in Verb
	we could try having an array for multi word items/exits like {"cardboard","box"} or {"brown","door"}

			We should have a "game" class
			runGame will take an instance of that class in a parameter (or an extension of it) with all items, verbs, rooms, etc.
			it will stay in a variable so that it can be accessed for later use

			the game loop shouldn't have to be that complicated, It will output a starting sequence(if it has one) then ill evaluate the room then call checkInput with your input, the verbs will probably direct most of the action
	 */

	public static void resetRoomArrayLists(){
		exits = new ArrayList<Exit>();
		items = new ArrayList<Item>();
	}
	public static void resetStringArrays(){
		for(int count = 0; count < itemNames.length; count++){
			itemNames[count] = null;
		}
		for(int count = 0; count < exitNames.length; count++){
			exitNames[count] = null;
		}
	}

	public static void runGame(){
		
		// sorry for ditching the Game class, but I can't figure out how to fix the null pointer exception. this breaks the entire game, so, unless you can
		// fix that, I'm just plopping the object construction here. The Game class is unchanged, so we can re-implement it whenever.

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
		resetStringArrays();
		Verb[] bedActions = {null};
		String[] bedNames = {"Bed"};
		itemNames = bedNames;
		Item bed = new Item(itemNames,"Essentially just a mattress with a wrinkled, white sheet tossed atop it.",false,false,false,true,bedActions,"It's too heavy.");
		resetStringArrays();
		Verb[] windowActions = {null};
		String[] windowNames = {"Window"};
		itemNames = windowNames;
		Item window = new Item(itemNames,"The glass is fogged over, but you can just barely see outside. A sprawling skyline of densely-packed buildings is visible, each block dotted with blue lights from thousands of lit windows and street lights. It’s raining. You can see a flash of lightning in the distance.",false,true,false,true,windowActions,"It's firmly installed into the wall.");
		resetStringArrays();
		Verb[] televisionActions = {null};
		String[] tvNames = {"Television"};
		itemNames = tvNames;
		Item television = new Item(itemNames,"An old beat-up trideo television set, packed into a neat box with a screen and a lens. The 3D projector’s busted, but the old-school flatscreen looks fine.",false,true,false,true,televisionActions,"It's a bit too heavy to just lug it around.");
		Verb[] generalActions = {null};//take maybe should be on the item side and not the "general actions" side
		
		resetStringArrays();
		Item blank = new Item(itemNames,"",false,false,false,false,generalActions,"");
		items.add(blank);
		/*Room constructor takes, in this order: 
		 * Name (String)
		 * Description (String)
		 * Short Description (String)
		 * Exits (ArrayList)
		 * Items (ArrayList)
		 */
		items.add(bed);items.add(window);items.add(television);
		Room startApartment = new Room("APARTMENT","You've awakened in the dim light of this small, one-room apartment. The small bed you awoke upon sits in the back corner, facing an old television that's been pushed up against the wall. Drawing your gaze from the TV is a dirty old window, softly glowing with the slight blue light that illuminates the room. Apparently, the light bulb in the ceiling is failing at its job. A faux-wood door is set into the western wall of the room. The rest of the apartment is entirely featureless, aside from the occasional stain in the carpet and tear in the plain wallpaper. You can hear rain outside.","The dirty old apartment you awoke in. Its only exit is through a door to the west. A TV sits below a window, in front of the bed. The ceiling light is off. You can hear rain outside.",items,exits);
		// End constructing all game objects

		Scanner sc = new Scanner(System.in);
		System.out.println("You just woke up in an unfamiliar apartment in a bed that isn't yours, with no clue how you got here or how to leave.");
		System.out.println("Seems that it's up to you to find your way out. Type 'help' for information on how to play.  You can hear rain outside.");
		System.out.println();
		PlayerInfo.playerRoom = startApartment;
		while (itsHappening = true){
			System.out.println(PlayerInfo.playerRoom.roomName()); 
			// this keeps hitting a null pointer exception (!!!). we might need to just totally revert all of the Game class stuff, idkkkk.
			// I moved all of the Game constructor stuff into a method under Base and then i thought that i knew how to fix the null pointer
			// so i reverted all of my changes and whooops my fix didn't work.
			// i'm going to diiiieeee
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

	private static void checkInput(String input){
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
		 *
		 *
		 * ok my idea is that (this sucks if you want to have multi-word items)
		 * make 3 arrays
		 * Item[] inputItem = {null,meme,null,sauce};
		 * String[] inputVerb = {"use","(Item)","with","(Item)"}; any items or exits found in the separated input will be put as "(Item)" or "(Exit)"
		 * String[] inputExit = you get it by nown like inputItem
		 * 
		 * a method in the verb class will match input verb with the format, and then it will look for items in the same space 
		 * once it finds the verb it will pass the action the required items and/or exits or nothing(maybe have to be null?), in order
		 */


		String[] separatedInput = input.split(" ");
		Item[] items = new Item[separatedInput.length];
		String[] verbStrings = new String[separatedInput.length];
		Exit[] exits = new Exit[separatedInput.length];

		/*
		 * What its gonna have to do is if it finds nothing with the name it will go to an alternate item method where it takes n and n+1
		 * 
		 *
		 *  I think i have to use ugly for loops to make this work 
		 *  :(((((((((((((
		 *  it will tell you that your stuff dont work or you cant see it in the verb method
		 */
		// the way it currently works now is that anything that is not a noun is passed to verb as something else, do you want it to be able to say "that is not an item"?
		for(int i = 0;i <= separatedInput.length;i++){
			if(Item.isItem(separatedInput[i]))
				items[i] = Item.getItem(separatedInput[i]);
			else if(separatedInput.length < i && Item.isItem(separatedInput[i],separatedInput[i + 1])){
				items[i] = Item.getItem(separatedInput[i]);
				i++;
				items[i] = null; // when it finds a 2-word item it makes the next items element null and it then moves past it
			}else if(exits[i].isExit(separatedInput[i])){

			}
		}	

	}

	public static void main (String str[]) {
		//Scanner input = new Scanner(System.in);
		runGame();
		//checkInput(input.nextLine());
	}
}
