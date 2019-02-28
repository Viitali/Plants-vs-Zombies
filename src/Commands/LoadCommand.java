package Commands;

import java.io.*;
import logic.Game;
import logic.Exceptions.ArgsException;
import logic.Exceptions.CommandParseException;

public class LoadCommand extends Command{

	private String filename;
	private final static String commandSName = "lo";
	private final static String commandName = "Load";
	private final static String commandHelpText = "Load or l <Filename.txt> : Import a saved game";
	
	private final static String CPEwrongArgs = "El commando "+commandName+" tiene un argumento (el nombre del fichero)";
	private final static String GameLoadedOk = "Game successfully loaded";
	
	public LoadCommand() {
		super(commandSName, commandName, commandHelpText);
	}
	public boolean execute(Game game) {
		BufferedReader br=null;
		try
		{
			br = new BufferedReader(new FileReader("C:\\hlocal\\" + filename + ".txt"));
			game.read(br);
			System.out.println(GameLoadedOk);
			
		} catch(IOException | NumberFormatException | ArgsException e)
		{
			System.out.println("Error de E/S "+e);
		}
		return true;
	}
	public Command parse(String[] commandWords) throws CommandParseException {
		if(existantCommand(commandWords[0]))
			if(commandWords.length!=2)
				throw new CommandParseException(CPEwrongArgs);
			else
			{
				filename = commandWords[1];
				return this;
			}
		else
			return null;
	}
}
