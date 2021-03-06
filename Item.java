import java.util.ArrayList;

public class Item {
	String itemName[]; // What the item is referenced as.
	String itemDescription; // What the player sees upon Examining the item.
	boolean pickupAble; // Can the item be picked up?
	boolean useAble; // Can the item be interacted with? (Use, Combine, Open, etc)
	boolean dropAble; // Can the item be dropped into a room?
	boolean visible; // Can the item be seen when the room is examined?
	public Room location;
	public Verb[] possibleActions;
	public String cantPickUpMessage;
	public String cantDropMessage;
	public String cantUseMessage; // "use" is still super broad, but this should be fine for our demo & stuff
	public String pictureTitle;
	public String pictureLocation;//the location "src/Pics/whatever.jpg"
	public Item heldItem = null;
	public boolean open; // try using these with the box
	public static ArrayList<Item> allItems = new ArrayList<Item>();
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
	Item(String[] inputName, String inputDescription, boolean inputPickupAble, boolean inputUseAble, boolean inputDropAble, boolean inputVisible, Verb inputPossibleActions[], String inputCantPickUp, String inputPictureTitle, String inputPictureLocation){
		itemName = inputName;
		itemDescription = inputDescription;
		pickupAble = inputPickupAble;
		useAble = inputUseAble;
		dropAble = inputDropAble;
		visible = inputVisible;
		possibleActions = inputPossibleActions;
		cantPickUpMessage = inputCantPickUp;
		pictureTitle = inputPictureTitle;
		pictureLocation = inputPictureLocation;
		allItems.add(this);
	}

	public boolean isActionPossible(Verb checkVerb){
		for(Verb action : possibleActions)
			if(action == checkVerb) // must point to the same instance, look into this later
				return true;
		return false;
	}
	
	public String returnName(){
		try{
			return (itemName[0] + " " + itemName[1]);
		}
		catch(Exception a){
			return itemName[0];
		}
	}
	
	public void setLocation(Room inputRoom){
		location = inputRoom;
	}

	public static boolean isItem(String word){
		for(Item currentItem : allItems){
			try{//why do you have this try/catch here? seems useless too meeee
				if(word.equalsIgnoreCase(currentItem.itemName[0]))
					return true;
			}catch (Exception a){
				return false;
			}
		}
		return false;
	}

	public static boolean isItem(String firstWord, String secondWord){
		for(Item currentItem : allItems){
			try{
				if(firstWord.equalsIgnoreCase(currentItem.itemName[0]) && secondWord.equalsIgnoreCase(currentItem.itemName[1]))
					return true;
			}catch(Exception a){
				return false;
			}
		}
		return false;
	}

	public static Item getItem(String word){
		for(Item currentItem : allItems)
			if(word.equalsIgnoreCase(currentItem.itemName[0]))
				return currentItem;
		return null;
	}

	public static Item getItem(String firstWord, String secondWord){
		for(Item currentItem : allItems)
			if(firstWord.equalsIgnoreCase(currentItem.itemName[0]) && secondWord.equalsIgnoreCase(currentItem.itemName[1]))
				return currentItem;
		return null;
	}

	// Following methods all just retrieve variables
	public String itemName(){
		if(itemName.length == 1)
			return itemName[0];
		else
			return itemName[0] + " " + itemName[1];
	}
	public String itemDescription(){
		return itemDescription;
	}
	public boolean pickupAble(){
		return pickupAble;
	}
	public boolean useAble(){
		return useAble;
	}
	public boolean dropAble(){
		return dropAble;
	}
	public boolean visible(){
		return visible;
	}
}
