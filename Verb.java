import java.util.ArrayList;
import java.util.Arrays;
public class Verb {
	public String name;
	public String[] format;
	public static ArrayList<Verb> allVerbs = new ArrayList<Verb>();
	
	Verb(){
		allVerbs.add(this);
	}
	
	public static void findAndExecuteAction(Item[] items, String[] verbStrings){
		System.out.println("DEBUG: finding and executing actions");
		System.out.println(items[0]);
		System.out.println(verbStrings[0]);
		for(Verb toExecute : allVerbs){
			if(Arrays.deepEquals(toExecute.format, verbStrings)){
				System.out.println("yeet");
			}
			else{
				System.out.println("you goofed");
			}
		}
		
				// i still have to look into this method
	}
	
	public static class take extends Verb {
		public String name = "take", format[] = {"take",null}; // a central method would replace any (Item)s and do something with it to make it work, something would look for items in those (Item) slots
		
		public void action(Item[] items, String[] verbStrings, Exit[] exits) {
			if(items[1].location == PlayerInfo.playerRoom && items[1].visible && items[1].pickupAble){
				PlayerInfo.inventory.add(items[1]);
				PlayerInfo.playerRoom.items.remove(items[1]);
				System.out.println("You take the " + items[1].itemName + ".");
			}else
				System.out.println(items[1].cantPickUpMessage);
		}
	}
	
	public static class look extends Verb {
		look(){
			allVerbs.add(this);
			System.out.println("DEBUG: Constructed Look");
		}
		public static String name = "look", format[] = {null,"look"};
		
		public void action(Item[] items, String[] verbStrings){
			System.out.println(PlayerInfo.playerRoom.roomDesc);
		}
	}
	
	public static class examine extends Verb {
		public String name = "examine", format[] = {"examine",null};
		
		public void action(Item[] items, String[] verbStrings) {
			if (((items[1].location == PlayerInfo.playerRoom) || (PlayerInfo.isItemOwned(items[1]))) && items[1].visible){
				System.out.println(items[1].itemDescription);
			}
			System.out.println("You can't see anything like that.");
		}
	}
	
	public static class north extends Verb {
		public String name = "north", format[] = {null,"north"};
		
		public void action(Item[] items, String[] verbStrings) {
			
			System.out.println("You can't see anything like that.");
		}
	}
	
	public static class help extends Verb {
		public String name = "help", format[] = {null,"help"};
		
		public void action(Item[] items, String[] verbStrings) {
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
