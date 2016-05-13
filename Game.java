import java.util.ArrayList;


public class Game {
	
	// Am I understanding this correctly?
	
	
	//you should be able to just put the instance of stuff in the variable declaration, not sure if constructor is needed
	//and when things are created they are automatically added to the arraylist of allWhatevers for the whole program
	public static ArrayList<Exit> exits = new ArrayList<Exit>();
	public static ArrayList<Item> items = new ArrayList<Item>();

	public Item bed;
	public Item window;
	public Item television;
	public Item blank;
	
	public Room startApartment;
	
	public Game(){
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
		Verb[] bedActions = {null};
		Item bed = new Item("Bed","Essentially just a mattress with a wrinkled, white sheet tossed atop it.",false,false,false,true,bedActions,"It's too heavy.");
		Verb[] windowActions = {null};
		Item window = new Item("Window","The glass is fogged over, but you can just barely see outside. A sprawling skyline of densely-packed buildings is visible, each block dotted with blue lights from thousands of lit windows and street lights. It’s raining. You can see a flash of lightning in the distance.",false,true,false,true,windowActions,"It's firmly installed into the wall.");
		Verb[] televisionActions = {null};
		Item television = new Item("Television","An old beat-up trideo television set, packed into a neat box with a screen and a lens. The 3D projector’s busted, but the old-school flatscreen looks fine.",false,true,false,true,televisionActions,"It's a bit too heavy to just lug it around.");
		Verb[] generalActions = {null};//take maybe should be on the item side and not the "general actions" side
		Item blank = new Item("","",false,false,false,false,generalActions,"");
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
	}
	
	public static void resetRoomArrayLists(){
		exits = new ArrayList<Exit>();
		items = new ArrayList<Item>();
	}
}
