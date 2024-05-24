package escape;

import java.util.HashMap;
import java.util.Map;

public class Room extends Description {
	private Map<String, Room> exits;
	private Map<String, Item> items;
	private Map<String, Room> blockExit;
	private Map<String, Block> blocks;

	Room(String name, String shortDesc, String longDesc) {
		super(name, shortDesc, longDesc);
		exits = new HashMap<>();
		items = new HashMap<>();
		blockExit = new HashMap<>();
		blocks = new HashMap<>();
	}

	public Map<String, Room> getExits() {
		return exits;
	}

	public void setExits(Map<String, Room> exits) {
		this.exits = exits;
	}

	public Map<String, Item> getItems() {
		return items;
	}

	public void setItems(Map<String, Item> items) {
		this.items = items;
	}

	public Map<String, Room> getBlockExit() {
		return blockExit;
	}

	public void setBlockExit(Map<String, Room> blockExit) {
		this.blockExit = blockExit;
	}

	public Room getBlockExits(String key) {
		return blockExit.get(key);
	}

	public void setBlockedExit(String name, Room exit) {
		blockExit.put(name, exit);
	}

	public Room getExit(String direction) {
		return exits.get(direction);
	}

	public void setExit(String direction, Room exit) {
		exits.put(direction, exit);
	}

	public Map<String, Block> getBlocks() {
		return blocks;
	}

	public void setBlocks(Map<String, Block> blocks) {
		this.blocks = blocks;
	}

	public void setItem(String name, Item item) {
		items.put(name, item);
	}

	public void setBlockExit(String name, Room exit) {
		blockExit.put(name, exit);

	}

	public Map<String, Room> getBlockedExits() {
		// TODO Auto-generated method stub
		return null;
	}

}
