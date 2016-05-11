public class VerbMain {//this is how I think the verb class should be made, Im not sure if they should be public(call from everywhere) or private(call from a central method on the Verb class

	public static String allVerbs[];
	
	public static Verb findVerb(String inputVerb){
		// <code to find verb>
		
		return new Verb.look();
	}
	
	private static void constructVerbList(){
		allVerbs[0] = "look";allVerbs[1] = "examine";allVerbs[2] = "take";
		// is this how you want to handle the allVerbs and allItems arrays?
		
		// sorta, verb method will have base verbs and then the "game" class will have most of the verbs specific to the game
		// in an initialization method the game will have add all of the verbs to an array's list that has the base verbs already there, added before the game verbs in the same method or at some other time, but yeah
		// bit should be an arraylist so it can scale with any number of verbs
		
		//and what is this class for
	}
}
