public class Verb {
	public String name;
	public static String allVerbs[];
	public Item actsOn;
	//we really need to change the way that verbs work
	public static void drop(Item dropItem, Room currentRoom){
		// I didn't realize that you can just specify the name of the object when removing it from an ArrayList;
		// the for loop was for going through each element in the ArrayList to see if it matched dropItem ^^
		// I'm just assuming it works
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
			System.out.println(takeItem.cantPickUpMessage);
		
		// once we have our demo done, we should figure out how to have it so items can override these "you can't do" messages.
		// so, like, idk; "It won't budge" is fine for, like, a boulder, but it'd be nice to add extra flavor for things that have
		// other reasons as to why you can't/won't take it, drop it, etc.
		
		//with this we'll probably run into some exception eventually but it should work for objects that you cant pick up because of one un-changing thing
	}
	
	public void isActionPossible(String verb){
 		for(String action : allVerbs){
 			if(action.equalsIgnoreCase(verb)){
 				
 			}
 				//needs to be finished
 		}
	}
	
	public static void examine(Item examineItem){
		System.out.println(examineItem.itemDescription());
	}
	
	public static void look(Room currentRoom){
		System.out.println(currentRoom.roomDesc());
	}
	
	public static void eat(Item toEat){
		System.out.print("You ate the " + toEat.itemName());
		PlayerInfo.inventory.remove(toEat);
	}

	public static void findAction(String foundVerb) {
		
	}
}
