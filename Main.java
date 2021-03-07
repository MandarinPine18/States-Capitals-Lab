import java.util.*;

class Main {
	// This is the cheat code. Feel free to alter it before compiling the code.
	// true = in developer mode
	// false = in player mode
	public static final boolean DEVELOPER_MODE_ENABLED = true;

	// Common Scanner object for entire program
	public static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		// This is a test of the backend data management. This call and the method definition should be commented out
		// for the final version.

		if (DEVELOPER_MODE_ENABLED)
			GameRunner.test();


		// request name
		String name = input("Enter your name: ");
		System.out.println();

		// make the game
		GameRunner game = new GameRunner(name);

		while(game.doGuess());  // empty while loop with method condition is more straightforward for repetition here
	}

	// simplified input system
	public static String input(String prompt) {
		System.out.print(prompt);
		return input.nextLine();
	}
}