package Commands;

import logic.Exceptions.CommandParseException;

public abstract class NoParamsCommand extends Command{

	public NoParamsCommand(String commandSName,String commandName, String commandHelpText) {
		super(commandSName,commandName, commandHelpText);
	}
	
	public Command parse(String[] word) throws CommandParseException {
		if(existantCommand(word[0]))
			if(word.length!=1)
				throw new CommandParseException("El commando "+commandName+" no tiene argumentos");
			else
				return this;
		else
			return null;
	}

}
