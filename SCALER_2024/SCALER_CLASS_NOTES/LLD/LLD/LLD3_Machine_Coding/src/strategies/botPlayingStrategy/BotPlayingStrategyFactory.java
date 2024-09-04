package strategies.botPlayingStrategy;

import models.DifficultyLevel;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategy(DifficultyLevel difficultyLevel) {

        return new EasyPlayingStrategy();
        //TO DO for other strategy
//        if(difficultyLevel == DifficultyLevel.EASY){
//            return new EasyPlayingStrategy();
//        }else if(difficultyLevel == DifficultyLevel.HARD){
//
//        }
    }
}
