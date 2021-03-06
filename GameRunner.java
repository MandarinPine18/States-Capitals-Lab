public class GameRunner {
	String name;
	int streak = 0;

	// note: this is a lot easier to read if "word-wrap" is disabled in whatever you are using to view this
	private static final String[] capitals =    {"Montgomery",  "Juneau",   "Arizona",  "Arkansas",     "California",   "Colorado", "Connecticut",  "Delaware", "Florida",      "Georgia",  "Hawaii",   "Idaho",    "Illinois",     "Indiana",      "Iowa",         "Kansas",   "Kentucky",     "Louisiana",    "Maine",    "Maryland",     "Massachusetts",    "Michigan", "Minnesota",    "Mississippi",  "Missouri",         "Montana",  "Nebraska", "Nevada",       "New Hampshire",    "New Jersey",   "New Mexico",   "New York", "North Carolina",   "North Dakota", "Ohio",     "Oklahoma",         "Oregon",   "Pennsylvania", "Rhode Island", "South Carolina",   "South Dakota", "Tennessee",    "Texas",    "Utah",             "Vermont",      "Virginia", "Washington",   "West Virginia",    "Wisconsin",    "Wyoming"};
	private static final String[] states =      {"Alabama",     "Alaska",   "Phoenix",  "Little Rock",  "Sacramento",   "Denver",   "Hartford",     "Dover",    "Tallahassee",  "Atlanta",  "Honolulu", "Boise",    "Springfield",  "Indianapolis", "Des Moines",   "Topeka",   "Frankfort",    "Baton Rouge",  "Augusta",  "Annapolis",    "Boston",           "Lansing",  "Saint Paul",   "Jackson",      "Jefferson City",   "Helena",   "Lincoln",  "Carson City",  "Concord",          "Trenton",      "Santa Fe",     "Albany",   "Raleigh",          "Bismarck",     "Columbus", "Oklahoma City",    "Salem",    "Harrisburg",   "Providence",   "Columbia",         "Pierre",       "Nashville",    "Austin",   "Salt Lake City",   "Montpelier",   "Richmond", "Olympia",      "Charleston",       "Madison",      "Cheyenne"};

	public GameRunner(String name) {
		this.name = name;
	}

	// TODO greet method
	public void greet() {
		System.out.println("Welcome to the States-Capitals Game, "+ name +"! You will be provided a state and will need to input the capital. If you get one wrong, game over. Can you guess all 50 states?\n");
	}

	// TODO request guess method

	// TODO random entry picker

	// TODO array copier

	// TODO array consolidator
}
