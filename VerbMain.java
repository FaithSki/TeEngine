public class VerbMain {//this is how I think the verb class should be made, Im not sure if they should be public(call from everywhere) or private(call from a central method on the Verb class

	public static String allVerbs[];
	
	public static Verb findVerb(String inputVerb){
		// <code to find verb>
		
		return new Verb.look();
	}
	
	private static void constructVerbList(){
		allVerbs[0] = "look";allVerbs[1] = "examine";allVerbs[2] = "take";
		// is this how you want to handle the allVerbs and allItems arrays?
	}
}
