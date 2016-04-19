public class Verb {
	public String name;
	public static Verb allVerbs[];
	public Item actsOn;
	
	public static void drop(Item dropItem, Room currentRoom){
		// I didn't realize that you can just specify the name of the object when removing it from an ArrayList;
		// the for loop was for going through each element in the ArrayList to see if it matched dropItem ^^
		if(dropItem.dropAble){
			PlayerInfo.inventory.remove(dropItem);
			currentRoom.items.add(dropItem);
			System.out.println("You drop the " + dropItem.itemName() + ".");
		}else
			System.out.print("You'd rather not part with that.");
	}
	public static void take(Item takeItem, Room currentRoom){
		if(takeItem.pickupAble){
			PlayerInfo.inventory.add(takeItem);
			currentRoom.items.remove(takeItem);
			System.out.println("You take the " + takeItem.itemName() + ".");
		}else
			System.out.println("It won't budge.");
		// once we have our demo done, we should figure out how to have it so items can override these "you can't do" messages.
		// so, like, idk; "It won't budge" is fine for, like, a boulder, but it'd be nice to add extra flavor for things that have
		// other reasons as to why you can't/won't take it, drop it, etc.
	}
	public static void examine(Item examineItem, Room currentRoom){
		System.out.println(examineItem.itemDescription());
	}
}
