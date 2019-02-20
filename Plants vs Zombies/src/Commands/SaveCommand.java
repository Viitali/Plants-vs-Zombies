package Commands;

import logic.Game;
import java.io.*;
import logic.Exceptions.CommandParseException;

public class SaveCommand extends Command {

	private String filename;
	private final static String commandSName = "s";
	private final static String commandName = "Save";
	private final static String commandHelpText = "Save or s <Filename.txt> : Save current game in a text file";
	
	
	public SaveCommand() {
		super(commandSName, commandName, commandHelpText);
	}


	@Override
	public boolean execute(Game game) {
		
		FileWriter fw=null;
		BufferedWriter bw=null;
		try
		{
			fw = new FileWriter("C:\\hlocal\\" + filename + ".txt");
			bw = new BufferedWriter(new FileWriter("C:\\hlocal\\" + filename + ".txt"));
			game.write(bw);
			System.out.println("Game successfully saved in file "+filename+". Use the load command to reload it");
			
		} catch(IOException e)
		{
			System.out.println("Error de E/S "+e);
		}
		finally
		{
			try
			{
				fw.close();
				bw.close();
			}
			catch (IOException e2)
			{
				e2.getStackTrace();
			}
		}
		return false;
	}
	public Command parse(String[] commandWords) throws CommandParseException {
		if(existantCommand(commandWords[0]))
			if(commandWords.length!=2)
				throw new CommandParseException("El commando "+commandName+" tiene un argumento (el nombre del fichero)");
			else
			{
				filename = commandWords[1];
				return this;
			}
		else
			return null;
	}
}
