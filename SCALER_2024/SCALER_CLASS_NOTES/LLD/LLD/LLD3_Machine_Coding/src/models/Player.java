package models;

import java.util.Scanner;

public class Player {

    private int id;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    private Scanner scanner ;

    // ideally id should be created by backend but for simplicity we initialize the id
    // TODO
    public Player(int id, String name, Symbol symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
        scanner = new Scanner(System.in);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move createMove(Board board) {
        System.out.println("Please enter the row you want to make move");
        int row = scanner.nextInt();
        System.out.println("Please enter the column you want to make move");
        int column = scanner.nextInt();
        return new Move(new Cell(row,column),this);
    }
}
