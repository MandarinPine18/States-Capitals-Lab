import java.util.*;

class Main {
	// TODO add developer mode
	public static final boolean DEVELOPER_MODE_ENABLED = false;

	public static final Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		String name = input("Enter your name: ");
		System.out.println();

		GameRunner game = new GameRunner(name);

		while(game.doGuess());  // empty while loop with method condition is much more straightforward
	}

	public static String input(String prompt) {
		System.out.print(prompt);
		return input.nextLine();
	}
}