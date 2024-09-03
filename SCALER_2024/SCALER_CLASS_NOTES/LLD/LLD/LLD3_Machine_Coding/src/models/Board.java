package models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int size;
    private List<List<Cell>> boardCell;

    public Board(int size) {
        this.size = size;
        this.boardCell = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            List<Cell> row = new ArrayList<>();
            for(int j = 0; j < size; j++) {
                Cell cell = new Cell(i, j);
                cell.setCellState(CellState.EMPTY);
                row.add(cell);
            }
            this.boardCell.add(row);
        }
    }
    public void printBoard(){
        for(List<Cell> row : this.boardCell){
            for(Cell cell : row){
                //give the responsibility of displaying cell to the cell class itself
                cell.displayCell();
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoardCell() {
        return boardCell;
    }

    public void setBoardCell(List<List<Cell>> board) {
        this.boardCell = board;
    }
}
