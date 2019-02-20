package Commands;

import logic.Game;
import logic.Exceptions.CommandExecuteException;
import logic.Exceptions.CommandParseException;

public class DeleteCommand extends Command {

	private final static String commandSName="d";
	private final static String commandName = "Delete";
	private final static String commandHelpText = "Delete a plant returning 25 suncoins";
	int x,y;
	
	public DeleteCommand() {
		super(commandSName, commandName, commandHelpText);
		
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		game.delete(x, y);
		return true;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if(existantCommand(commandWords[0]))
		{
			if(commandWords.length==3)
			{
				x=Integer.parseInt(commandWords[1]);
				y=Integer.parseInt(commandWords[2]);
				if(x>=0 && x<Game.getLINES() && y>=0 && y<Game.getROWS()) {
					return this;
				}
				else
					throw new CommandParseException ("Posicion: ("+x+","+y+") fuera de rango, hay "+Game.getLINES() + " filas y "+Game.getROWS()+" columnas");
			}
			else
				throw new CommandParseException ("Error en los argumentos del Delete, tiene el formato: d <x> <y> ");
		}
		return null;
	}

}
