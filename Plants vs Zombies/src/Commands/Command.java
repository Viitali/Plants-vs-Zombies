package Commands;

import logic.Game;
import logic.Exceptions.CommandExecuteException;
import logic.Exceptions.CommandParseException;

public abstract class Command {
	protected String commandSName;
	protected String commandName;
	private String commandHelp;
	
	public Command(String commandSName,String commandName, String commandHelpText){
		this.commandSName = commandSName;
		this.commandName = commandName;
		this.commandHelp = commandHelpText;
		}


	public abstract boolean execute(Game game) throws CommandExecuteException;
	public abstract Command parse(String[] commandWords) throws CommandParseException;
	public String helpText(){return " " + commandName + ": " + commandHelp;}
	
	public boolean existantCommand(String word) {
		return (word.equalsIgnoreCase(commandSName)
				||word.equalsIgnoreCase(commandName));
	}
}