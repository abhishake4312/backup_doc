package strategies.botPlayingStrategy;

import models.Board;
import models.Move;

public interface BotPlayingStrategy {
  Move playingTheMove(Board board);
}
