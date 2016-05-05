import java.util.ArrayList;
 
 
 public class Item {
 	String itemName; // What the item is referenced as.
 	String itemDescription; // What the player sees upon Examining the item.
 	boolean pickupAble; // Can the item be picked up?
 	boolean useAble; // Can the item be interacted with? (Use, Combine, Open, etc)
 	boolean dropAble; // Can the item be dropped into a room?
 	boolean visible; // Can the item be seen when the room is examined?
 	Room location;
 	public String[] possibleActions;
	//public String cantInteractText;
	// I'd rather not do it like that, cuz we'd want a different message for being unable to pickup, unable to drop, unable to use, etc
 	public String cantPickUpMessage;
 	public String cantDropMessage;
 	public String cantUseMessage; // "use" is still super broad, but this should be fine for our demo & stuff
	public static Item[] allItems;
 	
 	Item(String inputName, String inputDescription, boolean inputPickupAble, boolean inputUseAble, boolean inputDropAble, boolean inputVisible, String inputPossibleActions[], String inputCantPickUp){
 		itemName = inputName;
 		itemDescription = inputDescription;
 		pickupAble = inputPickupAble;
 		useAble = inputUseAble;
 		dropAble = inputDropAble;
 		visible = inputVisible;
 		possibleActions = inputPossibleActions;
 		cantPickUpMessage = inputCantPickUp;
 	}
 	
 	public boolean isActionPossible(String verb){
 		for(String action : possibleActions)
 			if(action.equalsIgnoreCase(verb))
 				return true;
 		return false;
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
 	public String toString(){
 		return itemName;
 	}
 }
