public abstract class VerbTest {//this is how I think the verb class should be made, Im not sure if they should be public(call from everywhere) or private(call from a central method on the Verb class
	public String name;
	public static String allVerbs[];
	
	/*
	 * public String findVerb(String something){
	 * 		search through stuff
	 * }
	 * 
	 * 
	 */
	public class SomeVerb extends VerbTest {
		SomeVerb(){
			
		}
	}
	
	private class take extends VerbTest {
		public String name = "take";
		public String format = "take (Item)"; // a central method would replace any (Item)s and do something with it to make it work, something would look for items in those (Item) slots
		take(Item toTake){
			PlayerInfo.inventory.add(toTake);
		}
	}
}
