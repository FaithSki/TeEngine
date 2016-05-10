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
		public String name = "take";
		public String format = "take (Item)"; // a central method would replace any (Item)s and do something with it to make it work, something would look for items in those (Item) slots
		//take(Item toTake){
		//	PlayerInfo.inventory.add(toTake);
		//}
		public void action() {
			PlayerInfo.inventory.add(verbItem);
			PlayerInfo.playerRoom.items.remove(verbItem);
			System.out.println("You take the " + verbItem.itemName);
		}
	}
	
	public static class look extends Verb {
		public static String name = "look";
		public static String format = "look";
		public void action(){
			System.out.println(PlayerInfo.playerRoom.roomDesc);
		}
	}
}
