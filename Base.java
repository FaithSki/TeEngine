import java.util.ArrayList;
import java.util.Scanner;
public class Base {
	/*
	 *I feel that if we're going to have a game engine then we should have the engine, that interacts with another class containing the actual content of our game(items, rooms, verbs) 
	 */
	public static boolean itsHappening = true;
	public static Game mainSet = new Game();
	/*
	Hey look at me
			We should have a "game" class
			runGame will take an instance of that class in a parameter (or an extension of it) with all items, verbs, rooms, etc.
			it will stay in a variable so that it can be accessed for later use
			
			the game loop shouldn't have to be that complicated, It will output a starting sequence(if it has one) then ill evaluate the room then call checkInput with your input, the verbs will probably direct most of the action
	*/
	
	public static void runGame(){

		Scanner sc = new Scanner(System.in);
		System.out.println("You just woke up in an unfamiliar apartment in a bed that isn't yours, with no clue how you got here or how to leave.");
		System.out.println("Seems that it's up to you to find your way out. Type 'help' for information on how to play.  You can hear rain outside.");
		System.out.println();
		PlayerInfo.playerRoom = mainSet.pastaParlor;
		while (itsHappening = true){
			// maybe we should stop printing the roomname + roomdesc/shortdesc after your first "turn" in a room, until you change rooms
			// use the short description after every turn, "look" for long description
			System.out.println(PlayerInfo.playerRoom.roomName()); 
			// getting a null pointer exception here. I think that there's something wrong with how I did the Game class.
			// PlayerInfo.playerRoom references whatever room the player is currently in, I guess??
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
		/* What needs to go on here
		 * 1. get input
		 * 2. get verb from input
		 * 3. get noun from input
		 * 4. find Item from noun
		 * 5. now check through all the possible verbs for that noun
		 * 6. if it is a possible action, then do it
		 * We just need a proof of concept for the demo
		 */
				//input must be in order "verb noun" for now
				//we might want to find a more flexible way to get the input, maybe find the verb keyword FIRST and then find the relating nouns
				//each verb could have a specific format, maybe if it finds "eat" and "with" it will get the "eat with" verb in the "eat 'noun' with 'noun'" format, looking for words before and after with, including spaces
		
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
		 */
		boolean works = true;
		//TODO there are some big things wrong with the framework of the method(what does it do once it finds nouns and verbs, you cant put them both into an array) but the basic idea is that it goes through each item in the array and finds what it is
		//I have an idea ill write down later
		/*
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
		
		/*
		 *  I think i have to use ugly for loops to make this work 
		 *  
		 *  :(((((((((((((
		 *  
		 *  it will tell you that your stuff dont work in the verb method
		 */
		for(int i = 0;i <= separatedInput.length;i++){
			if(Item.isItem(separatedInput[i])){
				if(PlayerInfo.isItemOwned(Item.getItem(separatedInput[i]))){ // I will change it to not check if its in the inventory until verb, for things like take
					items[i] = Item.getItem(separatedInput[i]);
				}
			}else if(true){
				// this is gonna be the same as with items, but for exits. 
			}
		}	
		
		
			
		/*	
		Ignore for now, rewriting again
		 
		boolean doesNounExist = false;
		int space = input.indexOf(" "); 
		 
		if(space == -1){
			for(Item current : PlayerInfo.inventory)
				if(current.itemName == foundNoun){
					doesNounExist = true;
					if(current.isActionPossible(foundVerb)) // gotta get a verb
						Verb.findAction(foundVerb);
					else
						System.out.print("How will you manage that?");	
				}
			if(!doesNounExist)
				System.out.println("You can't see such an item.");
		}else
			System.out.println("That doesn't quite make sense.");
		*/
	}
	
	public static void main (String str[]) {
		//Scanner input = new Scanner(System.in);
		runGame();
		//checkInput(input.nextLine());
	}
}
