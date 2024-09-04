package controller;

import Exceptions.BotCountException;
import Exceptions.PlayerCountException;
import models.*;
import strategies.winningStrategy.WinningStrategy;

import java.util.List;

public class GameController {

    // We need the Client or frontend application know about the PlayerCountException and BotCountException so that they create
    // the game in better way
    // But in case of checked exception like SQL or Filenot found we should not let the client know exact exception rather
    // show generic exp message
   public  Game startGame(List<Player> players, int sizeOfBoard,List<WinningStrategy> winningStrategies) throws PlayerCountException, BotCountException {
       Game game=Game.getGameBuilder()
               .setPlayers(players)
               .setWinningStrategies(winningStrategies)
               .setDimension(sizeOfBoard)
               .build();
       return game;

    }
    public void makeMove(Game game){
      // we should not be writting the business logic in controller deligate it to service or the game model in this case
      // Move object will be created by the player or by the bot and this Move object is passed to the Game, the Game class
     //   will validate if the Move can be made or not and it will make the move
        game.makeMove();
    }

    public GameState checkGameState(Game game){
     return game.getGameState();
    }
    public Player getWinner(Game game){
      return game.getWinner();
    }

    public void printBoard(Game game){
        game.printBoard();
    }

    public void undo(Game game){
         game.undo();
    }

}
