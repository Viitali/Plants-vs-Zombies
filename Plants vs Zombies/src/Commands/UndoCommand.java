package Commands;

import logic.Game;
import logic.Exceptions.CommandExecuteException;

public class UndoCommand extends NoParamsCommand{

	private final static String commandSName = "ud";
	private final static String commandName = "Undo";
	private final static String commandHelpText = "Undo the last movement";
	public UndoCommand() {
		super(commandSName, commandName, commandHelpText);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		
		return game.undo();
	}

}
