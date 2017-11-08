
public abstract class Player {

	private String name;
	private static int wins = 0;
	private static int losses = 0;
	private static int ties = 0;
	private static int winsM = 0;
	private static int lossesM = 0;
	private static int tiesM = 0;

	public int getWinsM() {
		return winsM;
	}

	public void setWinsM(int winsM) {
		Player.winsM = winsM;
	}

	public int getLossesM() {
		return lossesM;
	}

	public void setLossesM(int lossesM) {
		Player.lossesM = lossesM;
	}

	public int getTiesM() {
		return tiesM;
	}

	public void setTiesM(int tiesM) {
		Player.tiesM = tiesM;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		Player.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		Player.losses = losses;
	}

	public int getTies() {
		return ties;
	}

	public void setTies(int ties) {
		Player.ties = ties;
	}

	public Player() {

	}

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void getResults(Roshambizzle play1, Roshambizzle play2) {
		if (play1 == play2) {
			System.out.println("\nThe force of your attack equals that of your opponent. The match is a draw.\n");
			ties++;
			return;
		} else if (play1 == Roshambizzle.ROCK && play2 == Roshambizzle.SCISSORS) {
			System.out.println("\nYour closed, stone like fist blows away your opponent's spread fingers.\n");
			wins++;
			return;
		} else if (play1 == Roshambizzle.SCISSORS && play2 == Roshambizzle.PAPER) {
			System.out.println("\nAs your sharp, spread fingers descend, they eviscerate your opponent's flat palm.\n");
			wins++;
			return;
		} else if (play1 == Roshambizzle.PAPER && play2 == Roshambizzle.ROCK) {
			System.out.println(
					"\nYour hand shoots forward like a net, catching your opponents hand in a trap. He is rendered helpless.\n");
			wins++;
			return;
		} else if (play1 == Roshambizzle.ROCK && play2 == Roshambizzle.PAPER) {
			System.out.println(
					"\nIt's a trap! Your opponent has caught your stone like fist with a swift paper attack!\n");
			losses++;
			return;
		} else if (play1 == Roshambizzle.SCISSORS && play2 == Roshambizzle.ROCK) {
			System.out.println("\nYour blade like hand was not a match for your opponent's brutal blow.\n");
			losses++;
			return;
		} else if (play1 == Roshambizzle.PAPER && play2 == Roshambizzle.SCISSORS) {
			System.out.println("\nYou lose your fingers in the grasp of you opponents scissor attack.\n");
			losses++;
			return;
		} else {
			return;
		}
	}

	public static void getMasterResults(Roshambizzle play1, Roshambizzle play2) {
		if (play1 == play2) {
			System.out.println(
					"\nYour attacks clash. The shockwave rattles your senses. You collect yourself and charge for another go...\n");
			tiesM++;
			return;
		} else if (play1 == Roshambizzle.ROCK && play2 == Roshambizzle.SCISSORS) {
			System.out.println("\nYou smash the Master's blade strike with a vicious rock!\n");
			winsM++;
			return;
		} else if (play1 == Roshambizzle.SCISSORS && play2 == Roshambizzle.PAPER) {
			System.out.println("\nYou see through the Master's trap and cut it in two!\n");
			winsM++;
			return;
		} else if (play1 == Roshambizzle.PAPER && play2 == Roshambizzle.ROCK) {
			System.out.println(
					"\nYour hand shoots forward like a net, catching the Master's hand in a trap. He is rendered helpless.\n");
			winsM++;
			return;
		} else if (play1 == Roshambizzle.ROCK && play2 == Roshambizzle.PAPER) {
			System.out.println(
					"\nYou've been wrapped! The Master has caught your stone like fist with one swift move!\n");
			lossesM++;
			return;
		} else if (play1 == Roshambizzle.SCISSORS && play2 == Roshambizzle.ROCK) {
			System.out.println("\nThe Master's fist-like-mountain dealt a devastating blow!\n");
			lossesM++;
			return;
		} else if (play1 == Roshambizzle.PAPER && play2 == Roshambizzle.SCISSORS) {
			System.out.println("\nYou lose your fingers in the Master's razor sharp grasp.\n");
			lossesM++;
			return;
		} else {
			return;
		}
	}

	public abstract Roshambizzle generateRoshambizzle();
}
