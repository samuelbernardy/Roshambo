
public class DojoMaster extends Player {

	@Override
	public Roshambizzle generateRoshambizzle() {
		int hand = (int) (Math.random() * 3);
		switch (hand) {
		case 0:
			return Roshambizzle.ROCK;
		case 1:
			return Roshambizzle.PAPER;
		case 2:
			return Roshambizzle.SCISSORS;
		default:
			return Roshambizzle.ERROR;

		}
	}
}
