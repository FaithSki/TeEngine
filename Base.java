import java.util.ArrayList;
import java.util.Scanner;

public class Base {
	public static boolean itsHappening = true;
	public static ArrayList<Exit> exits = new ArrayList<Exit>();
	public static ArrayList<Item> items = new ArrayList<Item>();

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
		// Start constructing all game objects
		
		new Verb.look("look",new String[]{"look"});//you can create an array inline for methods, thanks stackoverflow
		new Verb.take("take", new String[]{"take",null});
		new Verb.examine("examine",new String[]{"examine",null});
		new Verb.west("west",new String[]{"west"});
		new Verb.openBox("openBox",new String[]{"open","box"});
		
		/*Item constructor takes, in this order: 
		 * Name (String)
		 * Description (String)
		 * Pickupable (boolean)
		 * Usable (boolean)
		 * Dropable (boolean)
		 * Visible (boolean)
		 * Possible Actions (String array)
		 * "Can't Pick Up" Message (String) 
		 * Picture Title (String)
		 * Picture Location (String)
		 */
		Verb[] bedActions = {null};
		String[] bedName = {"Bed"};
		Item bed = new Item(bedName,"Essentially just a mattress with a wrinkled, white sheet tossed atop it.",false,false,false,true,bedActions,"It's too heavy.",null,null);
		Verb[] windowActions = {null};
		String[] windowName = {"Window"};
		Item window = new Item(windowName,"The glass is fogged over, but you can just barely see outside. A sprawling skyline of densely-packed buildings is visible, each block dotted with\n blue lights from thousands of lit windows and street lights. Off in the distance, the skyscrapers seem to stretch miles into the sky.\n It’s raining. You can see a flash of lightning in the distance.",false,true,false,true,windowActions,"It's firmly installed into the wall.",null,null);
		Verb[] televisionActions = {null};
		String[] tvName = {"TV"};
		Item television = new Item(tvName,"An old beat-up trideo television set, packed into a neat box with a screen and a lens. The 3D projector’s busted, but the old-school flatscreen looks fine.",false,true,false,true,televisionActions,"It's a bit too heavy to just lug it around.",null,null);
		Verb[] keyCardActions = {null};
		String[] keyCardName = {"Key","Card"};
		Item keyCard = new Item(keyCardName,"A paper-thin slab of white plastic, featureless aside from a small, rectangular magnetic strip.",true,true,true,false,keyCardActions,"You goofed.",null,null);
		Verb[] presentActions = {null};
		String[] presentName = {"Box"};
		Item present = new Item(presentName,"A plain cardboard box, featureless aside from the little plastic blue bow taped on to the top. A note is taped to the side.",true,false,false,true,presentActions,"You don't forsee much of a need for a cardboard box. But what's inside?",null,null);
		Verb[] noteActions = {null};
		String[] noteName = {"Note"};
		Item note = new Item(noteName,null,false,false,false,true,keyCardActions,"It's stuck to the box.. though, you can't see anything adhering it to the cardboard.",null,null);// we will put the stuff for picture here
		// The note should open a graphic. Just put a weird, vague, cryptic message on it, like it's from a mysterious benefactor/creepy-weirdo. The box will contain the keycard.
		Verb[] generalActions = {null};
		Item blank = new Item(null,"",false,false,false,false,generalActions,"",null,null);
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
		 * i am not updating these^^^^^
		 */
		
