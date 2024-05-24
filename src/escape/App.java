package escape;

import java.util.Map;
import java.util.Scanner;

public class App {
	private static boolean roomPrompt;

	public static void main(String[] args) {
		System.out.println("hello wlcome to my home \n" + "please enter the action to move to my home\n "
				+ "go or inspect,open\n" + "type wuit to quit");

		App app = new App();
		Player player = new Player();
		RoomManager rm = new RoomManager();
		Scanner sc = new Scanner(System.in);

		rm.init();
		player.setCurrentRoom(rm.startingRoom());
		gameLoop: while (true) {
			if (roomPrompt) {
				app.printRoom(player);
				roomPrompt = false;
			}

			// Collect input
			String[] command = app.collectInput(sc);

			// Check for quit keyword
			if (command[0].equals("quit")) {
				break gameLoop;
			}

			// Parse the input
			app.parse(command, player);
		}
		// Close up
		System.out.println("Goodbye.");
		sc.close();
	}

	public void printRoom(Player player) {
		Room cr = player.getCurrentRoom();

		String itemShortDescriptions = "";
		Map<String, Item> items = cr.getItems();
		for (Map.Entry<String, Item> entry : items.entrySet()) {

		}

		// Display room and items
		System.out.println(cr.getName() + "\n\n" + cr.getLongDesc() + "\n\n" + "Items:\n" + itemShortDescriptions);

		//
		if (!cr.getBlocks().isEmpty()) {
			// Check for uncleared
			boolean barrierHeading = false;
			for (Map.Entry<String, Block> entry : cr.getBlocks().entrySet()) {
				if (!entry.getValue().isCleared()) {
					// Add the Barriers: heading if it isn't there
					if (barrierHeading == false) {
						System.out.println("Barriers:");
						barrierHeading = true;
					}
					// Print block name and direction
					System.out.println(entry.getKey() + ": to the " + entry.getValue().getDirection() + " is "
							+ entry.getValue().getShortDesc() + "\n");
				}
			}
		}

		String exitShortDescriptions = "";
		Map<String, Room> exits = cr.getExits();
		for (Map.Entry<String, Room> entry : exits.entrySet()) {
			exitShortDescriptions += entry.getKey() + ": " + entry.getValue().getShortDesc() + "\n";
		}
		// Display exits
		System.out.println("Exits:\n" + exitShortDescriptions);

	}

//*
	public String[] collectInput(Scanner scanner) {
		String line = scanner.nextLine();
		String[] actionAndTarget = line.split("\\s+");
		return actionAndTarget;
	}

	public void parse(String[] command, Player player) {
		// Check for correct input
		if (command.length != 2) {
			System.out.println("Please only enter two words in lowercase:" + " an action and a target.\n");
			return;
		}

		// Define action word and target word from command
		String action = command[0];
		String target = command[1];

		// Define current room objects
		Room cr = player.getCurrentRoom();
		Map<String, Item> roomItems = cr.getItems();
		Map<String, Block> barriers = cr.getBlocks();
		Map<String, Room> exits = cr.getExits();
		Map<String, Room> blockedExits = cr.getBlockedExits();

		// Define player objects
		Map<String, Item> inventory = player.getInventory();
		String focus = player.getFocus();

		// Provide long description if command is inspect item in current room
		if (action.equals("inspect") && roomItems.containsKey(target)) {
			System.out.println(roomItems.get(target).getLongDesc() + "\n");
		}

		// Provide long description if command is inspect item in inventory
		else if (action.equals("inspect") && inventory.containsKey(target)) {
			System.out.println(inventory.get(target).getLongDesc() + "\n");
		}

		// Provide long description and set focus if command is inspect barrier in room
		else if (action.equals("inspect") && barriers.containsKey(target)) {
			if (barriers.get(target).isCleared()) {
				System.out.println(barriers.get(target).getClearedDescription() + "\n");
			} else {
				player.setFocus(target);
				System.out.println(barriers.get(target).getClearedDescription() + "\n");
			}
		}

		// Add to inventory if command is keep item and the item's action is keep
		else if (action.equals("keep") && roomItems.containsKey(target)
				&& roomItems.get(target).getAction().equals("keep")) {
			inventory.put(target, roomItems.get(target));
			roomItems.remove(target);
			System.out.println(inventory.get(target).getEffect() + "\n");
		}

		// Show inventory if the user inputs show inventory
		else if (action.equals("show") && target.equals("inventory")) {
			System.out.println(player.getInventoryShortDescriptions());
		}

		// Use a tool
		else if (action.equals("use") && inventory.containsKey(target)
				&& inventory.get(target).getUses().containsKey(focus)) {
			// Display using the tool
			System.out.println(inventory.get(target).getUse(focus) + "\n");
			// Clear the barrier if it's the correct tool
			if (barriers.get(focus).getCorrectTool().equals(target)) {
				barriers.get(focus).setCleared(true);
				String direction = barriers.get(focus).getDirection();
				Room exitToUnblock = blockedExits.get(direction);
				// Remove blocked exit
				blockedExits.remove(direction);
				// Add exit
				exits.put(direction, exitToUnblock);
				// Room prompt to see opened exit
				roomPrompt = true;
			}
		}

		// Provide effect if command is a correct action and item in room
		else if (roomItems.containsKey(target) && action.equals(roomItems.get(target).getAction())) {
			System.out.println(roomItems.get(target).getEffect() + "\n");
		}

		// Provide appropriate exit if command is go direction
		else if (action.equals("go") && cr.getExits().containsKey(target)) {
			roomPrompt = true;
			player.setCurrentRoom(exits.get(target));
		}

		// Any other case
		else {
			System.out.println("Do what now?\n");
		}

	}
}
