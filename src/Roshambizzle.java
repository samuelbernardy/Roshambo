
public enum Roshambizzle {

	ROCK, PAPER, SCISSORS, ERROR;

	public String toString() {
		switch (this) {
		case ROCK:
			return "rock";

		case PAPER:
			return "paper";			

		case SCISSORS:
			return "scissors";			

		default:
			return "error";
		}
	}
}
