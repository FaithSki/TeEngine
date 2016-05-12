import java.util.ArrayList;


public class Game {
	
	// Am I understanding this correctly?
	
	public static ArrayList<Exit> exits = new ArrayList<Exit>();
	public static ArrayList<Item> items = new ArrayList<Item>();

	public Item meme;
	public Item spaghetti;
	public Item fettuccine;
	public Item blank;
	
	public Room dankDungeon;
	public Room pastaParlor;
	
	public Game(){
		// Start constructing all game objects 

		/*Item constructor takes, in this order: 
		 * Name (String)
		 * Description (String)
		 * Pickupable (boolean)
		 * Usable (boolean)
		 * Dropable (boolean)
		 * Visible (boolean)
		 * Possible Actions (String array)
		 * Cantpickupmessage (String) 
		 */
		Verb[] memeActions = {null};
		Item meme = new Item("Meme","An unusually shiny item.",true,false,true,true,memeActions,"You can't quite get a grip on it.");
		Verb[] spaghettiActions = {null};
		Item spaghetti = new Item("Bowl of spaghetti","A blue plastic bowl, filled to the brim with tasty pasta.",true,true,true,true,spaghettiActions,"It's bolted to the table!");
		Verb[] actions = {null};
		Item fettuccine = new Item("Fettuccine","delicious",true,true,true,true,actions,"It's too slippery!");
		Verb[] generalActions = {null};//take maybe should be on the item side and not the "general actions" side
		Item blank = new Item("","",false,false,false,false,generalActions,"");
		items.add(blank);
		/*Room constructor takes, in this order: 
		 * Name (String)
		 * Description (String)
		 * Short Description (String)
		 * Exits (ArrayList)
		 * Items (ArrayList)
		 */
		items.add(meme);
		Room dankDungeon = new Room("DUNGEON","A dark, dank expanse of cobbled stone, forming the room around you.","A dark cobblestone room.",items,exits);
		resetRoomArrayLists();
		items.add(spaghetti);
		Room pastaParlor = new Room("PASTA PARLOR","A quaint little Italian resturaunt. The tables are covered with red-and-white checkered tableclothes and stacked high with bowls of spaghetti, but no other patrons are visible.","An empty Italian resturaunt.",items,exits);
		// End constructing all game objects
	}
	
	public static void resetRoomArrayLists(){
		exits = new ArrayList<Exit>();
		items = new ArrayList<Item>();
	}
}
