package Commands;


import logic.Game;

public class ResetCommand extends NoParamsCommand {

	private final static String commandSName="r";
	private final static String commandName = "Reset";
	private final static String commandHelpText = "Starts a new game.";
	public ResetCommand() {
		super(commandSName, commandName, commandHelpText);
	}
	public boolean execute(Game game) {
		
		game.newGame();
		return true;
	}

}
