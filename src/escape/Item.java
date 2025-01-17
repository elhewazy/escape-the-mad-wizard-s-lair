package escape;

import java.util.HashMap;
import java.util.Map;

public class Item extends Description {
	private int interActionCount = 0;
	private String action;
	private String effectOne;
	private String effectTwo;
	private Map<String, String> uses;

	Item(String name, String shortDesc, String longDesc, String action, String effectOne, String effectTwo) {
		super(name, shortDesc, longDesc);
		this.action = action;
		this.effectOne = effectOne;
		this.effectTwo = effectTwo;
		uses = new HashMap<>();
	}

	public String getAction() {
		return action;
	}

	public String getEffect() {
		if (++interActionCount == 1) {
			return effectOne;
		} else {
			return effectTwo;
		}
	}

	public void putUse(String barrierName, String useDescription) {
		uses.put(barrierName, useDescription);
	}

	public Map<String, String> getUses() {
		return uses;
	}

	public String getUse(String barrierName) {
		return uses.get(barrierName);
	}
}
