package Commands;


import logic.Game;


public class PrintModeCommand extends Command{

	String mode;
	private final static String commandSName = "p";
	private final static String commandName = "printmode";
	private final static String commandHelpText = "[P]rintMode: change print mode [Release|Debug].";
	
	public PrintModeCommand() {
		super(commandSName,commandName, commandHelpText);
	}
	
	public Command parse(String[] word) {
		if(word[0].equalsIgnoreCase(commandSName)
		   ||word[0].equalsIgnoreCase(commandName))
			return this;
		else
			return null;
	}

	@Override
	public boolean execute(Game game) {
		if (game.getPrintMode())
			game.setPrintMode(false);
		else {
			game.setPrintMode(true);
		}
		//controller.setPrintStateGame();
		return true;
	}

}
