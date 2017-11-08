import java.util.Scanner;

public class User extends Player {
	
	String name;
	
	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Roshambizzle generateRoshambizzle() {
		Scanner scan = new Scanner(System.in);
		String hand = Validate.getChar(scan, "\nYour move, young sapien...(R, P, S)\n", "r", "p", "s");

		switch (hand) {
		case "r":
		case "R":
			return Roshambizzle.ROCK;
		case "p":
		case "P":
			return Roshambizzle.PAPER;
		case "s":
		case "S":
			return Roshambizzle.SCISSORS;
		default:
			return Roshambizzle.ERROR;

		}
	}

}
