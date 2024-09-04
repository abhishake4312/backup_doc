package models;

import Exceptions.BotCountException;
import Exceptions.PlayerCountException;
import strategies.winningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;

    private Board board;

    private List<Move> moves;

    private GameState gameState;

    private Player winner;

    private int nextMovePlayerIndex;

    public List<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    private List<WinningStrategy> winningStrategies;

    private Game(List<Player> players, List<WinningStrategy> winningStrategies) {
        this.players = players;
        this.winningStrategies = winningStrategies;
    }
    public Game(GameBuilder gameBuilder){
        this.players = gameBuilder.players;
        this.board=new Board(gameBuilder.dimension);
        this.moves=new ArrayList<>();
        this.gameState=GameState.IN_PROGRESS;
        this.nextMovePlayerIndex=0;
        this.winningStrategies = gameBuilder.winningStrategies;

    }
    public static GameBuilder getGameBuilder(){
        return new GameBuilder();
    }
    public static class GameBuilder {
        private List<Player> players;

        private int dimension;



        private List<WinningStrategy> winningStrategies;

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        //adding player one by one to List<Player>
        public GameBuilder setPlayer(Player player) {
            this.players.add(player);
            return this;
        }
        public GameBuilder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategies.add(winningStrategy);
            return this;
        }

        public GameBuilder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public GameBuilder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        //TODO add validation in seperate validation class
        private void botCountValidation() throws BotCountException {
            int botCount=0;

            for(Player p : players){
                if(p.getPlayerType().equals("Bot")){
                    botCount++;
                }
            }
            if(botCount>1){
                throw new BotCountException();
            }
        }
        private void uniqueSymbolValidation(){

        }
        private void playerCountValidation() throws PlayerCountException {
            if(players.size()!=dimension-1){
                throw new PlayerCountException();
            }
        }
        private void validation() throws BotCountException, PlayerCountException {
            botCountValidation();
            uniqueSymbolValidation();
            playerCountValidation();
        }
        public Game build() throws PlayerCountException, BotCountException {
            validation();
            return new Game(this);
        }
    }

    // TODO ideally all validation should be placed at seperate method
    private boolean validateMove(Move move){
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        if(row>=0 && row<board.getSize() && col>=0 && col<board.getSize() && board.getBoardCell().get(row).get(col).getCellState().equals(CellState.EMPTY)){
            return true;
        }
        return false;
    }
  public  void makeMove(){
        Player currentPlayer=this.getPlayers().get(nextMovePlayerIndex);
        System.out.println("It is "+currentPlayer.getName()+" 's move. Please make move.");
        //Till below we have not updated the board. Just Player has created a move. If move is valid it will go to the board
        Move move=currentPlayer.createMove(board);
        // Once a move is created by a player or a bot we need to validate the move and put it in the board.
        System.out.println(currentPlayer.getName()+" has made a move at row"+move.getCell().getRow()+" col"+move.getCell().getCol());

        if(!validateMove(move)){
            System.out.println("It is not possible to make a move. Please make a move.");
            return ;
        }
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        Cell boardCell= board.getBoardCell().get(row).get(col);
        boardCell.setPlayer(currentPlayer);
        boardCell.setCellState(CellState.FILLED);

        // Why we created a new move object cause the cell in the actualMove should be the cell of the board and not the cell
        // created by player or bot.
        Move actualMove=new Move(boardCell,currentPlayer);
        moves.add(actualMove);
        nextMovePlayerIndex=(nextMovePlayerIndex+1)%players.size();

        if(checkWinner(actualMove)){
            winner=currentPlayer;
            gameState=GameState.WIN;
        }
        if(moves.size()==board.getSize()*board.getSize()){
            gameState=GameState.DRAW;
        }
    }
    private boolean checkWinner(Move move){
         // Call winningStrategy of all strategies in the given list
        for(WinningStrategy winningStrategy : winningStrategies){
           if( winningStrategy.checkWinner(move,board)){
               return true;
           }
        }
        return false;
    }
    public void undo(){
       if(moves.size()==0){
           System.out.println("No moves to undo");
           return;
       }
       Move lastMove=moves.get(moves.size()-1);
       moves.remove(lastMove);

       Cell cell=lastMove.getCell();
       cell.setCellState(CellState.EMPTY);
       cell.setPlayer(null);

       for(WinningStrategy winningStrategy : winningStrategies){
           winningStrategy.handleUndo(lastMove,board);
       }
       nextMovePlayerIndex-=1;
       if(nextMovePlayerIndex<0){
           nextMovePlayerIndex=players.size()-1;
       }
    }

    public void printBoard(){
        board.printBoard();
    }
}
