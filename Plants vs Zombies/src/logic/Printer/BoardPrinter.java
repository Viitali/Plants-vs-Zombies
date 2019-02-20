package logic.Printer;
import logic.Game;

public abstract class BoardPrinter implements GamePrinters {

	String[][] board;
	final String space = " ";
	private int dimX;
	private int dimY;
	
	Game game;
	
	public BoardPrinter(int dimX,int dimY,Game game){
	this.dimX = dimX;
	this.dimY = dimY;
	this.game = game;
	}
	public abstract void encodeGame();
	
	public String toString(int cellSize) {

        //int cellSize = 7;
        int marginSize = 2;
        String vDelimiter = "|";
        String hDelimiter = "-";

        String rowDelimiter = MyStringUtils.repeat(hDelimiter, (dimY * (cellSize + 1)) - 1);
        String margin = MyStringUtils.repeat(space, marginSize);
        String lineDelimiter = String.format("%n%s%s%n", margin + space, rowDelimiter);

        StringBuilder str = new StringBuilder();

        str.append(lineDelimiter);

        for(int i=0; i<dimX; i++) {
            str.append(margin).append(vDelimiter);
            for (int j=0; j<dimY; j++) {
                str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
            }
            str.append(lineDelimiter);
        }
        return str.toString();
    }
}
