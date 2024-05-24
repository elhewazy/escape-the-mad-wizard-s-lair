package escape;

public class Description {
	String name;
	String shortDesc;
	String longDesc;

	Description(String name, String shortDesc, String longDesc) {

		this.name = name;
		this.longDesc = longDesc;
		this.shortDesc = shortDesc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

}
