package Commands;

import logic.Game;
import logic.Exceptions.CommandExecuteException;
import logic.Exceptions.CommandParseException;
import logic.Factory.PlantFactory;

public class AddCommand extends Command {

	private int x,y;
	private String plant;
	private final static String commandSName = "a";
	private final static String commandName = "Add";
	private final static String commandHelpText = "<plant> <x> <y>: Adds a plant in position x, y.";
	
	public AddCommand() {
		super(commandSName, commandName, commandHelpText);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		if(PlantFactory.getPlant(plant)==null)
			throw new CommandExecuteException("La planta: "+plant+" no existe, escribe 'list' para ver la lista de plantas disponibles");
		
		return game.addPlant(PlantFactory.getPlant(plant), x,y);
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if(existantCommand(commandWords[0]))
		{
			if(commandWords.length==4)
			{
				plant = commandWords[1];
				x = Integer.parseInt(commandWords[2]);
				y = Integer.parseInt(commandWords[3]);
				if(x>=0 && x<Game.getLINES() && y>=0 && y<Game.getROWS()) {
					return this;
				}
				else
					throw new CommandParseException ("Posicion: ("+x+","+y+") fuera de rango, hay "+Game.getLINES() + " filas y "+Game.getROWS()+" columnas");
			
			}
			else
				throw new CommandParseException ("Error en los argumentos del Add, tiene el formato: Add <plant> <x> <y> ");
			}
		else
			return null;
		
	}
	
	

}
