package Commands;

import Commands.Command;
import logic.Exceptions.CommandParseException;


public class CommandParser {
	private static Command[] availableCommands = {
			new AddCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new ListCommand(),
			new ZombieListCommand(),
			new PrintModeCommand(),
			new NoneCommand(),
			new SaveCommand(),
			new LoadCommand(),
			new UndoCommand(),
			new DeleteCommand(),
			};

	public static Command parseCommand(String[] words) throws CommandParseException{
	for(Command c : availableCommands) {
		Command com = c.parse(words);
		if(com!=null)
			return com;
	}
		throw new CommandParseException ("Commando inexistente");
	}
	public static String commandHelp()
	{
		String helpText = null;
		for(Command c: availableCommands) {
			helpText = c.helpText();
			 System.out.println(helpText);
		}
		return helpText;
	}

}
