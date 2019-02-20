package plantsVsZombies;

import control.Controller;
import logic.Level;
import logic.Exceptions.ArgsException;


public class Main {


    public static void main(String[] args) {
    	try
    	{
    		Controller controller;// meter aqui el level y pasar parametros a secas
    		Level level = Level.parse(args[0]);
    		if(args.length == 1)
        		 controller = new Controller(level,0);
        	else if (args.length==2)
        	{
        		int seed = Integer.parseInt(args[1]);
        		controller = new Controller(level,seed);
        	}
        	else 
        		throw new ArgsException ("Wrong arguments: plantsVsZombies <EASY|HARD|INSANE> [seed]");
    		controller.run();
    	}catch (ArgsException | NumberFormatException e)
    	{
    		System.out.println(e.getMessage());
    	}
    	
    }

}
