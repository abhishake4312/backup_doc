import Exceptions.BotCountException;
import Exceptions.PlayerCountException;
import controller.GameController;
import models.*;
import strategies.winningStrategy.ColumnWinningStrategy;
import strategies.winningStrategy.DiagonalWinningStrategy;
import strategies.winningStrategy.RowWinningStrategy;
import strategies.winningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws PlayerCountException, BotCountException {
//        GameController gameController=new GameController();
//        gameController.startGame();
//
//        while(gameController.getStatus().equals("IN+PROGRESS")){
//            gameController.makeMove();
//            gameController.displayBoard();
//        }
        GameController gc = new GameController();
        Scanner sc = new Scanner(System.in);
        //now we need to create bunch of player based on the name and id coming from frontend. Frontend will not create the
        //object, it will be created by backend based on inputs from frontend
        // To take input we can implement command line design pattern but for now we will hardcode it

        int dimensions=3;
        List<Player> players = new ArrayList<Player>();
        players.add(new Player(1,"abhishek",new Symbol('X'), PlayerType.HUMAN));
   //     players.add(new Player(2,"raj",new Symbol('O'), PlayerType.BOT));
        players.add(new Bot(2,"raj",new Symbol('0'),DifficultyLevel.EASY));

        List<WinningStrategy> winningStrategies=List.of(
                new ColumnWinningStrategy(),
                new RowWinningStrategy(),
                new DiagonalWinningStrategy()
        );
        Game game=gc.startGame(players,dimensions,winningStrategies);

        while(gc.checkGameState(game).equals(GameState.IN_PROGRESS)){
            // 1) print the board
            // 2) Ask for undo
            // 3) print whose turn it is
            // 4) make move
            gc.printBoard(game);
            System.out.println("Do we want to do undo? y or n");
            String answer = sc.nextLine();
            if(answer.equalsIgnoreCase("y")){
                gc.undo(game);
                continue;
            }
            gc.makeMove(game);

        }
        System.out.println("Game has ended");
        GameState gameState=gc.checkGameState(game);
        if(gameState.equals(GameState.WIN)){
            System.out.println("Winner is"+gc.getWinner(game));
        }else{
            System.out.println("It is a draw");
        }
    }
}