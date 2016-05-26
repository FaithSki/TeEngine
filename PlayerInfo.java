import java.util.ArrayList;
import java.util.Arrays;

public class PlayerInfo {
	public static Room playerRoom;
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	//Its probably correct to make a player an instance but it shouldnt matter
	public static boolean isItemOwned(Item checkItem){
		for(Item currentItem : inventory)
 			if(Arrays.deepEquals(checkItem.itemName,currentItem.itemName))
 				return true;
 		return false;
	}
}
