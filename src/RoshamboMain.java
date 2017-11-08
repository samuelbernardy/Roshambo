
/**
 * @author sbernardy
 * 
 * A simple game of rock-paper-scissors with some added flare.
 * Enjoy!
 */
import java.util.Scanner;

public class RoshamboMain {
	public static void main(String[] args) {
		//init audio
		startApp();
		//print intro
		printBanner();

		Scanner scan = new Scanner(System.in);
		System.out.println("\n\n\n\nYou step into an elegantly decorated dojo. The Master approaches... 'What is your name, young sapien?'");
		Player user = new User(scan.nextLine());
		Player deAnte = new DeAnteSan();
		Player burger = new BurgerSan();
		Player master = new DojoMaster();

		System.out.println("I am told you are here to duel, young " + user.getName() + "-san.");

		System.out.println(
				"\n'My protege, DeAnte-san and Burger-san, are itching for new blood. Who will you battle... or will you leave?'\n");
		//choose opponent and play level one roshambo
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
						"\n'You will be disallowed entry the next time you show your face. Be gone with you.'\n");
				return;
			}

			if (user.getWins() == 5) {
				//print master intro
				printMaster();

				System.out.println(
						"\n'You have defeated my best, most... interesting students. But do you think you can defeat me?!'");
				//play master section roshambo
				while (true) {

					Player.getMasterResults(user.generateRoshambizzle(), master.generateRoshambizzle());
					//print score
					System.out.printf("%-20s %-20s\n", "Your Wins", "The Master's Wins");
					System.out.printf("%-20s %-20s\n", "=================", "=================");
					System.out.printf("%-20s %-20s\n", user.getWinsM(), user.getLossesM());

					if (user.getWinsM() == 5) {
						
						printWin();
						return;
					} else if (user.getLossesM() == 5) {
						
						printLoss();
						return;
					}

				}
			}
			//print score
			System.out.printf("%-15s %-15s %-15s\n", "Wins", "Losses", "Draws");
			System.out.printf("%-15s %-15s %-15s\n", "========", "========", "========");
			System.out.printf("%-15s %-15s %-15s\n", user.getWins(), user.getLosses(), user.getTies());
		}
	}
	
	private static void startApp() {
		String fileLocation = null;
		fileLocation = "/Users/sbernardy/eclipse-workspace/Roshambo/Music/Raiden3_Stage1V2.mid";
		AudioPlayerMaster audioPlayerMaster = new AudioPlayerMaster();
		audioPlayerMaster.setFileLocation(fileLocation);
		audioPlayerMaster.play();
	}

	private static void printLoss() {
		System.out.println(
				"  The Master takes a step back, watching you as you hunch over in exhaustion. With one swing forward, the Master strikes you down. The room spins, your vision blurs, the light fades... \n"
						+ ":::::::--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- \n"
						+ ":::--::-------------------------------------------------------------:/+:---------------------------------------------------------------------------------------------------------------- \n"
						+ "::-::-::--------------------:--------------------------------------+ydh/---------------------------------------------------------------------------------------------------------------- \n"
						+ "::------:--------------------------------------------------------:sddd+----------------------------------------------------------------------------------------------------------------- \n"
						+ "::::::------:----------------------------------------------------yddyo------------------------------------------------------------------------------------------------------------------ \n"
						+ "::::::-:--:----------::----------------------------------------:+mddh/----------------------------------------------------------------------------------------------------:------------- \n"
						+ ":::::::::-:------:---:-:--------------------------------------/ydmdhh+------------------------------------------------------------------------------------------:---:--::::-::::-::::::- \n"
						+ ":::::::::::--::::--::---------:--:---------------------------:dmddddhs--------------------------------------------------------------------------------:--::--::::::::::::::::::-:::::-:: \n"
						+ "::::::::::::::::--::::::::--:---::----:--------------------:+odmmdddddy+:--------------------------------------------------------------------------:-::::::::::::::::::::::::::::::-:::: \n"
						+ "::::::::::::::-::::::::::-:::---::::::---:-----------------+h+:ohdddmmmmd+---------------------------------------------------------------::--:-:::::::-::-:::::-:::::::::::::::::::::::: \n"
						+ "::::::::::::::::-:-::::::-::::::-::--:---------------------ydy:--:sdmmmmmds/-------------------------------------------------------:--::::::::::::::::::::::::::::::::::::::::::::::::::`\n"
						+ "::::::::::::::-:::::::::::::::::::::::::::::-:--::--------:hdhs:---/ymmmmmmmy+:-------------------------------------------------:::::-::::::::::::::::::::::::::::::::::::::::::::::::::`\n"
						+ "::::::::::::::::::::-::::::::::::::::::::::::::::::::-----:hdddy+:---odmmmmmmmds/:-------------------------------------:-:-:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::`\n"
						+ "::::::::::::::::::::::::::::::::::::::::::::::::::::---:--:sdddhhyo++/:ommmmmmmmmho:-----------------------------:--::::::::::::-:::::::::::::::::::::::::::::::::::::::::::::::::::::::`\n"
						+ "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::-/hdddddhdmmdsshmmmmmmmmmds:-----::------------:/:-:--::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::`\n"
						+ ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::ohhhhdddmmmmmmmmmmNNmmmmmmd:---:/s/--------:-:sho-:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::`\n"
						+ ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::+dmdddhdmmNNmNNmmmmmNNmmmmm+-::+y+/--:----:::-/++:-::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::`\n"
						+ "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::o++:-::/oymNmNNNNNNNmmmmmmo::::+y/-:::::::::::/so/::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::`\n"
						+ ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::/+sydmmmmmmmmmms:::::ys::::::::::::/yys::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::`\n"
						+ "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::mmmmmmy:::::/yo/::::::::::shys::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::`\n"
						+ ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::+mmmmmmh:::::smdy::::::::::hhhdo:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::`\n"
						+ ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::ymmmmmmh:::::+mdh/::::::::ohhyh+:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::`\n"
						+ "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::/mmmmmmmd:::::/mddy:::::::/hhhys:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::://:///////`\n"
						+ "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::ommmmmmmm:::::/mmdh+::::::ydddho::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::://///////////`\n"
						+ "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::ymmmmmmmd+::::/mmddy:::::/ddddho:::::::::::::::::::::::::::::::::::::://////////://///////////////////////`\n"
						+ "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::dmmmmmmmd+::::/mmddho::::yddhhy::::::::::::::::::::::::::::::::::/:::/:///////////////////////////////////`\n"
						+ ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::://:/mmmmmmmdhso:::/mmmdds:::omddddh/::/o/::::::::::::::::::::::://////////////////////////////////////////////`\n"
						+ ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::://///////smmmmmmmhhyshyo+mmdmdh//+dmddddh+::syso/://////////////////////////////////////////////////////////////////`\n"
						+ "::::////::::::::::::::::::::::::::::::::::::::::::::::::::::::::::///////////hmmmmmmmdhhhyhhhhhydmhy/yddddddh+::ohyyo///////////////////////////////////////////////////////////////////`\n"
						+ "::://///////:::/::/::::::://::::::::::::::::::::::::::::::://:///////////////hmmmmmmmmddhhhhddddddhhyddddddddo/oydhhho//////////////////////////////////////////////////////////////////`\n"
						+ "/::////////////////////////////////////:///:/:///////////////////////////////odmmmmmmmmhdddhdddmdmdmdddddddddy/osdmmms//////////////////////////////////////////++++++++++++++/+++++/+++`\n"
						+ "//////////////////////////////////////////////////////////////////////////////+ymmmmmmddmdddhhhdhdhdhdddmddddhyyhdmmh+////////////+++/+++++++++++++++++++++/++++++++++++++++++++++++++++`\n"
						+ "////////////////////////////////////////////////////////////////////////////////ohmmmddmmddddhhdhddddmddmmddddhdmdhy++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++`\n"
						+ "//////////////////////////////////////////////////////////////////////////////++++odhddddddddddddmmmdmdmmmmmmdhyso++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++`\n"
						+ "///////////////////////////////////////////////////////////////////////////++++++ohhsddddhdmddmmmmmmmmdmmmmmmho+++++++++++++++++++++++++o+++++++++++++++++++++++++++++++++++++++++++++++`\n"
						+ "//////////////////////////////////////////////////////////////////////////+++++++hdssddddmmdmmmmmmmmmmmmmmmmho++++++oo++++o++oooooooooooo+o++++oooooooooooooo+++++++++++++++++++++++++++`\n"
						+ "///////////////////////////////////////////////////////////////////+++++++++++++odhohddmmmmmmmmmmmmmmmmmmmdyoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo++++++++++++++++`\n"
						+ "///////////////////////////////////////////////////////////////++++++++++++++++sdhyhdmmmmmmmmmmmmmmmmmmdhsooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo+++++++o++ooooo`\n"
						+ "////////////////////////////////////////////////////////++//++++++++++++++++++sdmddmmmmmmmmmmmmmhhhhyssoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo++oooo+oooooooo`\n"
						+ "+//////////////////////////////////////////////////////+++++++++++++++++++++++oydddhysssssyyhdhsooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo+oooooooooooooo`\n"
						+ "++++++/////////////////////////////////////++++///////++++++++++++++++++++++++++osso+ooooooooooooooooooooooooooooooosssosoooosssssssssosssssoooooooooooooooooooooooooooooooooooooooooooo`\n"
						+ "+++++++++++++/++//++//////////////++++++++++++++++++++++++++++++++++++ooooo+o+ooooo+ooooooooooooooooooooooooooooosssssssssssssssssssssssssssssoooooooooooooooooooooooooooooooooooooooooo`\n"
						+ "                                                                                [ Thank you for playing ]                                                                                \n");
	}

	private static void printWin() {
		System.out.println(
				"          The Master's knees buckle. He takes a deep breathe and groans as his shadow shrinks and he falls to the floor. You have done it! You've become a master of Roshambo.           \n"
						+ "                                                                                                                                                                                         \n"
						+ "                                                                                                       ```       ````                                                                    \n"
						+ "                                                                                                    `..---.```.------.``                                                                 \n"
						+ "                                                                                             `````...-:::::-.-+//::::--.`                                                                \n"
						+ "                                                                                   ````````...---.-:///::/::--/+/:::::--..`                                                              \n"
						+ "                                                                                 ``....---...-::::--//////::--:/::------.-`                                                              \n"
						+ "                                                                                `....-:::+/-://////::::::::::::::----....-.`                                                             \n"
						+ "                                                                               `..---:://+o::/+++++:----::::///::::::-.`.-.                                                              \n"
						+ "                                                                             `..---:://///o+:/+++++////////:////////::-.`.`                                                              \n"
						+ "                                                                            `..--:--::////+s::/+//+oo+++++++++//+/o///:-.``                                                              \n"
						+ "                                                                            `.--:/---::://+o+//+++osydsoooooooooooo+o+/:-.`                                                              \n"
						+ "                                                                            `...-::-:::://+os++++++oydhyyyhsosyoo+++++/::-.`                                                             \n"
						+ "                                                                             ...--::/+++ooshho+++++symhs+/++////++/////::-..`                                                            \n"
						+ "                                                                            `....--::/+syyhhhysssssyyo/::--::::::/+//:::::-..`                                                           \n"
						+ "                                                                            `..-----://ooo+++osso+//::--------::::://:///::-.`                                                           \n"
						+ "                                                                            `..-----:/+o+/:::/++:------------:::///://////:.`                                                            \n"
						+ "                                                                             ...---:/++//:::::/-----------::::///////////-`                                                              \n"
						+ "                                                                             ....-://:::/::--::---------::://///+///:::-`                                                                \n"
						+ "                                                                              ...--:-:://:---:--:-----:::///++++++//-.`                                                                  \n"
						+ "                                                                              `..----:/:----:::::::::::///+++++++//-`                                                                    \n"
						+ "                                                                               `.---::::-::///:://://///++oooooo+:.                                                                      \n"
						+ "                                                                               `..-:::::://++///++++++++oooooo+/-`                                                                       \n"
						+ "                                                                                .--:+////////////+++ossssssoo+:.                                                                         \n"
						+ "                                                                                `--:++///////////++++ooooooo+:.                                                                          \n"
						+ "                                                                                 .--:/:::::::::///////++++///-`                                                                          \n"
						+ "                                                                                 `.-::::---:::::///::://///::-`                                                                          \n"
						+ "                                                                                 `.--::-----:::::/::--::::::-.`                                                                          \n"
						+ "                                                                                 `.--::------:-:::::--::::::--`                                                                          \n"
						+ "                                                                                 `.--:::----:---::::-.-:::::--.`                                                                         \n"
						+ "                                                                                 `.--:::-.--::--:::--.--------.`                                                                         \n"
						+ "                                                                                  ..-:::-..-::--:::--.-------..`                                                                         \n"
						+ "                                                                                 `..-::--..-:---::---..------..`                                                                         \n"
						+ "                                                                                 `..--:--..-----::--...----....`                                                                         \n"
						+ "                                                                                 `..----...-----::---..---.....``                                                                        \n"
						+ "                                                                                 `..----...-----::---...-......``                                                                        \n"
						+ "                                                                                 `...----.-----:::---...--.....``                                                                        \n"
						+ "                                                                                 `...---..------::---....-.....```                                                                       \n"
						+ "                                                                                 `...-..--------::----..---....```                                                                       \n"
						+ "                                                                                 `.....----.----:::---------....```                                                                      \n"
						+ "                                                                                 `......--------:::----------...```                                                                      \n"
						+ "                                                                                 `.........----::::----------....``                                                                      \n"
						+ "                                                                                 `.......-----:::::-----------....``                                                                     \n"
						+ "                                                                                [ Thank you for playing ]                                                                                \n");
	}

	private static void printMaster() {
		System.out.println(
				"Your opponents, DeAnte-san and Burger-san, lie before you - exhausted, depleted. A shadow is cast over you. You turn around...");
		String mastersGreeting = "                                                                                                                                                                                         \n"
				+ "                                                                                                                                                                                         \n"
				+ "                                                                                                                                                                                         \n"
				+ "                                                                                                                                                                                         \n"
				+ "                                                                                                                                                                                         \n"
				+ "                                                                                              ``..--:::::::/:-..`````                                                                    \n"
				+ "                                                                                          ``-/shdddmmmmmmmmmmmmddhyyo+:.`                                                                \n"
				+ "                                                                                        `:oydmmddmmmmmmNmNmNNNNmNNmNNmmhs/.`                                                             \n"
				+ "                                                                                      -+ydmmmmdmmmmmmmmmNNmNNmNmNNNNNNNNmmhs/`                                                           \n"
				+ "                                                                                    `/hmNmdddddddddddmmmmmmmmmmmNmNNNNNNNNmNmy:`                                                         \n"
				+ "                                                                                   `/dNmdsoosssso+++shhddhhhhdmmmmNNNNNNNmmNNNdo.                                                        \n"
				+ "                                                                                  `/hmdy+///////::::/++++++++oyhddmmmmmmNNmNNmNmo.                                                       \n"
				+ "                                                                                  :ymds+///:::::-----::://///++ossyhhddmmNNNmmNmd:                                                       \n"
				+ "                                                                                 .smmy+//////:-------:/:////++/+oossyhddmmmNNNNmms.                                                      \n"
				+ "                                                                                 :hmms///////:---::--://////++/+oosyyyhhdmmmNNNNmh-                                                      \n"
				+ "                                                                                `+dNdo/////:::---::-:///////+++oosyyyhhhdmmmmNNNNd/                                                      \n"
				+ "                                                                                .smmh+///:::::---:::://:///++oosyyyhhhhhdmmNNNNNNd/                                                      \n"
				+ "                                                                                :hmmh+///::-------/////////++ossyyyhddhhdmmNNmmNNd:                                                      \n"
				+ "                                                                               `+dmmh+/+sso+:...-:////+/:://++oosyyhddddmmmmNNNNNd/`                                                     \n"
				+ "                                                                               `ommdo/+syhhhhyo/://///:-..-/+++oyyhhdddmmNNNNNNNNm+`                                                     \n"
				+ "                                                                              `:ymms/+++/////ossooo+//:-:/shdddddddddddmmNNNNNNNNd/`                                                     \n"
				+ "                                                                              :yydh////::-..-:/osso+++++syyyysyhddddddddmNNNNNNNNd+`                                                     \n"
				+ "                                                                              /dyyy/::://+oossssyyo//oyhso+////+syhddddddmNNNNmmmmo.       ``.-:/:--.                                    \n"
				+ "                                                                             `/ds+s/--:/++osssyhhh+--+hhsyhyyysyhddddddddmNNNmmmNd/`    `.-----:os//s+`                                  \n"
				+ "                                                                              /ds/o+:--:::--:/+oo/-.`/ys///++++syhddhhhddmNNNmNmms-   .-::/:-../yhyshd:                                  \n"
				+ "                                                                             `/dy/++:----:-::+ss/.-.`:ss/:::://oshdhsshddmmmmNmmd/` `-//:--://oshhhyhh:                                  \n"
				+ "                                                                              -yo/++/:---:/++++:---``:shyooo+osyysoosyhddmmmmNmm+``-//::---/ossssyyyhh:                                  \n"
				+ "                                                                              `+s+///:::::-.-://:--`./ydys+/++////+shddddmmmmmdo.`-/:-:/+//+osssoooshy-                                  \n"
				+ "                                                                               -oo///:::---:+so/::-.:ohddy+:--://oyhdddddmmNmh/` -/::-:+o+/++ooooosshy.                                  \n"
				+ "     ``` ```   ``                                                              `-+//::::::/+so//::--ohhshh+::::/oydddddddmmNd+`  :+/////++//++ooosyyys`                                  \n"
				+ "   `````````  `--`                                                              ./////////+so:/o++oyddddmms://+oyddddddddmmy:`   ./++++++////++osyyhhs`                                  \n"
				+ " `` ````   `..---....                                                           `:/::////+so/:::::+oyddddhs+/+oyhddddddddmd:      -++///+++++++syhhyhs.                                  \n"
				+ "``````` ``.--.``  `-/.                                                         ``/s/:////so++++++oo+sssyssoosyhhddddddddmmo`      `./:://++++/+osyssyy/.                                 \n"
				+ "  ```````.-.``````./o:`                                                       `.``++:-:/:+syyssoossyhddhdddddddddddhhdddms`         -+++/++++//+ooooosso:`                               \n"
				+ "```````````  `.--://-..:`                                                    `-.  `-:--::++/::////+oyddddmmmdhddddhddddmo.         ``-sso+++//::/++oooooo+.                              \n"
				+ "````..`    ``.://-````.:/                                                   `--`    `-::///:--::+syhddhhdddddddddhdddmms...-:+oo+//oyhmdhyo+//:::/++//+ooso:`                            \n"
				+ "----.`    ``````....--/++`                                                `...       `-://+/:--::/+oyhhyyssyddddddddmmmdyhhhddmmddhhhmmmmhys+///:///://++oss+-`                          \n"
				+ "/+++:-```..`   `.-:/+oso-                                             ```--`           `-//++/:/++osyhyooyhddddddddddmddddddmmmmmmdyydddNmhsyyo//::::/+oo+osss+-`                        \n"
				+ ":/+ooo///o+/-..-+sssssy:                                  `......---..-:-`               .:+oo+ossyhhhhhhdddddddddmmmmdddmddddmmmmmdhdddmmdsoso+/:///++++++ooooso:`                      \n"
				+ "`-:/++++oyhs+//+shhhhyo`                             `-::--.```                            `:+syhhhhddddddddddmmmmmmmmhhhmmmmddddmmmddmdddds+++oo+////++++++++ooooo/.                    \n"
				+ "  .://+++oo++osddddddds`                      ``..---.``        ``                           `./yhddmmmmmmmmmmmmmmmmmdyhhhmmmmmmdddddhydhyy+////os+/::///+++++++oooss/.                  \n"
				+ "   ./++++oooosyhdddddh+`                     .-.`              `..                               ./sdmmmmmmmmdmmmmmmmyyddyhddmmmmdhhys+syyo:::----:///////++++/++++o++/-`                \n"
				+ "    -++ossoosyhhdddddy-                   ``.`  ``              .-`     `                           ./ymmmmmmmmmmmNmy+odhsshddddmdhs+//:/s/---.```.://///////++++++++o++/:.`             \n"
				+ "    `:/+ssyyhhhhdddmdo`             `..--::.`    `              `::`             ``                   `:sdmmmmmmmNmy//oyo:/shyssysso:.---//--.``````.-://////+++++++++++ooo+.            \n"
				+ "     .//+oosyyyhddddh/`      `.-::::/:.````       ``            `-/-              ``                    `-odmmmmmmd/.:/+/`./so/:://::.``../+.  ```..  .:///////++++++++++ooss:`          \n"
				+ "     `:/+ooosooyddmddo-`  `..`````               `````           `//`  ``            ``                   `-odddhdy-.:::. `-:/:.``.---. ``.:`  `..`   `-::////////++++oo++osyy+.         \n"
				+ "      -:/+ooo+oydddddhyyo/.``                    `````            .+:` `-`          .-`  `                  `-+yyy+.-:-.` `.--:.   `....` `-.  ..`    ``.:://::::///++oooooosyho-`       \n"
				+ "       -//+ooshdddddddhyddo-`                          `          `-+:``:.          -:    ``                  `-oo-.---.`  ..`.-.    ````` .:. ``       `-::::::::///++oooooosyhs/.`     \n"
				+ "       .:/o++sdddmmddhhyhmmy+:.`                       `.`         `/+-.:-          .:.                         `...--.`   .-``..`    ``..``-:`         `.-::::::::///++oysoosyyhy/.`    \n"
				+ "        `:+oyhdddddddhhhhdmds++/-`                     `-.`         -o+:::`         `--`                          ``...`   .-` ``.`   `..-. ./.         ```.-:::::////+++ossssyyhdh/.`   \n"
				+ "        `:+yhddddddddhddhdmmho++++-`                    `.`         `/s+//.          .:.                            `..`   .-``  ```  `..--` `          ``  .-::://////++ossyyyyhhmd/..  \n"
				+ "        `:+syhdddddhhdddddmmmy+++oo+:.                          `````:oo//-`         `--`                             ```  `..`   ``  `..--. ``     ``  `.`  `.:://///++++ssyyhhyhdmh-`. \n"
				+ "        -//ossyhdddhhddddmmmmho++++o++:.                        ```  ./+/+/-`         .:-`                             ``  `.``      ``..---``.`   ``   `-.    `-://+++ooossssyhhhhdms.`.\n"
				+ "       .-/+oooshhddddddddmmmmdo+/++++++/-`    `                  ``` `-//oo/.`        `-:.`                               `````      `...--/. `` `.:`   .+-      .-//+++oosssssyhhhhdd+``\n"
				+ "      `.-:/oooshhhhhhhhhhddmmh+////+++/++/-` `..               .:///:--:+syo:.         .::.                        `      ``.``      `...--+-  `` /h-   -s+`      `.:/+++ooossssyyyyhdy- \n"
				+ "     `.---:+oosyyyhhyyysyhhddy////++++/++++/-`.--`            ./oooooo+/+shy+-`        `-:-`                        ``      `..`     ``..--+/` `..sms`  -yy-        `.:++oooosssssssyhh/ \n"
				+ "     `-:://+/+syyyyyyyssssyyhy:://++++/////++/--/:.`         .:++oosyyo/+syyo:.         .::-`                        ```  `  `..    ```..--++. `-+hmd-  .sh+.         `.:ooosssssoooosy/`\n"
				+ "     .::://:///oyhyysssssoosso-:////++/////+oo/::++:`       .:++osyyhyo/+syhs+-`        `-::.                          ````   `.``  ```.---/o-  .sdmo:- .ohs:`  `       `.-/oysssooo+/s/`\n"
				+ "     -:::::::://+syyyyyysoooo+-:///++//++//+ooo+::+o/.`    .:/+syyhhys+/+oyhyo:`        `.-:-`                          `..`    ```````..--:o/` `ommoso.`/+.`  `..``  ```  ``-/+oo++//o- \n"
				+ "     -::-::::/+++++osyhhysooo/-/++++///++++ooooo/:/+o/.`  `-//syyhhhyo+/+syyys/.`     ```.---.`                          `..``   `..```..--:+o.  /dmhsy/`..`.:-.`..```````-.-oo//////:/.`\n"
				+ "     .:::::::/++++++osyhhhyys/-++/////+++++oo+++////o+-. `-//+yyyyyyso+++syhys+-```   ```...--`                            ...`   `-.```..--/o:` -ymdhys:``.-:::-``  `.:/+//shhssyyys++:`\n"
				+ "     .://:--:++++++++osyhdddy::+//////+++++++++/////++:..-://oyyyyyysoooosyyys+:.``` ````......`                            `..`  ``..```.--:o+. .sdddhhs/.---.``-...:sys+/osyyyhyso+o/. \n"
				+ "    `..://:-/+++++++++ooyhddo-:///////+++++++++/:///++/::://+syyyyyysosooyyso+/:----...........`                             `..`   `-.``.-::++-``ymhhhhyo-`.--.-.``./oso:/soooosso+/.`  \n"
				+ "     `..-::/++++++++o++ooyhh:-////////+++++++++//+o++++////+syyyyyyysyy++yso+syso+/:::::---.....``                            `..``  `-.`.-::/o/``yh:-ohyo/-..//-.`````.::/+ooo+++/.`    \n"
				+ "     ```.--:+++++++oo+oo+oyo-:///////////+++++///oooo++////+syyyyyyyyhy+/oooyhhsso++////::::----.``                             .-`  ``..`.::/o+. sd. `./oso+/++++o//:::://++o+:.`       \n"
				+ "      `````.://++++++++o+oo:-///://///+/////++///+oo+//////+oyyyyyyyysoo+osyyyyssoo+++++++/////::-.`                             .-.` `.--.-:/++- om-     ``...-::/:-.....--``           \n"
				+ "       ``   .:::/+++++++++/.:/::://///////+++++//+o++///+++++yhyssyssosssyyyyyysooo+++++++///////:-.`                             .-.`` `---:/++-`+d-                                    \n"
				+ "        ``   ```.:++++o+++--//:::///++/++/++++++++++///++++++sdysssssyyyyyyyyysooo+++++++/++////:-.`                               .-.````-:://+/`:h.                                    \n"
				+ "         `.`     `-/++++o:.//::///+oo++++++++oo+//////++++oooshsossyyyyyyyysssooooooo+oo++++/:-.`                         `         .-.```.:///++.:y.                                    \n"
				+ "           ..`     .---..-//:::::/++++o++/+ooo+//////++osyyyyyyssssyhyyyyssssosssssoooo++/:-.`                           ```         `-.`.`.://++--s`                                    \n"
				+ "            `.-..```.---:/:----::/+++++/:///:::://+/+/:--+ssyyysssyhhyssssyyysssssoo+//:--.``                            `````        `--...-:/++:-y.                                    \n";
		String[] masterGen = mastersGreeting.split("\n");
		for (String line : masterGen) {
			System.out.println(line);
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void printBanner() {
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
				+ "-------------------------------------   +                       +                         -                         +                          +    ------------------------------------\n"
				+ "------------------------------------- blood                     +                       GLORY                       +                        pain   ------------------------------------\n"
				+ "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
		String[] greetingGen = greeting.split("\n");
		for (String line : greetingGen) {
			System.out.println(line);
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
