import java.util.ArrayList;
public class Verb {
	public String name;
	public String format;
	public static ArrayList<Verb> allVerbs = new ArrayList<Verb>();
	
	Verb(){
		allVerbs.add(this); //I'm hoping that the constructor extends to every verb, then we dont have to worry about manually adding them, whenever the instance of it is made then it will automatically be added
	}
	
	public static void findAndExecuteAction(Item[] items, String[] verbStrings, Exit[] exits){
		System.out.println(items[0]);
		System.out.println(verbStrings[0]);
		System.out.println(exits[0]);
		//for(int i = 0;i <= items.length;i++)
	}
	
	public static class take extends Verb {
		public String name = "take", format[] = {"take","(Item)"}; // a central method would replace any (Item)s and do something with it to make it work, something would look for items in those (Item) slots
		
		public void action(Item takeItem) {
			if(takeItem.location == PlayerInfo.playerRoom && takeItem.visible && takeItem.pickupAble){
				PlayerInfo.inventory.add(takeItem);
				PlayerInfo.playerRoom.items.remove(takeItem);
				System.out.println("You take the " + takeItem.itemName + ".");
			}else
				System.out.println(takeItem.cantPickUpMessage);
		}
	}
	
	public static class look extends Verb {
		public static String name = "look", format[] = {"look"};
		
		public void action(){
			System.out.println(PlayerInfo.playerRoom.roomDesc);
		}
	}
	
	public static class examine extends Verb {
		public String name = "examine", format[] = {"examine","(Item)"};
		
		public void action(Item examineItem) {
			if (((examineItem.location == PlayerInfo.playerRoom) || (PlayerInfo.isItemOwned(examineItem))) && examineItem.visible){
				System.out.println(examineItem.itemDescription);
			}
			System.out.println("You can't see anything like that.");
		}
	}
	
	public static class help extends Verb {
		public String name = "help", format[] = {"help"};
		
		public void action() {
			System.out.println("This is a text-based adventure, inspired by Infocom interactive fiction games.");
			System.out.println("You may perform actions by inputting verbs, or verbs followed by nouns.");
			System.out.println("For example; 'look', 'examine box', 'take key', etc.");
			System.out.println("Additionally, you may navigate between rooms using cardinal directions.");
			System.out.println("'North', or simply 'n', can be inputted to travel through an exit to the north.");
			System.out.println();
			System.out.println("Have fun!");
			System.out.println();
			}
	}
}
