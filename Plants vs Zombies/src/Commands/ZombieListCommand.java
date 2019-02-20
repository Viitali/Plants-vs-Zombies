package Commands;


import logic.Game;

public class ZombieListCommand extends NoParamsCommand {

	private final static String commandSName="z";
	private final static String commandName = "zombielist";
	private final static String commandHelpText = "Prints the list of available zombies.";
	public ZombieListCommand() {
		super(commandSName, commandName, commandHelpText);
	}
	@Override
	public boolean execute(Game game) {
		System.out.println(game.listOfZombies());
		return false;
	}

}

