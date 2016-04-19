public class Verb {
	public String name;
	public static Verb allVerbs[];
	public Item actsOn;
	
	public static void drop(Item dropItem, Room currentRoom){
		if (dropItem.dropAble == true){
			for (int count = 0; count < inventory.size();){
				
			}
		}
		else{
			System.out.print("You'd rather not part with that.");
		}
		// wip, hope you can see what i was doing
	}
}
