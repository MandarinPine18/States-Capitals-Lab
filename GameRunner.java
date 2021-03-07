public class GameRunner extends Main {  // I made it a subclass to get easy access to my input system and dev mode
	/*
	 * this is an immutable inventory from which objects can copy
	 * note to self - DO NOT ALTER (alter the instance vars instead)
	 * note: this is a lot easier to read if "word-wrap" is disabled in whatever you are using to view this
	*/
	private static final String[] CLASS_RESOURCE_STATES =   {"Alabama",     "Alaska",   "Arizona",  "Arkansas",     "California",   "Colorado", "Connecticut",  "Delaware", "Florida",      "Georgia",  "Hawaii",   "Idaho",    "Illinois",     "Indiana",      "Iowa",         "Kansas",   "Kentucky",     "Louisiana",    "Maine",    "Maryland",     "Massachusetts",    "Michigan", "Minnesota",    "Mississippi",  "Missouri",         "Montana",  "Nebraska", "Nevada",       "New Hampshire",    "New Jersey",   "New Mexico",   "New York", "North Carolina",   "North Dakota", "Ohio",     "Oklahoma",         "Oregon",   "Pennsylvania", "Rhode Island", "South Carolina",   "South Dakota", "Tennessee",    "Texas",    "Utah",             "Vermont",      "Virginia", "Washington",   "West Virginia",    "Wisconsin",    "Wyoming"};
	private static final String[] CLASS_RESOURCE_CAPITALS = {"Montgomery",  "Juneau",   "Phoenix",  "Little Rock",  "Sacramento",   "Denver",   "Hartford",     "Dover",    "Tallahassee",  "Atlanta",  "Honolulu", "Boise",    "Springfield",  "Indianapolis", "Des Moines",   "Topeka",   "Frankfort",    "Baton Rouge",  "Augusta",  "Annapolis",    "Boston",           "Lansing",  "Saint Paul",   "Jackson",      "Jefferson City",   "Helena",   "Lincoln",  "Carson City",  "Concord",          "Trenton",      "Santa Fe",     "Albany",   "Raleigh",          "Bismarck",     "Columbus", "Oklahoma City",    "Salem",    "Harrisburg",   "Providence",   "Columbia",         "Pierre",       "Nashville",    "Austin",   "Salt Lake City",   "Montpelier",   "Richmond", "Olympia",      "Charleston",       "Madison",      "Cheyenne"};

	// mutable instance variable versions of the above
	private String[] states;
	private String[] capitals;
	private int[] range = new int[2];    // this one is for optimization purposes - restricts the randomizer to non-null entries

	String name;
	int streak = 0;

	public GameRunner(String name) {
		this.name = name;
		greet();
		reset();
	}

	private void reset() {
		this.states = copy(CLASS_RESOURCE_STATES);
		this.capitals = copy(CLASS_RESOURCE_CAPITALS);
		updateRange();
		streak = 0;
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("Begin.");
	}

	public void greet() {
		System.out.println("Welcome to the States-Capitals Game, " + name + "! You will be provided a state and will need to input the capital. If you get one wrong, game over. Can you guess all 50 capitals?\n");
	}

	// public method which does one iteration of the game
	public boolean doGuess() {
		String[] entry = getRandomEntry();
		boolean correct;
		if (entry[0] != null) {
			System.out.println("State: " + entry[0]);
			if (DEVELOPER_MODE_ENABLED) {
				System.out.println("******** DEVMODE: Answer is " + entry[1] + " ********");
			}
			String guess = input("Capital(?): ");

			correct = guess.equalsIgnoreCase(entry[1]);
		} else {
			correct = false;
		}
		if (correct) {
			System.out.println("Correct!\n");
			streak++;
			return true;
		} else {
			System.out.println("GAME OVER\nCongratulations, you had a streak of " + streak + " correct answers.");
			// if the input rules I specified are not followed, it will just default to "no"
			if ("yes".equalsIgnoreCase(input("Would you like to play again? (yes/no): "))) {
				System.out.println();
				reset();
				return true;
			} else {
				System.out.println("Goodbye!");
				return false;
			}
		}
	}


	// gets a random state-capital combo in the format {state, capital}
	private String[] getRandomEntry() {
		// pick out an available index
		int min = range[0];
		int max = range[1];
		int index = (int)(Math.random() * (max-min+1))+min;

		// construct an array based on that choice
		String[] entry = {
				states[index],
				capitals[index]
		};

		// destroy that entry
		states[index] = null;
		capitals[index] = null;

		// clean up the mess the destruction left
		consolidate(states);
		consolidate(capitals);
		updateRange();

		// return the entry, which is the only remnant of the data beyond the class resource
		return entry;
	}

	// updates the range variable - to be used ONLY after consolidation
	private void updateRange() {
		int[] temp = new int[2];
		for(int i = 0; i < states.length; i++) {
			if (states[i] != null) {
				temp[1] = i;
			} else {
				break;
			}
		}
		range = temp;
	}

	/*
	 * While primitives have unchanging pointers to changing pieces of memory, object-typed variables simply change
	 * their pointer when needed. This allows me to solve the alias issue associated with that by manually creating a
	 * duplicate array.
	 */
	private static String[] copy(String[] arr) {
		String[] temp = new String[arr.length];
		for(int index = 0; index < arr.length-1; index++) {
			temp[index] = arr[index];
		}
		return temp;
	}

	// essentially shifts all the null indexes to the end of the array
	private static void consolidate(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				for(int j = i; j < arr.length; j++) {
					if (arr[j] != null) {
						arr[i] = arr[j];
						arr[j] = null;
						break;
					}
				}
			}
		}
	}

	// This is a method written to test out the backend functionality. It will not be executed in the final version.
	// If you want to run it, you will need to uncomment it here and at the method call in Main.main(String[] args)
	/*
	public static void test() throws Exception {
		System.out.println("************************************************BEGIN TEST************************************************");

		GameRunner test = new GameRunner("test");
		String[] allStates = new String[50];  // should contain no duplicates

		// randomly get and log the state part of entries
		for(int i = 0; i < allStates.length; i++){
			allStates[i] = test.getRandomEntry()[0];
		}

		// check for duplicates
		for(int i = 0; i < allStates.length-1; i++) {
			for (int j = i+1; j < allStates.length; j++) {
				if(allStates[i].equals(allStates[j])) {
					throw new Exception("Duplicate produced by randomizer");
				}
			}
		}

		// ensure all used entries were destroyed
		for(String val: test.states) {
			if (val != null) {
				throw new Exception("States array not emptied");
			}
		}

		for(String val: test.capitals) {
			if (val != null) {
				throw new Exception("Capitals array not emptied");
			}
		}

		// if we get this far without an error, things are working right
		System.out.println("System checked - backend data management functional");

		System.out.println("*************************************************END TEST*************************************************");
	}
	*/
}