		Room startApartment = new Room("APARTMENT","You've awoken in the dim light of this small, one-room apartment. The small bed you awoke upon sits in the back corner, facing an old television that's been\npushed up against the wall. Drawing your gaze from the TV is a dirty old window, softly glowing with the slight blue light that illuminates the room. Apparently, the\nlight bulb in the ceiling is failing at its job. A faux-wood door is set into the western wall of the room. The rest of the apartment is entirely featureless,\naside from the occasional stain in the carpet and tear in the plain wallpaper. You can hear rain outside.","The dirty old apartment you awoke in. Its only exit is through a door to the west. A TV sits below a window, in front of the bed.\nThe ceiling light is off. You can hear rain outside.",null,null,null,null,items);
		resetRoomArrayLists();
		items.add(window);
		Room commonRoom = new Room("COMMON ROOM","This room is long; more of a hallway with furniture, you figure. Doors line the eastern wall, at least a dozen of them, all identical to the one leading into\n \"your\" apartment, aside from their lack of any sort of handle. Aside from the doors, this room features clusters of old mis-matched plastic and metal chairs, each one\ncushioned and surrounding a stainless steel table. A small kitchenette sits on the western wall, along with a rather nondescript door. To the north lies a curtained\nwindow. You can hear rain outside.","A long common room, dotted with decaying furniture, apartment doors, and a kitchenette. The exit lies to the west. To the north, a window. The apartment you awoke\nin is to the east. You can hear rain outside.",null,null,null,null,items);
		
		
		Exit apartmentDoor1 = new Exit(startApartment, commonRoom,"Turning the stainless-steel handle, you manage to slowly swing the door open and emerge into the hall beyond..","Turning the stainless-steel handle, you re-enter the apartment you awoke in..",true,"The door won't budge; an electronic lock holds it closed, awaiting an authorized keycard. Why is this on the inside?");
		
		startApartment.west = apartmentDoor1;
		commonRoom.east = apartmentDoor1;
		
		
		// End constructing all game objects

		Scanner sc = new Scanner(System.in);
		System.out.println("You just woke up in an unfamiliar apartment in a bed that isn't yours, with no clue how you got here or how to leave.");
		System.out.println("Seems that it's up to you to find your way out. Type \"help\" for information on how to play.  You can hear rain outside.");
		System.out.println();
		PlayerInfo.playerRoom = startApartment;
		while (itsHappening = true){
			System.out.println(PlayerInfo.playerRoom.roomName()); 
			if (PlayerInfo.playerRoom.visited() == false){
				System.out.println(PlayerInfo.playerRoom.roomDesc());
			}
			else{
				System.out.println(PlayerInfo.playerRoom.roomShortDesc());
			}
			System.out.print(">_ ");
			PlayerInfo.playerRoom.visited = true;
			try{
				checkInput(sc.nextLine());
			}
			catch (Exception a){
				System.out.println("That doesn't quite make sense.");
			}
			System.out.println();
		}
	}	

	private static void checkInput(String input){
		String[] separatedInput = input.split(" ");
		Item[] items = new Item[separatedInput.length];
		String[] verbStrings = new String[separatedInput.length];
		Character[] characters = new Character[separatedInput.length];
	
		for(int i = 0;i < separatedInput.length;i++){
			//System.out.println("DEBUG: new for-loop iteration. i = " + i);
			if(Item.isItem(separatedInput[i])){ // throws out-of-bounds w/ a 1 or a 2 when the for-loop uses "i <= seperatedInput.length"
				items[i] = Item.getItem(separatedInput[i]);
				verbStrings[i] = null;
				//System.out.println("DEBUG: one-word Item, i = " + i);
			}else if(separatedInput.length < i && Item.isItem(separatedInput[i],separatedInput[i + 1])){
				items[i] = Item.getItem(separatedInput[i], separatedInput[i + 1]);
				verbStrings[i] = null;
				i++;
				items[i] = null; // when it finds a 2-word item it makes the next items element null and it then moves past it
				//System.out.println("DEBUG: two-word Item, i = " + i);
			}else if(Character.isCharacter(separatedInput[i])){
				characters[i] = Character.getCharacter(separatedInput[i]);
				verbStrings[i] = null;
				//System.out.println("DEBUG: character, i = " + i);
			}
			else{
				verbStrings[i] = separatedInput[i];
				//System.out.println("DEBUG: verb, i = " + i);
			}
		}	
		Verb.findAndExecuteAction(items, characters, verbStrings);
	}
	
	/*private static void printMultiLine(String inputStatement){
		
		//there has to be a simpler solution to this, but idk im being stupid
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
	}*/

	public static void main (String str[]) {
		runGame();
	}
}
