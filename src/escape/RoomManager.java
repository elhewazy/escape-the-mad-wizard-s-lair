package escape;

public class RoomManager {
	private Room startingRoom;
	private Room[] rooms;

	public RoomManager() {
		rooms = new Room[5];
	}

	public void init() {
		ItemManager im = new ItemManager();
		im.init();
		BlockManager bm = new BlockManager();
		bm.init();
		Room livingRoom = new Room("living room ", "a spacius living room",
				"has furniture , TV\n " + "to north is the kitchen and dinnig room. \n" + "to South is hallway"

		);
		livingRoom.setItem("dog", im.getItem("dog"));
		livingRoom.setItem("machete", im.getItem("machete"));

		Room KitchenAndDiningRoom = new Room("Kitchen and dinning room", "Kitchen and dinning room area",
				"to the south is a living room");
		KitchenAndDiningRoom.setItem("Fridge", im.getItem("Fridge"));
		KitchenAndDiningRoom.setItem("key", im.getItem("key"));

		Room hallWay = new Room("hallWay", "hallWay to four rooms", "only one door\n" + "on the wall there thermostat");
		hallWay.setItem("", null);
		hallWay.setItem("", null);
		Room bedroom = new Room("Bedroom", "a cluttered bedroom",
				"The bedroom looks like a tornado has gone through it.\n"
						+ "It is obviously the most used room in the house.\n" + "In the corner is a computer desk.\n"
						+ "To the east is a hallway.");
//		bedroom.setItem("desk", im.getItem("desk"));

		// Setting room exits and blocked exits
		livingRoom.setExit("north", KitchenAndDiningRoom);
		livingRoom.setExit("south", hallWay);

		KitchenAndDiningRoom.setExit("south", livingRoom);

		hallWay.setExit("north", livingRoom);
		hallWay.setBlockedExit("west", bedroom);

		bedroom.setExit("east", hallWay);

		// Setting rooms array and defining starting room
		rooms[0] = livingRoom;
		rooms[1] = KitchenAndDiningRoom;
		rooms[2] = hallWay;
		rooms[3] = bedroom;
		this.startingRoom = livingRoom;
	}

	public Room startingRoom() {
		return startingRoom;
	}

	public Room[] getRooms() {
		return rooms;
	}

}
