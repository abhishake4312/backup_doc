package models;

import strategies.botPlayingStrategy.BotPlayingStrategy;
import strategies.botPlayingStrategy.BotPlayingStrategyFactory;

import java.util.List;

public class Bot extends Player {
    private DifficultyLevel difficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(int id, String name, Symbol symbol, DifficultyLevel difficultyLevel) {
        super(id, name, symbol, PlayerType.BOT);
        this.difficultyLevel = difficultyLevel;
        // Bot Playing strategy should not be taken from outside based on the difficulty level of the Bot we will decide
        // which strategy we have to use
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(difficultyLevel);

    }
    public Move createMove(Board board){
      return botPlayingStrategy.playingTheMove(board);
    }
}
