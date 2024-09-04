package strategies.botPlayingStrategy;

import models.Board;
import models.Cell;
import models.CellState;
import models.Move;

import java.util.List;

public class EasyPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Move playingTheMove(Board board) {

        for(List<Cell> row: board.getBoardCell()){
            for(Cell c: row){
                if(c.getCellState().equals(CellState.EMPTY)){
                    Move move=new Move(c,null);
                    return move;
                }
            }
        }
        return null;
    }
}
