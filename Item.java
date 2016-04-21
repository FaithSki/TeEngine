 import java.util.ArrayList;
 
 
 public class Item {
 	String itemName; // What the item is referenced as.
 	String itemDescription; // What the player sees upon Examining the item.
 	boolean pickupAble; // Can the item be picked up?
 	boolean useAble; // Can the item be interacted with? (Use, Combine, Open, etc)
 	boolean dropAble; // Can the item be dropped into a room?
 	Room location;
 	public Verb[] possibleActions;
	//public String cantInteractText;
	// I'd rather not do it like that, cuz we'd want a different message for being unable to pickup, unable to drop, unable to use, etc
	public static Item[] allItems;
 	
 	Item(String inputName, String inputDescription, boolean inputPickupAble, boolean inputUseAble, boolean inputDropAble){
 		itemName = inputName;
 		itemDescription = inputDescription;
 		pickupAble = inputPickupAble;
 		useAble = inputUseAble;
 		dropAble = inputDropAble;
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
 }
