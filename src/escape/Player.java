package escape;

import java.util.Map;

public class Player {

	private Room currentRoom;
	private String focus;

	public Player() {

	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	public String getFocus() {
		return focus;
	}

	public void setFocus(String focus) {
		this.focus = focus;
	}

	public char[] getInventoryShortDescriptions() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Item> getInventory() {
		// TODO Auto-generated method stub
		return null;
	}

}
