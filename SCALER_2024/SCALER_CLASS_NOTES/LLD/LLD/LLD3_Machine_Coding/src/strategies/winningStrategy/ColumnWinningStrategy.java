package strategies.winningStrategy;

import models.Board;
import models.Move;
import models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy {

    Map<Integer,Map<Symbol,Integer>> colMap=new HashMap<Integer,Map<Symbol,Integer>>();
    @Override
    public boolean checkWinner(Move move, Board board) {
        int col=move.getCell().getCol();
        Symbol symbol=move.getPlayer().getSymbol();
//        Map<Symbol,Integer> map;
//        if(!colMap.containsKey(col)){
//            map=colMap.get(col);
//        }else{
//            map=new HashMap<>();
//        }
//        if(map.containsKey(symbol)){
//            map.put(symbol,map.get(symbol)+1);
//        }else{
//            map.put(symbol,1);
//        }
//        if(map.get(symbol)== board.getSize()){
//            return true;
//        }
//        return false;
        Map<Symbol,Integer> map=colMap.getOrDefault(col,new HashMap<>());

        int count=map.getOrDefault(symbol,0);
        map.put(symbol,count+1);
        colMap.put(col,map);
        if(count== board.getSize()){
            return true;
        }
        return false;
    }
  public void handleUndo(Move move, Board board) {
        int row=move.getCell().getRow();
        Symbol symbol=move.getPlayer().getSymbol();
        Map<Symbol,Integer> map=colMap.get(row);
        int count=map.get(symbol);
        map.put(symbol,count-1);
        //  rowMap.put(row,map);

    }
}
