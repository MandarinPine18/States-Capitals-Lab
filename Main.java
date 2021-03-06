import java.util.*;

class Main {
	public static final Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		String name = input("Enter your name: ");
		System.out.println();

		GameRunner game = new GameRunner(name);

		game.greet();
		// TODO enter game
	}

	public static String input(String prompt) {
		System.out.print(prompt);
		return input.nextLine();
	}
}