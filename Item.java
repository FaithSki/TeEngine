import java.util.ArrayList;
 
 
 public class Item {
 	String itemName; // What the item is referenced as.
 	String itemDescription; // What the player sees upon Examining the item.
 	boolean pickupAble; // Can the item be picked up?
 	boolean useAble; // Can the item be interacted with? (Use, Combine, Open, etc)
 	boolean dropAble; // Can the item be dropped into a room?
 	boolean visible; // Can the item be seen when the room is examined?
 	public Room location;
 	public Verb[] possibleActions;
	//public String cantInteractText;
	// I'd rather not do it like that, cuz we'd want a different message for being unable to pickup, unable to drop, unable to use, etc
 	public String cantPickUpMessage;
 	public String cantDropMessage;
 	public String cantUseMessage; // "use" is still super broad, but this should be fine for our demo & stuff
 	public static ArrayList<Item> allItems = new ArrayList<Item>();
 	
 	Item(String inputName, String inputDescription, boolean inputPickupAble, boolean inputUseAble, boolean inputDropAble, boolean inputVisible, Verb inputPossibleActions[], String inputCantPickUp){
 		itemName = inputName;
 		itemDescription = inputDescription;
 		pickupAble = inputPickupAble;
 		useAble = inputUseAble;
 		dropAble = inputDropAble;
 		visible = inputVisible;
 		possibleActions = inputPossibleActions;
 		cantPickUpMessage = inputCantPickUp;
 		allItems.add(this);
 	}
 	
 	public boolean isActionPossible(Verb checkVerb){
 		for(Verb action : possibleActions)
 			if(action == checkVerb) // must point to the same instance, look into this later
 				return true;
 		return false;
 	}
 	
 	public static boolean isItem(String word){
 		for(Item currentItem : allItems)
 			if(word.equalsIgnoreCase(currentItem.itemName))
 				return true;
 		return false;
 	}
 	
 	public static Item getItem(String word){
 		for(Item currentItem : allItems)
 			if(word.equalsIgnoreCase(currentItem.itemName))
 				return currentItem;
 		return null;
 	}
 	
 	// Following methods all just retrieve variables
 	public String itemName(){
 		return itemName;
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
