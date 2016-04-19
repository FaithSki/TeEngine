public class Verb {
	public String name;
	public static Verb allVerbs[];
	public Item actsOn;
	
	public static void drop(Item dropItem, Room currentRoom){
		/*
		if(dropItem.dropAble == true){
			for(int count = 0; count < inventory.size();){
				
			}
		}
		else{
			System.out.print("You'd rather not part with that.");
		}*/
		// wip, hope you can see what i was doing
		//no idear wat youre doing wit the for loop so I'm gonna leave that, i'd think this is all you have to do(with errors)
		if(dropItem.dropAble){
			inventory.remove(dropItem);
			currentRoom.items.add(dropItem);
		}else
			System.out.print("You'd rather not part with that.");
		
	}
}
