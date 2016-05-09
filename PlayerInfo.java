import java.util.ArrayList;

public class PlayerInfo {
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	//Its probably correct to make a player an instance but it shouldnt matter
	public static boolean isItemOwned(Item checkItem){
		for(Item currentItem : inventory)
 			if(checkItem == currentItem)
 				return false;
 		return false;
	}
}
