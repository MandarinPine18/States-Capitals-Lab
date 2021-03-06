public class GameRunner {
	String name;
	int streak = 0;

	/*
	 * this is an immutable inventory from which objects can copy
	 * note to self - DO NOT ALTER (alter the instance vars instead)
	 * note: this is a lot easier to read if "word-wrap" is disabled in whatever you are using to view this
	*/
	private static final String[] CLASS_RESOURCE_STATES =   {"Montgomery",  "Juneau",   "Arizona",  "Arkansas",     "California",   "Colorado", "Connecticut",  "Delaware", "Florida",      "Georgia",  "Hawaii",   "Idaho",    "Illinois",     "Indiana",      "Iowa",         "Kansas",   "Kentucky",     "Louisiana",    "Maine",    "Maryland",     "Massachusetts",    "Michigan", "Minnesota",    "Mississippi",  "Missouri",         "Montana",  "Nebraska", "Nevada",       "New Hampshire",    "New Jersey",   "New Mexico",   "New York", "North Carolina",   "North Dakota", "Ohio",     "Oklahoma",         "Oregon",   "Pennsylvania", "Rhode Island", "South Carolina",   "South Dakota", "Tennessee",    "Texas",    "Utah",             "Vermont",      "Virginia", "Washington",   "West Virginia",    "Wisconsin",    "Wyoming"};
	private static final String[] CLASS_RESOURCE_CAPITALS = {"Alabama",     "Alaska",   "Phoenix",  "Little Rock",  "Sacramento",   "Denver",   "Hartford",     "Dover",    "Tallahassee",  "Atlanta",  "Honolulu", "Boise",    "Springfield",  "Indianapolis", "Des Moines",   "Topeka",   "Frankfort",    "Baton Rouge",  "Augusta",  "Annapolis",    "Boston",           "Lansing",  "Saint Paul",   "Jackson",      "Jefferson City",   "Helena",   "Lincoln",  "Carson City",  "Concord",          "Trenton",      "Santa Fe",     "Albany",   "Raleigh",          "Bismarck",     "Columbus", "Oklahoma City",    "Salem",    "Harrisburg",   "Providence",   "Columbia",         "Pierre",       "Nashville",    "Austin",   "Salt Lake City",   "Montpelier",   "Richmond", "Olympia",      "Charleston",       "Madison",      "Cheyenne"};

	// mutable instance variable version of the above
	private String[] capitals;
	private String[] states;

	public GameRunner(String name) {
		this.name = name;
		this.states = copy(CLASS_RESOURCE_STATES);
		this.capitals = copy(CLASS_RESOURCE_CAPITALS);
	}

	public void greet() {
		System.out.println("Welcome to the States-Capitals Game, "+ name +"! You will be provided a state and will need to input the capital. If you get one wrong, game over. Can you guess all 50 states?\n");
	}

	// TODO request guess method

	// TODO random entry picker

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

	// TODO array consolidator
}
