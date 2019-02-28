package logic.Printer;

import logic.Game;

public class ReleasePrinter extends BoardPrinter{
	
	private int dimX;
	private int dimY;
	private final int CELLSIZE=7;
	
	public ReleasePrinter(int dimX,int dimY,Game game) {
		super(dimX,dimY,game);
		this.dimX = dimX;
		this.dimY = dimY;
		this.game = game;
		printGame();
	}
	public void encodeGame() {
		 board = new String[dimX][dimY];
	        for (int i = 0; i < dimX; i++) {
	            for (int j = 0; j < dimY; j++) {

	                if (game.isPlantInPosition(i, j))
	                    board[i][j] = game.plantToString(i, j);
	                else if (game.isZombieInPosition(i, j))
	                    board[i][j] = game.zombieToString(i, j);
	                else
	                    board[i][j] = space;
	            }
	        }
	}

	public String printGame() {
		encodeGame();
		return toString(CELLSIZE);
		
	}
}
