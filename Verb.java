import java.util.ArrayList;
import java.util.Arrays;

public class Verb {
	public String name;
	public String[] format;
	public static ArrayList<Verb> allVerbs = new ArrayList<Verb>();
	
	Verb(String inputName, String[] inputFormat){
		name = inputName;
		format = inputFormat;
		allVerbs.add(this);
	}
	
	public static void findAndExecuteAction(Item[] items, Character[] characters, String[] verbStrings){
		boolean flag = false;
		for(Verb toExecute : allVerbs){
			if(!flag && Arrays.deepEquals(toExecute.format, verbStrings)){
				toExecute.action(items, characters);
				flag = true;
			}
		}
		if(!flag){
			System.out.println("That didn't quite make sense.");
		}
	}
	
	public void action(Item[] items, Character[] characters){} //this is a crappy solution

	public static class take extends Verb {
		take(String inputName, String[] inputFormat) {
			super(inputName, inputFormat);
		}

		public String name = "take", format[] = {"take",null}; // a central method would replace any (Item)s and do something with it to make it work, something would look for items in those (Item) slots
		
		public void action(Item[] items, Character[] characters) {
			if(items[1].location == PlayerInfo.playerRoom && items[1].visible && items[1].pickupAble){
				PlayerInfo.inventory.add(items[1]);
				PlayerInfo.playerRoom.items.remove(items[1]);
				System.out.println("You take the " + items[1].itemName() + ".");
			}else
				System.out.println(items[1].cantPickUpMessage);
		}
	}
	
	public static class takeTwo extends Verb {
		takeTwo(String inputName, String[] inputFormat) {
			super(inputName, inputFormat);
		}

		public String name = "takeTwo", format[] = {"take",null,null}; // a central method would replace any (Item)s and do something with it to make it work, something would look for items in those (Item) slots
		
		public void action(Item[] items, Character[] characters) {
			if(items[1].location == PlayerInfo.playerRoom && items[1].visible && items[1].pickupAble){
				PlayerInfo.inventory.add(items[1]);
				PlayerInfo.playerRoom.items.remove(items[1]);
				System.out.println("You take the " + items[1].itemName() + ".");
			}else
				System.out.println(items[1].cantPickUpMessage);
		}
	}
	
	public static class drop extends Verb {
		drop(String inputName, String[] inputFormat) {
			super(inputName, inputFormat);
		}
		public String name = "take", format[] = {"take",null}; // a central method would replace any (Item)s and do something with it to make it work, something would look for items in those (Item) slots
		
		public void action(Item[] items, Character[] characters) {
			if(items[1].location == PlayerInfo.playerRoom && items[1].visible && items[1].pickupAble){
				PlayerInfo.inventory.add(items[1]);
				PlayerInfo.playerRoom.items.remove(items[1]);
				System.out.println("You take the " + items[1].itemName() + ".");
			}else
				System.out.println(items[1].cantPickUpMessage);
		}
	}
	
	public static class inventory extends Verb {
		inventory(String inputName, String[] inputFormat) {
			super(inputName, inputFormat);
		}

		public String name = "inventory", format[] = {"inventory"};
		
		public void action(Item[] items, Character[] characters){
			System.out.println("You're carrying..");
			try{
				PlayerInfo.inventory.get(0);
				for(Item trinket : PlayerInfo.inventory){
					if ((trinket.itemName[1].substring(0,1)).equalsIgnoreCase("a") || (trinket.itemName[1].substring(0,1)).equalsIgnoreCase("e") || (trinket.itemName[1].substring(0,1)).equalsIgnoreCase("i") || (trinket.itemName[1].substring(0,1)).equalsIgnoreCase("o") || (trinket.itemName[1].substring(0,1)).equalsIgnoreCase("u")){
						System.out.print("An ");
					}
					else{
						System.out.print("A ");
					}
					System.out.println(trinket.returnName());
				}
			}
			catch(Exception a){
				System.out.println("Nothing.");
			}
		}
	}
	
	public static class look extends Verb {
		look(String inputName, String[] inputFormat) {
			super(inputName, inputFormat);
		}

		public String name = "look", format[] = {null,"look"};
		
		public void action(Item[] items, Character[] characters){
			System.out.println(PlayerInfo.playerRoom.roomDesc);
		}
	}
	
	public static class examine extends Verb {
		examine(String inputName, String[] inputFormat) {
			super(inputName, inputFormat);
		}

		public String name = "examine", format[] = {"examine",null};
		
		public void action(Item[] items, Character[] characters) {
			if (((items[1].location == PlayerInfo.playerRoom) || (PlayerInfo.isItemOwned(items[1]))) && items[1].visible){
				if(!items[1].visible)
					items[1].visible = true;
				System.out.println(items[1].itemDescription);
			}
			else{
				System.out.println("You can't see anything like that.");
			}
		}
	}
	
