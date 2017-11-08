
/**
 * @author sbernardy
 * 
 * A simple game of rock-paper-scissors with some added flare.
 * Enjoy!
 */
import java.util.Scanner;

public class RoshamboMain {
	public static void main(String[] args) {
		String fileLocation = null;

		fileLocation = "/Users/sbernardy/eclipse-workspace/Roshambo/Music/ng1_2-2.mid";
		AudioPlayerMaster audioPlayerMaster = new AudioPlayerMaster();
		audioPlayerMaster.setFileLocation(fileLocation);
		audioPlayerMaster.play();
		String greeting = "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n"
				+ "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n"
				+ "RRRRRRRRRRRRRRRRR        OOOOOOOOO        SSSSSSSSSSSSSSS HHHHHHHHH     HHHHHHHHH               AAA               MMMMMMMM               MMMMMMMMBBBBBBBBBBBBBBBBB        OOOOOOOOO     \n"
				+ "R::::::::::::::::R     OO:::::::::OO    SS:::::::::::::::SH:::::::H     H:::::::H              A:::A              M:::::::M             M:::::::MB::::::::::::::::B     OO:::::::::OO   \n"
				+ "R::::::RRRRRR:::::R  OO:::::::::::::OO S:::::SSSSSS::::::SH:::::::H     H:::::::H             A:::::A             M::::::::M           M::::::::MB::::::BBBBBB:::::B  OO:::::::::::::OO \n"
				+ "RR:::::R     R:::::RO:::::::OOO:::::::OS:::::S     SSSSSSSHH::::::H     H::::::HH            A:::::::A            M:::::::::M         M:::::::::MBB:::::B     B:::::BO:::::::OOO:::::::O\n"
				+ "  R::::R     R:::::RO::::::O   O::::::OS:::::S              H:::::H     H:::::H             A:::::::::A           M::::::::::M       M::::::::::M  B::::B     B:::::BO::::::O   O::::::O\n"
				+ "  R::::R     R:::::RO:::::O     O:::::OS:::::S              H:::::H     H:::::H            A:::::A:::::A          M:::::::::::M     M:::::::::::M  B::::B     B:::::BO:::::O     O:::::O\n"
				+ "  R::::RRRRRR:::::R O:::::O     O:::::O S::::SSSS           H::::::HHHHH::::::H           A:::::A A:::::A         M:::::::M::::M   M::::M:::::::M  B::::BBBBBB:::::B O:::::O     O:::::O\n"
				+ "  R:::::::::::::RR  O:::::O     O:::::O  SS::::::SSSSS      H:::::::::::::::::H          A:::::A   A:::::A        M::::::M M::::M M::::M M::::::M  B:::::::::::::BB  O:::::O     O:::::O\n"
				+ "  R::::RRRRRR:::::R O:::::O     O:::::O    SSS::::::::SS    H:::::::::::::::::H         A:::::A     A:::::A       M::::::M  M::::M::::M  M::::::M  B::::BBBBBB:::::B O:::::O     O:::::O\n"
				+ "  R::::R     R:::::RO:::::O     O:::::O       SSSSSS::::S   H::::::HHHHH::::::H        A:::::AAAAAAAAA:::::A      M::::::M   M:::::::M   M::::::M  B::::B     B:::::BO:::::O     O:::::O\n"
				+ "  R::::R     R:::::RO:::::O     O:::::O            S:::::S  H:::::H     H:::::H       A:::::::::::::::::::::A     M::::::M    M:::::M    M::::::M  B::::B     B:::::BO:::::O     O:::::O\n"
				+ "  R::::R     R:::::RO::::::O   O::::::O            S:::::S  H:::::H     H:::::H      A:::::AAAAAAAAAAAAA:::::A    M::::::M     MMMMM     M::::::M  B::::B     B:::::BO::::::O   O::::::O\n"
				+ "RR:::::R     R:::::RO:::::::OOO:::::::OSSSSSSS     S:::::SHH::::::H     H::::::HH   A:::::A             A:::::A   M::::::M               M::::::MBB:::::BBBBBB::::::BO:::::::OOO:::::::O\n"
				+ "R::::::R     R:::::R OO:::::::::::::OO S::::::SSSSSS:::::SH:::::::H     H:::::::H  A:::::A               A:::::A  M::::::M               M::::::MB:::::::::::::::::B  OO:::::::::::::OO \n"
				+ "R::::::R     R:::::R   OO:::::::::OO   S:::::::::::::::SS H:::::::H     H:::::::H A:::::A                 A:::::A M::::::M               M::::::MB::::::::::::::::B     OO:::::::::OO   \n"
				+ "RRRRRRRR     RRRRRRR     OOOOOOOOO      SSSSSSSSSSSSSSS   HHHHHHHHH     HHHHHHHHHAAAAAAA                   AAAAAAAMMMMMMMM               MMMMMMMMBBBBBBBBBBBBBBBBB        OOOOOOOOO     \n"
				+ "                                                                                                                                                                                        \n"
				+ "------------------------------------- ROCK                      +                       PAPER                       +                      SCISSORS ------------------------------------\n"
				+ "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
		String[] greetingGen = greeting.split("\n");
		for (String line : greetingGen) {
			System.out.println(line);
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		Scanner scan = new Scanner(System.in);
		System.out.println("\n\n\n\nWelcome to my dojo. What is your name, young sapien?");
		Player user = new User(scan.nextLine());
		Player deAnte = new DeAnteSan();
		Player burger = new BurgerSan();
		int wins = 0;
		int losses = 0;
		int ties = 0;

		System.out.println("I am told you are here to duel, young " + user.getName() + "-san.");

		System.out.println(
				"\nMy protege, DeAnte-san and Burger-san, are itching for new blood. Who will you battle... or will you leave?\n");

		while (true) {
			String opposeChoice = Validate.getChar(scan,
					"\nChoose your opponent: D for deAnte-san / B for Burger-san / Q to Quit\n", "d", "b", "q");

			if ((opposeChoice.equals("d") || opposeChoice.equals("D"))) {

				System.out.println(
						"\nDeAnte-san pulls back his fist, holds it high above his head, and drops it to his open palm with a force that can be heard o'er the seas...\n");

				Player.getResults(user.generateRoshambizzle(), deAnte.generateRoshambizzle());

			} else if ((opposeChoice.equals("b") || opposeChoice.equals("B"))) {

				System.out.println(
						"\nBurger-san approaches in a somewhat lazy fashion, a glazed, confused look over his eyes. His arm raises, shaking, unstable...\n");

				Player.getResults(user.generateRoshambizzle(), burger.generateRoshambizzle());

			} else if ((opposeChoice.equals("q") || opposeChoice.equals("Q"))) {
				System.out.println(
						"\nYou will be disallowed entry the next time you show your face. Be gone with you.\n");
				return;
			}
			
			System.out.printf("%-15s %-15s %-15s\n", "Wins", "Losses", "Draws");
			System.out.printf("%-15s %-15s %-15s\n", "========", "========", "========");
			System.out.printf("%-15s %-15s %-15s\n", user.getWins(), user.getLosses(), user.getTies());
		}
	}
}
