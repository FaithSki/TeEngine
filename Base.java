import java.util.ArrayList;
import java.util.Scanner;
public class Base {
	/*
	 *I feel that if we're going to have a game engine then we should have the engine, that interacts with another class containing the actual content of our game(items, rooms, verbs) 
	 */
	public static boolean itsHappening = true;
	public static Game mainSet = new Game();
	/*
	holy gosh I didnt realize that the 5/17 due date was for seniors, ours is due on the 24th and we have a whole extra week than what I thought -_-
	  
	Hey look at me
	
	If you ever want multi-word items/exits or whatever it will be hard, so if you cant find a way around it then we can make special cases in Verb
	we could try having an array for multi word items/exits like {"cardboard","box"} or {"brown","door"}
	
			We should have a "game" class
			runGame will take an instance of that class in a parameter (or an extension of it) with all items, verbs, rooms, etc.
			it will stay in a variable so that it can be accessed for later use
			
			the game loop shouldn't have to be that complicated, It will output a starting sequence(if it has one) then ill evaluate the room then call checkInput with your input, the verbs will probably direct most of the action
	*/
	
	public static void runGame(){
		
		Game mainSet = new Game();

		Scanner sc = new Scanner(System.in);
		System.out.println("You just woke up in an unfamiliar apartment in a bed that isn't yours, with no clue how you got here or how to leave.");
		System.out.println("Seems that it's up to you to find your way out. Type 'help' for information on how to play.  You can hear rain outside.");
		System.out.println();
		PlayerInfo.playerRoom = mainSet.startApartment;
		while (itsHappening = true){
			System.out.println(PlayerInfo.playerRoom.roomName()); 
			// this keeps hitting a null pointer exception (!!!). we might need to just totally revert all of the Game class stuff, idkkkk.
			// I moved all of the Game constructor stuff into a method under Base and then i thought that i knew how to fix the null pointer
			// so i reverted all of my changes and whooops my fix didn't work.
			// i'm going to diiiieeee
			if (PlayerInfo.playerRoom.visited() == false){
				// visisted should stay true after the first visit, to prevent too much spam when you're trying to navigate your way across the "world."
				// the full description should be able to be brought up again with a "look" verb, and maybe in the future we can have an option to
				// choose whether you get shortdescriptions or the full description everytime (most infocom interactive fictions have something like that).
				System.out.println(PlayerInfo.playerRoom.roomDesc());
			}
			else{
				System.out.println(PlayerInfo.playerRoom.roomShortDesc());
			}
			System.out.print(">_ ");

			String input = sc.nextLine();
			PlayerInfo.playerRoom.visited = true;
			System.out.println();
			// at this point, we need to be able to detect a noun & a verb in the input. common verbs will be easy; "take" will just add a pickupable item
			// to an inventory arraylist; "drop" will add the item to the playerRoom's item arraylist; examine will print the itemdescription. I don't know
			// how we're going to handle the logic for unique interactions, like "use fork with spaghetti" or "screw in lightbulb."
			// "use <Item1> with <Item2>" will have to be a special case, and "screw in" can be a Verb associated with a lightbulb
			try{
				checkInput(input);
			}
			catch (Exception a){
				System.out.println("That doesn't quite make sense.");
			}
			System.out.println();
		}
	}	
	
	private static void checkInput(String input){
		/*
		 * What I was saying to do with this method
		 * 
		 * have arrays of strings
		 * 
		 * String[] format = {"use","(Item)","with","(Item)"};
		 * String[] separatedInput = {"use","memes","with","sauce"};
		 * 
		 * It will be easy to handle in this manner
		 * but will the engine handle
		 *
		 *
		 * ok my idea is that (this sucks if you want to have multi-word items)
		 * make 3 arrays
		 * Item[] inputItem = {null,meme,null,sauce};
		 * String[] inputVerb = {"use","(Item)","with","(Item)"}; any items or exits found in the separated input will be put as "(Item)" or "(Exit)"
		 * String[] inputExit = you get it by nown like inputItem
		 * 
		 * a method in the verb class will match input verb with the format, and then it will look for items in the same space 
		 * once it finds the verb it will pass the action the required items and/or exits or nothing(maybe have to be null?), in order
		 */
		
		
		String[] separatedInput = input.split(" ");
		Item[] items = new Item[separatedInput.length];
		String[] verbs = new String[separatedInput.length];
		Exit[] exits = new Exit[separatedInput.length];
		// this is annoying, to make multi-word things I'm using 2d arrays, really having to think of them as arrays of arrays
		Item[][] test = {{null}};
		
		/*
		 * What its gonna have to do is if it finds nothing with the name it will go to an alternate item method where it takes n and n+1
		 * 
		 *
		 *  I think i have to use ugly for loops to make this work 
		 *  :(((((((((((((
		 *  it will tell you that your stuff dont work or you cant see it in the verb method
		 */
		for(int i = 0;i <= separatedInput.length;i++){
			if(Item.isItem(separatedInput[i])){
				if(PlayerInfo.isItemOwned(Item.getItem(separatedInput[i]))){ // I will change it to not check if its in the inventory until verb, for things like take
					items[i] = Item.getItem(separatedInput[i]);
				}
			}else if(){
				// this is gonna be the same as with items, but for exits. 
			}
		}	
	}
	
	public static void main (String str[]) {
		//Scanner input = new Scanner(System.in);
		runGame();
		//checkInput(input.nextLine());
	}
}
