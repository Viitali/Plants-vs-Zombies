package Commands;


import logic.Game;

public class HelpCommand extends NoParamsCommand {

	private final static String commandSName="h";
	private final static String commandName = "Help";
	private final static String commandHelpText = "Prints this help message.";
	public HelpCommand()
	{
		super(commandSName,commandName,commandHelpText);
	}
	@Override
	public boolean execute(Game game) {
		CommandParser.commandHelp();
		//controller.setNoPrintGameState();
		return false;
	}
	
	
}
