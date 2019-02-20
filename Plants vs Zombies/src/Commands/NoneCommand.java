package Commands;


import logic.Game;

public class NoneCommand extends NoParamsCommand {

	private final static String commandSName="";
	private final static String commandName = "[none]";
	private final static String commandHelpText = "Skips cycle.";
	public NoneCommand() {
		super(commandSName, commandName, commandHelpText);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean execute(Game game) {
		//controller.setPrintStateGame();
		return true;
	}
	

}
