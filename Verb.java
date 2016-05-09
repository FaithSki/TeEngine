public class Verb {//this is how I think the verb class should be made, Im not sure if they should be public(call from everywhere) or private(call from a central method on the Verb class
	public static String name;
	public static String format;
	public static String allVerbs[];
	
	public Verb findVerb(String something){
		return new look();
	}
	
	public class SomeVerb extends Verb {
		SomeVerb(){
			
		}
	}
	
	private class take extends Verb {
		public String name = "take";
		public String format = "take (Item)"; // a central method would replace any (Item)s and do something with it to make it work, something would look for items in those (Item) slots
		//take(Item toTake){
		//	PlayerInfo.inventory.add(toTake);
		//}
	}
	
	private static class look extends Verb {
		public static String name = "look";
		public static String format = "look";
		
		public void action(){
			System.out.println(PlayerInfo.playerRoom.roomDesc);
		}
	}
}
