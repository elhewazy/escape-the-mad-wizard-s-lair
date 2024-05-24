package escape;

public class Block extends Description {
	private String cleareDesc;
	private String correctTool;

	private String direction;
	private boolean cleared;

	Block(String name, String shortDesc, String longDesc, String cleareDesc, String correctTool,

			String direction) {
		super(name, shortDesc, longDesc);
		this.cleareDesc = cleareDesc;
		this.correctTool = correctTool;
		this.direction = direction;
		cleared = false;

	}

	public String getCleareDesc() {
		return cleareDesc;
	}

	public void setCleareDesc(String cleareDesc) {
		this.cleareDesc = cleareDesc;
	}

	public String getCorrectTool() {
		return correctTool;
	}

	public void setCorrectTool(String correctTool) {
		this.correctTool = correctTool;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public boolean isCleared() {
		return cleared;
	}

	public void setCleared(boolean cleared) {
		this.cleared = cleared;
	}

	public String getClearedDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
