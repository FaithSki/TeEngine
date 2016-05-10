public abstract class Verb {
	public String name;
	public String format;
	abstract void action();
	
	public class SomeVerb extends Verb {
		public void action(){
			// this does nothing
		}
	}
	
	public class take extends Verb {
		public String name = "take", format[] = {"take","(Item)"}; // a central method would replace any (Item)s and do something with it to make it work, something would look for items in those (Item) slots
		//take(Item toTake){
		//	PlayerInfo.inventory.add(toTake);
		//}
		public void action(Item takeItem) {
			if(takeItem.location == PlayerInfo.playerRoom && takeItem.visible){
				PlayerInfo.inventory.add(PlayerInfo.playerRoom.items.remove(takeItem));
				
				System.out.println("You take the " + takeItem.itemName + ".");
			}else
				System.out.println("You don't see such an item.");
		}
	}
	
	public static class look extends Verb {
		public static String name = "look", format[] = {"look"};
		public void action(){
			System.out.println(PlayerInfo.playerRoom.roomDesc);
		}
	}
}
