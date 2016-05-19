import java.util.ArrayList;
import java.util.Scanner;

public class Base {
	public static boolean itsHappening = true;
	public static ArrayList<Exit> exits = new ArrayList<Exit>();
	public static ArrayList<Item> items = new ArrayList<Item>();
	public static String[] itemName = new String[10]; //what is this
	public static String[] exitName = new String[10];

	public Item bed;
	public Item window;
	public Item television;
	public Item blank;

	public Room startApartment;

	public static void resetRoomArrayLists(){
		exits = new ArrayList<Exit>();
		items = new ArrayList<Item>();
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
		//this I think should be in an extension of the verb class
		Verb[] bedActions = {null};
		String[] bedName = {"Bed"};
		Item bed = new Item(bedName,"Essentially just a mattress with a wrinkled, white sheet tossed atop it.",false,false,false,true,bedActions,"It's too heavy.");
		System.out.println("DEBUG: Constructed Bed");
		Verb[] windowActions = {null};
		String[] windowName = {"Window"};
		Item window = new Item(windowName,"The glass is fogged over, but you can just barely see outside. A sprawling skyline of densely-packed buildings is visible, each block dotted with blue lights from thousands of lit windows and street lights. It’s raining. You can see a flash of lightning in the distance.",false,true,false,true,windowActions,"It's firmly installed into the wall.");
		System.out.println("DEBUG: Constructed Window");
		Verb[] televisionActions = {null};
		String[] tvName = {"TV"};
		Item television = new Item(tvName,"An old beat-up trideo television set, packed into a neat box with a screen and a lens. The 3D projector’s busted, but the old-school flatscreen looks fine.",false,true,false,true,televisionActions,"It's a bit too heavy to just lug it around.");
		System.out.println("DEBUG: Constructed TV");
		Verb[] generalActions = {null};//take maybe should be on the item side and not the "general actions" side
		
		System.out.println("DEBUG: Checking allItems");
		for(Item currentItem : Item.allItems){
			System.out.println("DEBUG: " + currentItem.itemName());
		}
		// is allItems supposed to be returning stuff like "[Ljava.lang.String;@1db9742"?
		// TODO: itemName is in an array now, when you try to output just an array into the console it gives the reference to it and not the contents of it
		// I changed itemName() to combine the 2 words in a single string
		Item blank = new Item(null,"",false,false,false,false,generalActions,"");
		items.add(blank);
		
		/*Exit constructor takes, in this order:
		 * Room 1 (Room)
		 * Room 2 (Room)
		 * Name in Room 1 (String)
		 * Name in Room 2 (String)
		 * Description of Exiting Room 1 (String)
		 * Description of Exiting Room 2 (String)
		 * Locked (Boolean)
		 * Locked Text (String)
		 */
		String[] apartmentDoor1Room1 = {"west","w"};String[] apartmentDoor1Room2 = {"east","e"};
		Exit apartmentDoor1 = new Exit(apartmentDoor1Room1,apartmentDoor1Room2,"Turning the stainless-steel handle, you manage to slowly swing the door open and emerge into the hall beyond...","Turning the stainless-steel handle, you re-enter the apartment you awoke in...",true,"The door won't budge; an electronic lock holds it closed, awaiting an authorized keycard. Why is this on the inside?");
		// apartmentDoor1 leads between startApartment and apartmentHallway
		
		/*Room constructor takes, in this order: 
		 * Name (String)
		 * Description (String)
		 * Short Description (String)
		 * North Exit (Exit)
		 * South Exit (Exit)
		 * East Exit (Exit)
		 * West Exit (Exit
		 * Items (ArrayList)
		 */
		items.add(bed);
		items.add(window);
		items.add(television); // yo what is this u gotta separate your lines "items.add(bed);items.add(window);items.add(television);"
		Room startApartment = new Room("APARTMENT","You've awakened in the dim light of this small, one-room apartment. The small bed you awoke upon sits in the back corner, facing an old television that's been pushed up against the wall. Drawing your gaze from the TV is a dirty old window, softly glowing with the slight blue light that illuminates the room. Apparently, the light bulb in the ceiling is failing at its job. A faux-wood door is set into the western wall of the room. The rest of the apartment is entirely featureless, aside from the occasional stain in the carpet and tear in the plain wallpaper. You can hear rain outside.","The dirty old apartment you awoke in. Its only exit is through a door to the west. A TV sits below a window, in front of the bed. The ceiling light is off. You can hear rain outside.",null,null,null,apartmentDoor1,items);
		
		
		
		// End constructing all game objects

		Scanner sc = new Scanner(System.in);
		System.out.println("You just woke up in an unfamiliar apartment in a bed that isn't yours, with no clue how you got here or how to leave.");
		System.out.println("Seems that it's up to you to find your way out. Type \"help\" for information on how to play.  You can hear rain outside.");
		System.out.println();
		PlayerInfo.playerRoom = startApartment;
		//yo dude more spaces in lines helps right now
		while (itsHappening = true){
			System.out.println(PlayerInfo.playerRoom.roomName()); 
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

			
			PlayerInfo.playerRoom.visited = true;
			System.out.println();
			
			//try{
				checkInput(sc.nextLine());
			//}
			//catch (Exception a){
				//System.out.println("That doesn't quite make sense.");
			//}
			System.out.println();
		}
	}	

