package escape;

import java.util.HashMap;
import java.util.Map;

public class BlockManager {

	private Map<String, Block> block;

	BlockManager() {
		block = new HashMap<>();
	}

	public void init() {
		Block door = new Block("door", "a door with a lock", "a door in front of you", "the plywood door i snow open",
				"west", "key");
	}

	public Block getItem(String key) {
		return block.get(key);
	}
}