	public static class north extends Verb {
		north(String inputName, String[] inputFormat) {
			super(inputName, inputFormat);
		}

		public String name = "north", format[] = {"north"};
		
		public void action(Item[] items, Character[] characters) {
			System.out.println("You can't see anything like that.");
		}
	}
	
	public static class south extends Verb {
		south(String inputName, String[] inputFormat) {
			super(inputName, inputFormat);
		}

		public String name = "south", format[] = {"south"};
		
		public void action(Item[] items, Character[] characters) {
			System.out.println("You can't see anything like that.");
		}
	}
	
	public static class east extends Verb {
		east(String inputName, String[] inputFormat) {
			super(inputName, inputFormat);
		}

		public String name = "east", format[] = {"east"};
		
		public void action(Item[] items, Character[] characters) {
			System.out.println("You can't see anything like that.");
		}
	}
	
	public static class west extends Verb {
		west(String inputName, String[] inputFormat) {
			super(inputName, inputFormat);
		}

		public String name = "west", format[] = {"west"};
		
		public void action(Item[] items, Character[] characters) {
			
			if(PlayerInfo.playerRoom.west != null ){
				if(!PlayerInfo.playerRoom.west.locked){
						if(PlayerInfo.playerRoom.west.room1 == PlayerInfo.playerRoom){
							System.out.println(PlayerInfo.playerRoom.west.exitRoom1);
							PlayerInfo.playerRoom = PlayerInfo.playerRoom.west.room2;
						}else{
							System.out.println(PlayerInfo.playerRoom.west.exitRoom2);
							PlayerInfo.playerRoom = PlayerInfo.playerRoom.west.room1;
						}
				}else
					System.out.println(PlayerInfo.playerRoom.west.lockedText);
			}else
				System.out.println("There is no exit to the west.");
		}
	}
	
	public static class help extends Verb {
		help(String inputName, String[] inputFormat) {
			super(inputName, inputFormat);
		}

		public String name = "help", format[] = {null, "help"};
		
		public void action(Item[] items, Character[] characters) {
			System.out.println("This is a text-based adventure, inspired by Infocom interactive fiction games.");
			System.out.println("You may perform actions by inputting verbs, or verbs followed by nouns.");
			System.out.println("For example; \"look\", \"inventory\", \"examine box\", \"take key\", etc.");
			System.out.println("Additionally, you may navigate between rooms using cardinal directions.");
			System.out.println("\"North\" can be inputted to travel through an exit to the north.");
			System.out.println();
			System.out.println("Have fun!");
			System.out.println();
			}
	}
	//TODO: change to work like close
	public static class open extends Verb {
		open(String inputName, String[] inputFormat) {
			super(inputName, inputFormat);
		}

		public String name = "open", format[] = {"open",null};
		
		public void action(Item[] items, Character[] characters) {
			if(items[1] == Item.getItem("box") && PlayerInfo.playerRoom == Base.startApartment){
				if(!(PlayerInfo.isItemOwned(Item.getItem("key","card")))){
					System.out.println("You open the box. Inside, a small key card rests at the bottom.");
					Item.getItem("key","card").visible = true;
					Item.getItem("key","card").pickupAble = true;
				}
				else{
					System.out.println("You open the box, but it is empty.");
				}
			}
		}
	}
	
	public static class close extends Verb {
		close(String inputName, String[] inputFormat) {
			super(inputName, inputFormat);
		}

		public String name = "close", format[] = {"close",null};
		
		public void action(Item[] items, Character[] characters) {
			if(items[1] == Item.getItem("box") && PlayerInfo.playerRoom == Base.startApartment){
				if(!Item.getItem("box").open){
					System.out.print("The box is already open.");
				}else{
					System.out.println("You close the box.");
					if(Item.getItem("box").heldItem == Item.getItem("key","card")){
						Item.getItem("key","card").visible = false;
						Item.getItem("key","card").pickupAble = false;
					}	
				}
			}
		}
	}
	
	public static class unlock extends Verb {
		unlock(String inputName, String[] inputFormat) {
			super(inputName, inputFormat);
		}
		
		public String name = "unlock", format[] = {"unlock",null,"with",null,null};
		
		public void action(Item[] items, Character[] characters) {
			if ((items[1] == Item.getItem("aptDoorObject")) && (items[4] == Item.getItem("key","card"))){
				System.out.println("You slip the key card into the slot of the electronic lock. A gentle electronic hum sounds for a moment, before being interrupted by\na click as the door is unlocked.");
				(Exit.getExit("apartmentInsideDoor")).changeLocked(false);
			}
		}
	}
}
