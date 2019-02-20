package control;

import logic.Game;
import logic.Level;
import logic.Exceptions.CommandExecuteException;
import logic.Exceptions.CommandParseException;

import java.util.Scanner;
import Commands.Command;
import Commands.CommandParser;

public class Controller {
    private Game game;
    private Scanner in;
    boolean playerWins;
    boolean computerWin;
    Level level;
    int seed;
    /*
     preguntar
     1.- Como simplificar el load (viene mejor explicado en el game.write
     2.- Como restaurar el juego actual en caso de que load falle
     2.1-- guardar todo en un archivo creado por el programa
     2.2-- crear un save y load game interno que guarde el juego en una variable de tipo Game? (muchos loads igual petan el programa?) 
     */
    
    //subir el clone a plant y a zombie
    //subir el attack de zombie 
    
    
    /*
     * recuerda que un metodo que esta en la clase padre (para todos) si lo sobreescribes en la
     * clase hija el programa hará caso al metodo de la clase hija para esa hija concreta
     * mientras que el resto seguiran haciendo lo que dice la clase padre*/
    public Controller(Level level, int seed) {
        this.level=level;
        game = new Game(level,seed);
        in = new Scanner(System.in);
        playerWins=false;
        computerWin=false;
        this.seed=seed;
    }
   
    public void run()
    {
    
     while(!this.game.getEnd())
     {
      playerWins=game.userWon();
      computerWin=game.computerWon();
      game.draw();
      if( computerWin || playerWins)
      	game.setEnd(true);
      if(!this.game.getEnd())
      {
    	  Command command=null;
    	  try
    	  {
    		  System.out.print("Command > ");
    	       String[] words = in.nextLine().toLowerCase().trim().split("\\s+");
    	       command = CommandParser.parseCommand(words); 
    	  } catch (CommandParseException e)
    	  {
    		  System.out.println(e.getMessage());
    	  }
       if(command != null)
       {
    	   try //estan separados para que si salta un CommandParseException no aumente de ciclo el juego
    	   {
    		   game.setPrint(command.execute(game));
    	   } catch (CommandExecuteException e)
    	   {
    		   System.out.println(e.getMessage());
    	   }
       }
       else
        game.setPrint(false);
       
       if(!this.game.getEnd()&&game.getPrint())
        game.update();
       }
      }
     System.out.println("Game over");
     if(playerWins)
      System.out.println("Player wins!");
     else
      System.out.println("Zombie wins!");
     }
	public void setNoPrintGameState()
    {
     game.setPrint(false);
    }
    public void setPrintStateGame()
    {
     game.setPrint(true);
    }
}
