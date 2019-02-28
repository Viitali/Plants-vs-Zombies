package logic.Printer;

import logic.Game;

public class DebugPrinter extends BoardPrinter{
 
	private static final int MAX_CASILLAS = 32;
	private final int CELLSIZE=20;
	private static int dimX=1;
	private static int dimY=MAX_CASILLAS;
	private Game game;
	
	public DebugPrinter(int dimX,int dimY,Game game) {
		super(dimX,dimY, game);
		this.game = game;
		printGame();
	}
	public void encodeGame() {
		int contador = 0;
		board = new String[dimX][dimY];
		for(int i=0;i<game.getPlantListSize();i++)
		{
			board[0][contador]=game.getPlant(i).debugString();
			contador++;
		}
		for(int j=0;j<game.getZombieListSize();j++)
		{
			board[0][contador]=game.getZombie(j).debugString();
			contador++;
		}
	}
	public String printGame() {
		encodeGame();
		return toString(CELLSIZE);
		
	}
}
