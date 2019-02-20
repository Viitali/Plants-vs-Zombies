package Commands;


import logic.Game;

public class ExitCommand extends NoParamsCommand {

	private final static String commandSName="e";
	private final static String commandName = "exit";
	private final static String commandHelpText = "Terminates the program.";
	public ExitCommand()
	{
		super(commandSName,commandName,commandHelpText);
	}
	public boolean execute(Game game) {
		game.setEnd(true);
		return false;
	}

}