	private static void checkInput(String input){
		String[] separatedInput = input.split(" ");
		Item[] items = new Item[separatedInput.length];
		String[] verbStrings = new String[separatedInput.length];
		Exit[] exits = new Exit[separatedInput.length];

		
		 // it will tell you that your stuff dont work or you cant see it in the verb method
		 
		// the way it currently works now is that anything that is not a noun is passed to verb as something else, do you want it to be able to say "that is not an item"?
		// we can probably just have a message like (verb + " the what?") or something. or do it case-by-case for each verb.
		for(int i = 0;i < separatedInput.length;i++){
			System.out.println("DEBUG: new for-loop iteration. i = " + i);
			if(Item.isItem(separatedInput[i])){ // throws out-of-bounds w/ a 1 or a 2 when the for-loop uses "i <= seperatedInput.length"
				items[i] = Item.getItem(separatedInput[i]);
				verbStrings[i] = null;
				System.out.println("DEBUG: one-word Item, i = " + i);
			}
			else if(separatedInput.length < i && Item.isItem(separatedInput[i],separatedInput[i + 1])){
				items[i] = Item.getItem(separatedInput[i], separatedInput[i + 1]);
				verbStrings[i] = null;
				i++;
				items[i] = null; // when it finds a 2-word item it makes the next items element null and it then moves past it
				System.out.println("DEBUG: two-word Item, i = " + i);
			}/*
			if we're just going to say "north" "s" then we shouldnt need this, but i'll keep it if we want secret or unconventional exits
			else if(Exit.isExit(separatedInput[i])){
				exits[i] = Exit.getExit(separatedInput[i]);
				verbStrings[i] = null;
				System.out.println("DEBUG: one-word Exit, i = " + i);
			}
			else if(separatedInput.length < i && Exit.isExit(separatedInput[i],separatedInput[i + 1])){
				exits[i] = Exit.getExit(separatedInput[i], separatedInput[i + 1]);
				verbStrings[i] = null;
				i++;
				items[i] = null;
				System.out.println("DEBUG: two-word Exit, i = " + i);
			}*/
			else{
				verbStrings[i] = separatedInput[i];
				System.out.println("DEBUG: verb, i = " + i);
			}
		}	
		Verb.findAndExecuteAction(items, verbStrings);
	}
	
	private static void printMultiLine(String inputStatement){
		// omggg this should be so easy but i keep messing up and having to re-write it
		// we have to think about it if we don't want it to do somethi
		// stupid and work like it do
		// now
		
		/*
		String newLine;
		int lineIndex;
		boolean gogogo = true;
		
		if (inputStatement.length() > 110){
			newLine = inputStatement.substring((inputStatement.length() - 109), inputStatement.length());
			inputStatement = inputStatement.substring(0, inputStatement.length() - 110);
			while (gogogo == true){
				System.out.println(newLine);
				System.out.println(newLine.length() - 1);
				if ((newLine.substring((newLine.length() - 1)).equals(" ")) || (newLine.substring((newLine.length() - 1)).equals(".")) || (newLine.substring((newLine.length() - 1)).equals(",")) || (newLine.substring((newLine.length() - 1)).equals(":")) || (newLine.substring((newLine.length() - 1)).equals(";"))){
					gogogo = false;
				}
				else{
					newLine = newLine.substring(0, (newLine.length() - 1));
				}
			}
			System.out.println("DEBUG: New iteration of printMultiLine:");
			printMultiLine(inputStatement);
			System.out.println(newLine);
		}
		else{
			System.out.println(inputStatement);
		}
		*/
		System.out.println("length:" + inputStatement.length());
		
		if (inputStatement.length() > 110 && inputStatement.indexOf(" ") >= 110){
			System.out.println(inputStatement.substring(109,inputStatement.indexOf(" ")));
			
			printMultiLine(inputStatement.substring(inputStatement.substring(inputStatement.indexOf(" "))));//dont worry ill get it to work
		}else
			System.out.println(inputStatement);
	}

	public static void main (String str[]) {
		//Scanner input = new Scanner(System.in);
		//runGame();
		printMultiLine("You've awakened in the dim light of this small, one-room apartment. The small bed you awoke upon sits in the back corner, facing an old television that's been pushed up against the wall. Drawing your gaze from the TV is a dirty old window, softly glowing with the slight blue light that illuminates the room. Apparently, the light bulb in the ceiling is failing at its job. A faux-wood door is set into the western wall of the room. The rest of the apartment is entirely featureless, aside from the occasional stain in the carpet and tear in the plain wallpaper. You can hear rain outside.");
		//checkInput(input.nextLine());
	}
}
