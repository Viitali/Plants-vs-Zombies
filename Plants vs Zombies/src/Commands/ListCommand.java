package Commands;


import logic.Game;

public class ListCommand extends NoParamsCommand {

	
	private final static String commandSName="l";
	private final static String commandName = "List";
	private final static String commandHelpText = " Prints the list of available plants.";
	public ListCommand() {
		super(commandSName, commandName, commandHelpText);
	}
	@Override
	public boolean execute(Game game) {
		System.out.println(game.listOfPlants());
		//controller.setNoPrintGameState();
		return false;
	}

}
