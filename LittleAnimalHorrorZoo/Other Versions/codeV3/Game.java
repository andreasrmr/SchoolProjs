public class Game {
	InputHandler input;
	Match match;

	public Game() {
		input = new InputHandler(System.in);
	}

	public void showMainMenu() {
		cls();
		System.out.println("1) START GAME");
		System.out.println("\n0) EXIT");

		switch(input.readInt()) {
			case 1:
				newMatch();
				System.out.println("Game ended.. Press [ENTER] to continue.");
				input.readString();
				break;
			case 0:
				return;
		}

		showMainMenu();
	}

	private void newMatch() {
		cls();
		match = new Match();
		match.startMatch();
	}

	public static void cls(){
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch(Exception e) {
			System.out.println("Screen could not be cleared!!");
			System.out.println(e);
		}
	}
}