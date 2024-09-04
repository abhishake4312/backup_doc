package strategies.winningStrategy;

import models.Board;
import models.Move;
import models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy {

    Map<Symbol,Integer> mainDiagonal=new HashMap<Symbol,Integer>();
    Map<Symbol,Integer> antiDiagonal=new HashMap<Symbol,Integer>();
    @Override
    public boolean checkWinner(Move move, Board board) {
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        Symbol symbol=move.getPlayer().getSymbol();
        if(row==col){
            int count=mainDiagonal.getOrDefault(symbol,0);
            mainDiagonal.put(symbol,count+1);
            if(mainDiagonal.get(symbol)== board.getSize()){
                return true;
            }
            return false;
        }
        if (row+col== board.getSize()-1){
            int count=antiDiagonal.getOrDefault(symbol,0);
            antiDiagonal.put(symbol,count+1);
            if(antiDiagonal.get(symbol)== board.getSize()){
                return true;
            }
            return false;
        }
        return false;
    }
    public void handleUndo(Move move, Board board) {
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        Symbol symbol=move.getPlayer().getSymbol();
        if(row==col){
            int count=mainDiagonal.get(symbol);
            mainDiagonal.put(symbol,count-1);
        }
        if (row+col== board.getSize()-1){
            int count=antiDiagonal.get(symbol);
            antiDiagonal.put(symbol,count-1);
        }
    }
}
